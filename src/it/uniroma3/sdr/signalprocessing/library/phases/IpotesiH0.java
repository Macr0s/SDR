package it.uniroma3.sdr.signalprocessing.library.phases;

import it.uniroma3.sdr.signalprocessing.model.GeneratedSignal;
import it.uniroma3.sdr.signalprocessing.model.Signal;
import it.uniroma3.sdr.signalprocessing.model.signaltype.Noise;
import it.uniroma3.sdr.signalprocessing.model.signaltype.SignalFormType;
import it.uniroma3.sdr.signalprocessing.model.utils.MathUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * La classe rappresenta la prima ipotesi binario del metodo energy detection.
 * 
 * @author Oddi,Sgaraglia,Filippi
 *
 */
public class IpotesiH0 {
	
	private double pfa;
	private double snr;
	private double soglia;
	private int sizeSegnale;
	private int numeroProve;

	public IpotesiH0(double pfa,double snr,int sizeSegnale) {
		this(pfa, snr, sizeSegnale, (int) (1/pfa));
	}
	
	public IpotesiH0(double pfa,double snr,int sizeSegnale, int numeroProve){
		this.pfa = pfa;
		this.snr = snr;
		this.sizeSegnale = sizeSegnale;
		this.numeroProve = numeroProve;
	}
	
	
	/**
	 * Calcola la soglia in base all'energia del rumore generato con un certo SNR
	 * 
	 * @return
	 * @throws Exception
	 */
	public double calcolaSoglia() throws Exception{
		List<Double> energyList = this.calcolaEnergiaNoises();
		this.soglia = this.calcolaSoglia(energyList);
		return this.soglia;
	}
	
	/**
	 * Metodo di supporto per il calcolo dell'energia di 1/pfa di rumori 
	 * generati a un determinato SNR
	 * 
	 * @return lista di energie per ogni singolo segnale di rumore
	 */
	private List<Double> calcolaEnergiaNoises() {
		List<Double> energyList = new LinkedList<>();
		SignalFormType sft = new Noise(this.snr);
		double zParziale;
		for(int i=0; i< this.numeroProve;i++){
			
			zParziale =0;
			for (int j = 0; j < this.sizeSegnale; j++){
				zParziale += Math.pow(sft.random().modulo(), 2);
			}
			
			energyList.add(((double) 1/(double) this.sizeSegnale)*zParziale);
		}
		return energyList;
	}
	
	/**
	 * Metodo di supporto che calcola la soglia avendo come input una lista
	 * di energie
	 * 
	 * @param energies la lista di energia
	 * @return	la soglia
	 * @throws Exception in caso di errore sulla funzione Math.InvErf
	 */
	private double calcolaSoglia(List<Double> energies) throws Exception{
		double valorMedio = MathUtils.valorMedio(energies);
		double varianza = MathUtils.varianza(energies,valorMedio);
		double invErf = MathUtils.InvErf(1-(2*this.pfa));
		double eta = valorMedio + ( Math.sqrt(2*varianza) * invErf);

		return eta;
	}
}