package it.uniroma3.sdr.signalprocessing.library.type;

import it.uniroma3.sdr.signalprocessing.model.Complex;

public class SincSignal implements SignalType{
	
	private double band;
	
	public SincSignal(double band){
		this.band = band;
	}

	@Override
	public Complex get(int i) {
		double res;
		
		if (i==0)
			res = 1;
		else if (i%(1/this.band) == 0)
			res = 0;
		else
			res = Math.sin(Math.PI * this.band * i) / (Math.PI * this.band * i);
		
		return new Complex(res, 0);
	}

}
