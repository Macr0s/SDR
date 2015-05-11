package it.uniroma3.sdr.signalprocessing.library.phases;

import it.uniroma3.sdr.signalprocessing.library.SignalProcessor;
import it.uniroma3.sdr.signalprocessing.model.Complex;
import it.uniroma3.sdr.signalprocessing.model.Signal;

public class DDC implements Phase {
	
	private Signal in;
	private double freq;
	private double band;
	private int t1;
	private int t2;

	public DDC(Signal in, double freq, double band, int t1, int t2){
		this.in = in;
		this.freq = freq;
		this.band = band;
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public Object esegui() {
		double omega = Math.PI * freq;
		Signal out = new Signal(in);
		if (freq != 0){
			for(int n = 0; n < out.size(); n++){
				Complex esp_compless = new Complex(Math.cos(omega*n), Math.sin(omega*n));
				out.add(n, out.get(n).prodotto(esp_compless));
			}
		}else{
			Signal filtrato = SignalProcessor.lowPassFiltering(band, out);
			out = SignalProcessor.cambioTassoCampionamento(t1, t2, filtrato);
		}
		return out;
	}

}
