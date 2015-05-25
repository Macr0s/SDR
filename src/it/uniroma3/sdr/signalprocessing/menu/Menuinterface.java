package it.uniroma3.sdr.signalprocessing.menu;

import java.util.Map;
import java.util.Scanner;

/**
 * Questa classe implementa un menu generico
 * 
 * @author Filippi, Sgaraglia, Oddi
 *
 */
public interface Menuinterface {
	
	/**
	 * Questo metodo esegue la logica del menu
	 * 
	 * @param scanner Lo scanner per gestire l'input dell'utente
	 * @param settings La configurazione dell'applicazione
	 */
	public void run(Scanner scanner, Map<String, Object> settings);
	
	/**
	 * Questo metodo restituisce il nome del muni
	 * 
	 * @return il nome del menu
	 */
	public String getName();
	
}
