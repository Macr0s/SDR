package it.uniroma3.sdr.signalprocessing.library.operation;

import it.uniroma3.sdr.signalprocessing.library.SignalProcessor;
import it.uniroma3.sdr.signalprocessing.model.Signal;

public class CambioTassoCampionamento implements Operation {
	
	private int T1;
	private int T2;
	private Signal signalIN;

	public CambioTassoCampionamento(int T1, int T2, Signal signalIN){
		this.T1 = T1;
		this.T2 = T2;
		this.signalIN = signalIN;
	}
	

	private int MCD(int a, int b){
		if (a < b)
			return this.MCD(b,a);
		else if (b == 0)
			return a;
		else
			return this.MCD(b, a % b);
	}

	private int getMCD(int a, int b){
		a = Math.abs(a);
		b = Math.abs(b);
		return this.MCD(a,b);
	}
		
	private int[] getParametri(int t1, int t2) {
		int k = this.getMCD(t1, t2);
		
		return new int[]{
				t1/k,
				t2/k
		};
	}

	@Override
	public Signal esegui() {
		int[] fattori = getParametri(T1, T2);
		int f1 = fattori[0];
		int f2 = fattori[1];
		
		Signal signalOut = null;
		if (f1 == 1 && f2 ==1)
			signalOut = signalIN;
		else if (f1 == 1)
			signalOut = SignalProcessor.decimazione(signalIN, f2);
		else if (f2 == 1) {
			Signal seq_espansa = SignalProcessor.espansione(signalIN, f1);
			signalOut = SignalProcessor.interpolazione(seq_espansa, f1);
		} else{
			Signal espanso = SignalProcessor.espansione(signalIN, f1);
			Signal intepolato = SignalProcessor.interpolazione(espanso, f1);
			signalOut = SignalProcessor.decimazione(intepolato, f2);
		}
		return signalOut;
	}

}
