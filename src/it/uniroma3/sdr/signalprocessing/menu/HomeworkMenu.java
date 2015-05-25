package it.uniroma3.sdr.signalprocessing.menu;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

import it.uniroma3.sdr.signalprocessing.model.Signal;

/**
 * Questa classe implementa la simulazione del calcolo dell'energy detection
 * su una seguenza di file pre-calcolate
 * 
 * @author Macr0s
 *
 */
public class HomeworkMenu extends TestMenu{
	
	private Map<String, Object> settings;
	
	/**
	 * Esegue il test dell'energy detection su un determinato file
	 * 
	 * @param f il file su cui eseguire il test
	 * @throws Exception
	 */
	public void testOnFile(File f) throws Exception{
		long start = System.currentTimeMillis() / 1000;
		
		Signal s = Signal.createFromFile(f);
		
		double snr = s.snrCalculator();
		
		System.out.println("SNR: "+snr + " dB");
		
		commonTest(s, snr, settings);
		
		this.durata(start, System.currentTimeMillis() / 1000);
	}
	
	
	public void prepara(int i,int j, String dir) throws Exception{
		System.out.println();
		System.out.println("[Sequenza_"+i+" - output_"+j+"]");
		testOnFile(new File(dir + "/Sequenza_"+i+"/output_"+j+".dat"));
		System.out.println();
	}
	
	/**
	 * Questo metodo esegue la logica del menu
	 * 
	 * @param scanner Lo scanner per gestire l'input dell'utente
	 * @param settings La configurazione dell'applicazione
	 */
	@Override
	public void run(Scanner scanner, Map<String, Object> settings) {
		System.out.println("Inserisci la cartella: ");
		String dir = scanner.nextLine().trim();
		
		this.settings = settings;
		
		for(int i = 1; i <= 4;i++){
			if (i == 2) continue;
			for (int j = 1; j <=3; j++){
				try {
					this.prepara(j,i, dir);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Questo metodo restituisce il nome del muni
	 * 
	 * @return il nome del menu
	 */
	@Override
	public String getName() {
		return "Esegui test su sequenze";
	}

}
