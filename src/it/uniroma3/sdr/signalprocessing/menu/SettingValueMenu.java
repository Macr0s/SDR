package it.uniroma3.sdr.signalprocessing.menu;

import java.util.Map;
import java.util.Scanner;

/**
 * Questa classe implementa la modifica dei valori salvati nella mappa di 
 * settings
 * 
 * @author Filippi, Sgaraglia, Oddi
 *
 */
public class SettingValueMenu implements Menuinterface{
	
	private String key;
	private String domanda;
	private String name;
	private SettingValueMenuValidator v;

	public SettingValueMenu(String key, String domanda, String name, SettingValueMenuValidator v){
		this.key = key;
		this.domanda = domanda;
		this.name = name;
		this.v = v;
	}
	
	/**
	 * Questo metodo esegue la logica del menu
	 * 
	 * @param scanner Lo scanner per gestire l'input dell'utente
	 * @param settings La configurazione dell'applicazione
	 */
	@Override
	public void run(Scanner scanner, Map<String, Object> settings) {
		System.out.println();
		System.out.println(this.domanda + "["+settings.get(this.key)+"]");
		String s = scanner.nextLine();
		settings.put(this.key, this.v.validator(s));
	}
	
	/**
	 * Questo metodo restituisce il nome del muni
	 * 
	 * @return il nome del menu
	 */
	@Override
	public String getName() {
		return this.name;
	}

}
