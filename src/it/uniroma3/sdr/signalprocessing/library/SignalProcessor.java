package it.uniroma3.sdr.signalprocessing.library;

import it.uniroma3.sdr.signalprocessing.model.*;
/**
 * Questa classe implementa metodi di servizio per il processing dei segnali
 * 
 * @author Filippi,Oddi,Sgaraglia
 *
 */
public class SignalProcessor {
	
	/**
	 * Metodo che applicata ad un segnale s restituisce l'energia ad esso associata.
	 * 
	 * @param s segnale
	 * @return energia
	 */
	public static double energy(Signal s){
		int n = s.size();
		double zParziale =0;
		for(Complex c : s.getValues()){
			zParziale += Math.pow(c.modulo(), 2);
		}
		return ((double)1/(double)n)*zParziale;
	}

	
}
