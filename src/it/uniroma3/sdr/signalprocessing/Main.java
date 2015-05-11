package it.uniroma3.sdr.signalprocessing;

import it.uniroma3.sdr.signalprocessing.model.GeneratedSignal;
import it.uniroma3.sdr.signalprocessing.model.Signal;
import it.uniroma3.sdr.signalprocessing.model.signaltype.Noise;
import it.uniroma3.sdr.signalprocessing.model.signaltype.QPSK;
import it.uniroma3.sdr.signalprocessing.model.signaltype.SignalFormType;

public class Main {

	public static void main(String[] args) {
		
		SignalFormType noiseType = new QPSK();
		Signal noise = new GeneratedSignal(10000, noiseType);
	}

}
