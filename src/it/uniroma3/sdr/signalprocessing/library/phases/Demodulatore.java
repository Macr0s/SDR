package it.uniroma3.sdr.signalprocessing.library.phases;

import java.util.ArrayList;

import it.uniroma3.sdr.signalprocessing.model.Complex;
import it.uniroma3.sdr.signalprocessing.model.Signal;

public class Demodulatore implements Phase {
	
	private Signal in;

	public Demodulatore(Signal in){
		this.in = in;
	}

	@Override
	public Object esegui() {
		ArrayList<Double> a = new ArrayList<Double>(in.size());
		
		Complex coniugato = in.get(in.size() -1).coniugato();
		Complex primo = in.get(0).prodotto(coniugato);
		a.add(0, primo.fase());
		
		for(int i = 1; i < in.size(); i++){
			coniugato = in.get(i - 1).coniugato();
			primo = in.get(i).prodotto(coniugato);
			a.add(i, primo.fase());
		}
		return a;
	}

}
