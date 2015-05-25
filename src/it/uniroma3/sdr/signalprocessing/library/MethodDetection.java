package it.uniroma3.sdr.signalprocessing.library;

import it.uniroma3.sdr.signalprocessing.model.Signal;

public interface MethodDetection {
	/**
	 * Metodo che datoun segnale verifica se nel segnale è 
	 * presente uno spectrum hole
	 * 
	 * @param signal Il segnale da verificare
	 * @return true se non c'è l'utente primario altrimenti restituisce false
	 */
	public boolean isSpectrumHole(Signal signal);
}
