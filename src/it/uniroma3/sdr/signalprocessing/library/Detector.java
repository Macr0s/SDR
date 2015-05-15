package it.uniroma3.sdr.signalprocessing.library;

import java.util.List;

import it.uniroma3.sdr.signalprocessing.model.Signal;

/**
 * La classe detector, ricevuto da input un certo segnale ed una certa strategia
 * di "spectrum sensing", si occupa di determiare la probabilità di detection del
 * PU nel segnale ascoltato
 *  
 * @author Filippi,Oddi,Sgaraglia
 *
 */
public class Detector {
	
	private static final int NUMERO_SEZIONI = 1000;
	public static final double PFA=Math.pow(10, -4);
	private Signal s;
	private MethodDetection md;
	
	public Detector(Signal s , MethodDetection md ){
		this.s = s;
		this.md = md; 
	}
	
	/**
	 * il metodo determina la probabilità  di detection dell'utente primario 
	 * sul segnale, ispezionandolo n campioni per volta
	 * 
	 * @return probabilità di detection
	 * 
	 */
	public double getPropabilityDetecetion(){
		List<Signal> dividedSignal = s.divideInto(NUMERO_SEZIONI);
		int successi = 0;
		for(Signal s: dividedSignal){
			if (!this.md.isSpectrumHole(s)){
				successi++;
			}
		}
		return ((double) successi/(double) dividedSignal.size() * 100);
	}
	
}
