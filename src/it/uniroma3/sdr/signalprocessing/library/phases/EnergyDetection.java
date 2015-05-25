package it.uniroma3.sdr.signalprocessing.library.phases;

import it.uniroma3.sdr.signalprocessing.library.MethodDetection;
import it.uniroma3.sdr.signalprocessing.model.Signal;

/**
 * La classe implementa un metodo di detection basato sull'analisi del rapporto fra l'energia del segnale e quella del rumore
 * 
 * @author Sgaraglia,Filippi,Oddi
 *
 */
public class EnergyDetection implements MethodDetection{
	private IpotesiH0 h0;
	private IpotesiH1 h1;
	private double soglia;
	private boolean sogliaCalcolata = false;

	public EnergyDetection(double snr, double pfa, int noiseSize){
		this.h0 = new IpotesiH0(pfa, snr, noiseSize); 
		this.h1 = new IpotesiH1(); 
	}
	
	public EnergyDetection(double snr, double pfa, int noiseSize, int numeroTest){
		this.h0 = new IpotesiH0(pfa, snr, noiseSize, numeroTest); 
		this.h1 = new IpotesiH1(); 
	}

	/**
	 * Metodo che calcola la soglia di una trasmissione utilizzano l'ipotesi h0
	 * (nota dei programmatori: in greco η = eta )
	 * @return
	 * @throws Exception 
	 */
	public double getEta() throws Exception {
		if (!this.sogliaCalcolata){
			this.soglia= this.h0.calcolaSoglia();
			this.sogliaCalcolata = true;
		}
		return soglia;
	}

	/**
	 * Metodo che verifica se c'è uno specrtum hole
	 */
	@Override
	public boolean isSpectrumHole(Signal signal) {
		if (!this.sogliaCalcolata){
			try {
				this.getEta();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		return this.h1.isSpectrumHole(this.soglia,signal);
	}
}
