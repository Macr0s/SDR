package it.uniroma3.sdr.signalprocessing.library.filter;

import it.uniroma3.sdr.signalprocessing.model.Signal;

public abstract class Filter {
	
	abstract public Signal genera();
	
	public Signal applica(Signal in){
		return in.convolviCon(this.genera());
	}
}
