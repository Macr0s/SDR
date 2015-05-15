package it.uniroma3.sdr.signalprocessing.library.phases;


import it.uniroma3.sdr.signalprocessing.model.Signal;
;

/**
 * la classe determina la probabilità di detection di un segnale avendo
 *  la lista di segnali su cui eseguire calcoli 
 * 
 * @author Alex
 *
 */
public class IpotesiH1 {


	public boolean isSpectrumHole(double soglia, Signal signal) {
		double en =signal.energy();
		return en<soglia; 
		
	}

	
	
}
