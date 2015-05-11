package it.uniroma3.sdr.signalprocessing.model.signaltype;

import it.uniroma3.sdr.signalprocessing.model.Complex;

public class QPSK implements SignalFormType {

	@Override
	public Complex random() {
		double v = Math.random();
		double reale;
		double immaginaria;
		
		if (v < 0.5)
			reale = 1/Math.sqrt(2); 
		else
			reale = -1/Math.sqrt(2);
		
		double p = Math.random();
		if (p < 0.5)
			immaginaria = 1/Math.sqrt(2); 
		else
			immaginaria = -1/Math.sqrt(2);
		
		return new Complex(reale, immaginaria);
	}

}
