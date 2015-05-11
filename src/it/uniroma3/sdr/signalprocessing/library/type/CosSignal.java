package it.uniroma3.sdr.signalprocessing.library.type;

import it.uniroma3.sdr.signalprocessing.model.Complex;

public class CosSignal implements SignalType {
	
	private double fc;
	
	public CosSignal(double fc){
		this.fc = fc;
	}

	@Override
	public Complex get(int i) {
		double real = Math.cos(2 *Math.PI * this.fc * i);
		return new Complex(real, 0);
	}

}
