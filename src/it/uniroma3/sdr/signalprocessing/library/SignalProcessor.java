package it.uniroma3.sdr.signalprocessing.library;

import it.uniroma3.sdr.signalprocessing.model.*;

public class SignalProcessor {
	public static double energy(Signal s){
		int n = s.size();
		double zParziale =0;
		for(Complex c : s.getValues()){
			zParziale += Math.pow(c.modulo(), 2);
		}
		return (1/n)*zParziale;
	}

	
}
