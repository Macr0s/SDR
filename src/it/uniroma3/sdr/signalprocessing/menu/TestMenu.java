package it.uniroma3.sdr.signalprocessing.menu;

import java.util.Map;

import it.uniroma3.sdr.signalprocessing.library.Detector;
import it.uniroma3.sdr.signalprocessing.library.phases.EnergyDetection;
import it.uniroma3.sdr.signalprocessing.model.Signal;

/**
 * Questa classe gestisce il codice di base dei test sui segnali
 * 
 * @author Filippi, Sgaraglia, Oddi
 *
 */
public abstract class TestMenu implements Menuinterface {
	
	/**
	 * Questo metodo implementa il test sul segnale dato il segnale e  un determinato
	 * SNR. La mappa di impostazioni serve per determinare il numero di prove 
	 * da eseguire
	 * 
	 * @param s il segnale
	 * @param snr l'SNR
	 * @param settings le impostazioni del sistema
	 * @throws Exception
	 */
	public void commonTest(Signal s, double snr, Map<String, Object> settings) throws Exception{
		Integer i = (Integer)(settings.get("numeroTest"));
		
		EnergyDetection md = new EnergyDetection(snr, Detector.PFA, s.size(), i.intValue());
		Detector d = new Detector(s, md);
		
		System.out.println("Soglia: " + md.getEta());
		System.out.println("PD: " +d.getPropabilityDetecetion() + "%");
	}
	
	/**
	 * Questo metodo stampa la durata del test dato l'istante inizio e 
	 * quello finale del test
	 * 
	 * @param start l'istante iniziale
	 * @param stop	l'istante finale
	 */
	public void durata(long start, long stop){
		long durata = stop - start;
		long secondi = durata % 60;
		long minuti = durata / 60;
		
		System.out.println("Durata: " + minuti + "m " + secondi + "s");
	}

}
