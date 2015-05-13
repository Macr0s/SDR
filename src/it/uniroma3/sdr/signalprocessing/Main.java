package it.uniroma3.sdr.signalprocessing;

import java.io.File;

import it.uniroma3.sdr.signalprocessing.library.Detector;
import it.uniroma3.sdr.signalprocessing.library.phases.EnergyDetection;
import it.uniroma3.sdr.signalprocessing.model.GeneratedSignal;
import it.uniroma3.sdr.signalprocessing.model.Signal;
import it.uniroma3.sdr.signalprocessing.model.signaltype.QPSK;
import it.uniroma3.sdr.signalprocessing.model.signaltype.SignalFormType;

public class Main {

	public static void test(File f) throws Exception{
		System.out.println("Lettura Segnale");
		
		Signal s = Signal.createFromFile(f);
		
		System.out.println("Test su file" +  f.getName());
		
		double snr = s.snrCalculator();
		
		System.out.println("SNR: "+snr);
		System.out.println("Lunghezza Segnale: " + s.size());
		
		EnergyDetection md = new EnergyDetection(snr, Detector.PFA, s.size());
		Detector d = new Detector(s, md);
		
		System.out.println("Soglia: " + md.getEta());
		System.out.println("PD: " +d.getPropabilityDetecetion());
		
	}
	
	public static void main(String[] args) throws Exception {
		
		test(new File("/Volumes/Mac Data/Dropbox/Codes/SDR Codes/SDR_AAF/Sequenze_SDR_2015/Sequenza_1/output_2.dat"))
	;}

}
