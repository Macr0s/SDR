package it.uniroma3.sdr.signalprocessing.library.operation;

import it.uniroma3.sdr.signalprocessing.library.SignalProcessor;
import it.uniroma3.sdr.signalprocessing.model.Signal;

public class Interpolazione implements Operation {
	
	private Signal in;
	private int f1;

	public Interpolazione(Signal in, int f1){
		this.in = in;
		this.f1 = f1;
	}

	@Override
	public Signal esegui() {
		Signal lpf = SignalProcessor.lowPassFilter(f1);
		Signal interpolato = in.convolviCon(lpf);
		Signal b = new Signal(in.size());
		
		int n = (lpf.size() - 1) /2;
		int j = 0;
			
		for(int i = n; i < interpolato.size() - n; i++){
			b.add(j, interpolato.get(i));
			j++;
		}
		
		return b;
	}

}
