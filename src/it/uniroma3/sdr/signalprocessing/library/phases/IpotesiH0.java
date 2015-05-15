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

	public IpotesiH0(double pfa,double snr,int sizeSegnale) {
		this.pfa = pfa;
		this.snr = snr;
		this.sizeSegnale=sizeSegnale;
	}
	
	
	/**
	 * calcola la soglia in base all'energia del rumore generato con un certo SNR
	 * 
	 * @return
	 * @throws Exception
	 */
	public double calcolaSoglia() throws Exception{
		List<Double> energyList = this.calcolaEnergiaNoises();
		this.soglia = this.calcolaSoglia(energyList, this.pfa);
		return this.soglia;
	}
	

	private List<Double> calcolaEnergiaNoises() {
		List<Double> energyList = new LinkedList<>();
		double quantita = 1/pfa;
		SignalFormType nois = new Noise(this.snr);
		for(int i=0; i<quantita;i++){
			Signal noise = new GeneratedSignal(this.sizeSegnale, nois);
			energyList.add(noise.energy());
		}
		return energyList;
	}
	
	private double calcolaSoglia(List<Double> energies,double pfa) throws Exception{

		double valorMedio = MathUtils.valorMedio(energies);
		double varianza = MathUtils.varianza(energies,valorMedio);
		double invErf = MathUtils.InvErf(1-(2*pfa));
		double eta = valorMedio + ( Math.sqrt(2*varianza) * invErf);

		return eta;
	}
}