package it.uniroma3.sdr.signalprocessing;

import java.io.File;
import it.uniroma3.sdr.signalprocessing.library.Detector;
import it.uniroma3.sdr.signalprocessing.library.phases.EnergyDetection;
import it.uniroma3.sdr.signalprocessing.model.GeneratedSignal;
import it.uniroma3.sdr.signalprocessing.model.Signal;
import it.uniroma3.sdr.signalprocessing.model.signaltype.Noise;
import it.uniroma3.sdr.signalprocessing.model.signaltype.QPSK;
import it.uniroma3.sdr.signalprocessing.model.signaltype.SignalFormType;

public class Main {

	public static void test(File f) throws Exception{
		long start = System.currentTimeMillis() / 1000;
		
		Signal s = Signal.createFromFile(f);
		
		double snr = s.snrCalculator();
		
		System.out.print("\t"+snr);
		
		EnergyDetection md = new EnergyDetection(snr, Detector.PFA, s.size(), 10000);
		Detector d = new Detector(s, md);
		
		System.out.print("\t" + md.getEta());
		System.out.print("\t" +d.getPropabilityDetecetion() + "%");
		
		durata(start, System.currentTimeMillis() / 1000);
	}
	
	public static void durata(long start, long stop){
		long durata = stop - start;
		long secondi = durata % 60;
		long minuti = durata / 60;
		
		System.out.println("\t " + minuti + "m " + secondi + "s");
	}
	
	public static void prepara(int i,int j) throws Exception{
		System.out.print("Sequenza_"+i+" - output_"+j+"");
		test(new File("./Sequenze_SDR_2015/Sequenza_"+i+"/output_"+j+".dat"));
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("File \t SNR \t Soglia \t PD \t Durata");
		for(int i = 1; i <= 4;i++){
			if (i == 2) continue;
			for (int j = 1; j <=3; j++){
				prepara(j,i);
			}
		}
	}

}
