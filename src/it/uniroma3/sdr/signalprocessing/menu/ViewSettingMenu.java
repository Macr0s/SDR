package it.uniroma3.sdr.signalprocessing.menu;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Questa classe gestisce la visualizzazione delle impostazioni
 * 
 * @author Filippi, Sgaraglia, Oddi
 *
 */
public class ViewSettingMenu implements Menuinterface {
	
	/**
	 * Questo metodo esegue la logica del menu
	 * 
	 * @param scanner Lo scanner per gestire l'input dell'utente
	 * @param settings La configurazione dell'applicazione
	 */
	@Override
	public void run(Scanner scanner, Map<String, Object> settings) {
		System.out.println();
		for(Entry<String, Object> e: settings.entrySet()){
			System.out.println("["+e.getKey()+"] " + e.getValue().toString());
		}

	}
	
	/**
	 * Questo metodo restituisce il nome del muni
	 * 
	 * @return il nome del menu
	 */
	@Override
	public String getName() {
		return "Visualizza le impostazioni";
	}

}
