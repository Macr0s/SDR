package it.uniroma3.sdr.signalprocessing.library.phases;


import it.uniroma3.sdr.signalprocessing.model.Signal;
;

/**
 * la classe determina la probabilità di detection di un segnale avendo
 *  la lista di segnali su cui eseguire calcoli 
 * 
 * @author Sgaraglia, Filippi, Oddi
 *
 */
public class IpotesiH1 {

	/**
	 * Metodo che dato una soglia e un segnale verifica se nel segnale è 
	 * presente uno spectrum hole
	 * 
	 * @param soglia La soglia calcolata nell'ipotesi h0
	 * @param signal Il segnale da verificare
	 * @return true se non c'è l'utente primario altrimenti restituisce false
	 */
	public boolean isSpectrumHole(double soglia, Signal signal) {
		double en =signal.energy();
		return en<soglia; 
		
	}

	
	
}
