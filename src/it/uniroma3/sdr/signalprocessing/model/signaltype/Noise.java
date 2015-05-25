package it.uniroma3.sdr.signalprocessing.model.signaltype;

import it.uniroma3.sdr.signalprocessing.model.Complex;

import java.util.Random;

/**
 * Classe che implementa la forma del segnale di rumore
 * 
 * @author Oddi, Filippi, Sgaraglia
 *
 */
public class Noise implements SignalFormType {
	
	private double snr;
	private double pot_rumore;

	public Noise(double snr){
		this.snr = snr;
		Double snr_linearizzato = Math.pow(10, (this.snr/10));
		this.pot_rumore = (1/snr_linearizzato);
	}

	@Override
	public Complex random() {
		Random campione =null;
		
		campione = new Random();
		double reale = campione.nextGaussian() * Math.sqrt(pot_rumore/(double)2);
		
		campione = new Random();
		double immaginaria = campione.nextGaussian() * Math.sqrt(pot_rumore/(double)2);
		 
		return new Complex(reale, immaginaria);
	}

}
