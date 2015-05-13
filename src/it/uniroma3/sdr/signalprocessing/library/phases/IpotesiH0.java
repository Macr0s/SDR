package it.uniroma3.sdr.signalprocessing.library.phases;

import it.uniroma3.sdr.signalprocessing.model.GeneratedSignal;
import it.uniroma3.sdr.signalprocessing.model.Signal;
import it.uniroma3.sdr.signalprocessing.model.signaltype.Noise;
import it.uniroma3.sdr.signalprocessing.model.signaltype.SignalFormType;
import it.uniroma3.sdr.signalprocessing.model.utils.MathUtils;

import java.util.LinkedList;
import java.util.List;

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
	
	
	public double calcolaSoglia() throws Exception{
		List<Signal> noiseList = this.generaNoises(1/pfa,snr);
		List<Double> energyList = this.calcolaEnergiaNoises(noiseList);
		this.soglia = this.calcolaSoglia(energyList, this.pfa);
		return this.soglia;
	}
	
	
	private List<Signal> generaNoises(double quantita,double snr) {
		List<Signal> noiseList = new LinkedList<>();
		SignalFormType nois = new Noise(quantita);
		Signal noise;
		for(int i=0; i<quantita;i++){
			noise = new GeneratedSignal(this.sizeSegnale, nois);
			noiseList.add(noise);
		}
		return noiseList;
	}

	private List<Double> calcolaEnergiaNoises(List<Signal> noiseList) {
		List<Double> energyList = new LinkedList<>();
		for(Signal noise : noiseList){
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