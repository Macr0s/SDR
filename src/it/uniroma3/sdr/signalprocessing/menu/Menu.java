package it.uniroma3.sdr.signalprocessing.menu;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Questa classe implementa la gestione di un menu multi-item generico
 * 
 * @author Filippi, Sgaraglia, Oddi
 *
 */
public class Menu implements Menuinterface {
	
	private List<Menuinterface> menus;
	private String name;

	public Menu(String name, List<Menuinterface> menus){
		this.menus = menus;
		this.name = name;
	}

	/**
	 * Questo metodo esegue la logica del menu
	 * 
	 * @param scanner Lo scanner per gestire l'input dell'utente
	 * @param settings La configurazione dell'applicazione
	 */
	@Override
	public void run(Scanner scanner, Map<String, Object> settings) {
		boolean status = true;
		
		while(status){
			System.out.println("Cosa vuoi fare?");
			System.out.println();
			
			int i = 0;
			for(Menuinterface m: this.menus){
				System.out.print(i);
				System.out.print(" -> ");
				System.out.println(m.getName());
				i++;
			}
			
			System.out.println("x -> Esci dal menu");
			
			System.out.println();
			
			System.out.println("Scelta?");
			String s = scanner.nextLine();
			
			if (s.equals("x")) return;
			
			System.out.println();
			
			try{
				this.menus.get(Integer.parseInt(s)).run(scanner, settings);
			}catch(NumberFormatException  ex){
				status = false;
			} catch (Exception e) {
				status = false;
			}
			System.out.println();
		}

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
