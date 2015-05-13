package it.uniroma3.sdr.signalprocessing.library;

import java.util.List;

import it.uniroma3.sdr.signalprocessing.model.Signal;

public class Detector {
	
	public static final double PFA=Math.pow(10, -3);
	private Signal s;
	private MethodDetection md;
	
	public Detector(Signal s , MethodDetection md ){
		this.s = s;
		this.md = md; 
	}
	
	public double getPropabilityDetecetion(){
		List<Signal> dividedSignal = s.divideInto(1000);
		int successi = 0;
		int i =0;
		for(Signal s: dividedSignal){
			i++; 
			System.out.println("sono ad "+ i);
			if (this.md.isSpectrumHole(s)){
				System.out.println("non c'e l'utente "+ i);
				successi++;
			}
		}
		return ((double) successi/(double) dividedSignal.size());
	}
	
}
