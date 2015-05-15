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
		Signal s = Signal.createFromFile(f);
		
		double snr = s.snrCalculator();
		
		System.out.println("SNR: "+snr);
		
		EnergyDetection md = new EnergyDetection(snr, Detector.PFA, s.size(),1000);
		Detector d = new Detector(s, md);
		
		System.out.println("Soglia: " + md.getEta());
		System.out.println("PD: " +d.getPropabilityDetecetion() + "%");
		
	}
	
	public static void prepara(int i,int j) throws Exception{
		System.out.println("Sequenza_"+i+" - output_"+j+"");
		test(new File("./Sequenze_SDR_2015/Sequenza_"+i+"/output_"+j+".dat"));
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		
//		for(int i = -20; i <= 20; i++){
//			System.out.print(i + " ");
//			int successi = 0;
//			int max = 10000;
//			for (int j = 0; j < max; j++){
//				GeneratedSignal s = new GeneratedSignal(1000, new Noise(i));
//				GeneratedSignal s2 = new GeneratedSignal(1000, new QPSK());
//				int snr = (int) Math.round(s.somma(s2).snrCalculator());
//				
//				if (snr == i) successi++;
//			}
//			double p = ((double) successi / (double) max)*100;
//			System.out.println(p + " %");
//		}
		
		for(int i = 1; i <= 3;i++){
			for (int j = 1; j <=4; j++){
				prepara(i,j);
			}
		}
	}

}
