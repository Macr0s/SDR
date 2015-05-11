package it.uniroma3.sdr.signalprocessing.model;

import it.uniroma3.sdr.signalprocessing.model.signaltype.SignalFormType;

public class GeneratedSignal extends Signal {
	
	public GeneratedSignal(int length, SignalFormType t){
		super(length);
		for(int i = 0; i < length; i++){
			this.add(i, t.random());
		}
	}
}
