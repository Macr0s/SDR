package it.uniroma3.sdr.signalprocessing.menu;

import java.util.Map;
import java.util.Scanner;

import it.uniroma3.sdr.signalprocessing.model.GeneratedSignal;
import it.uniroma3.sdr.signalprocessing.model.Signal;
import it.uniroma3.sdr.signalprocessing.model.signaltype.Noise;
import it.uniroma3.sdr.signalprocessing.model.signaltype.QPSK;

/**
 * Questa classe implementa la logica del simulatore di energy detection su 
 * un nuovo segnale generato sul momento
 * 
 * @author Filippi, Sgaraglia, Oddi
 *
 */
public class SimulateMenu extends TestMenu {
	
	/**
	 * Questo metodo esegue la logica del menu
	 * 
	 * @param scanner Lo scanner per gestire l'input dell'utente
	 * @param settings La configurazione dell'applicazione
	 */
	@Override
	public void run(Scanner scanner, Map<String, Object> settings) {
		System.out.println("Inserisci la lunghezza del segnale: ");
		int length = scanner.nextInt();
		
		System.out.println("Inserisci l'snr: ");
		double snr = scanner.nextDouble();
		
		System.out.println();
		
		long start = System.currentTimeMillis() / 1000;
		Signal s = new GeneratedSignal(length, new QPSK());
		s = s.somma(new GeneratedSignal(length, new Noise(snr)));
		
		try {
			commonTest(s, snr, settings);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.durata(start, System.currentTimeMillis() / 1000);
	}
	
	/**
	 * Questo metodo restituisce il nome del muni
	 * 
	 * @return il nome del menu
	 */
	@Override
	public String getName() {
		return "Esegui test su un segnale generato";
	}

}
