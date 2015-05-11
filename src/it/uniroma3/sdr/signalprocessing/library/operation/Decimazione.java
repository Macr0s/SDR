package it.uniroma3.sdr.signalprocessing.library.operation;

import it.uniroma3.sdr.signalprocessing.model.Signal;

public class Decimazione implements Operation {
	
	private Signal in;
	private int f2;

	public Decimazione(Signal in, int f2){
		this.in = in;
		this.f2 = f2;
	}

	@Override
	public Signal esegui() {
		if (f2 == 1){
			return in;
		}
		
		int j = 0;
		int lunghezzaDecimato = in.size() / f2;
		Signal decimato = new Signal(lunghezzaDecimato);
		
		for(int i = 0; i < in.size() && j < lunghezzaDecimato; i++){
			if (i % f2 == 0){
				decimato.add(j, in.get(i));
				j++;
			}
		}
		
		return decimato;
	}

}
