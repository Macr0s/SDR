package it.uniroma3.sdr.signalprocessing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import it.uniroma3.sdr.signalprocessing.menu.HomeworkMenu;
import it.uniroma3.sdr.signalprocessing.menu.Menu;
import it.uniroma3.sdr.signalprocessing.menu.Menuinterface;
import it.uniroma3.sdr.signalprocessing.menu.SettingValueMenu;
import it.uniroma3.sdr.signalprocessing.menu.SettingValueMenuValidator;
import it.uniroma3.sdr.signalprocessing.menu.SimulateMenu;
import it.uniroma3.sdr.signalprocessing.menu.ViewSettingMenu;

public class Main {
	
	private Scanner scanner;
	
	public Main(){
		this.scanner = new Scanner(System.in);
	}
	
	public Map<String, Object> getDefaultSetting(){
		Map<String, Object> settings = new HashMap<>();
		
		settings.put("numeroTest", 1000);
		
		return settings;
	}
	
	public void run(){
		List<Menuinterface> mainMenu = new LinkedList<>();
		mainMenu.add(new HomeworkMenu());
		mainMenu.add(new SimulateMenu());
		
		List<Menuinterface> settingMenu = new LinkedList<>();
		mainMenu.add(new Menu("Entra nel menu delle impostrazioni", settingMenu));
		
		settingMenu.add(new ViewSettingMenu());
		
		SettingValueMenuValidator v = new SettingValueMenuValidator(){

			@Override
			public Object validator(String s) {
				return Integer.parseInt(s);
			}
			
		};
		
		settingMenu.add(new SettingValueMenu("numeroTest", 
				"Inserisci il numero di prova", 
				"Modifica il numero di prova", v));
		
		Menuinterface m = new Menu("Menu principale", mainMenu);
		m.run(scanner, getDefaultSetting());
	}
	
	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.run();
	}

}
