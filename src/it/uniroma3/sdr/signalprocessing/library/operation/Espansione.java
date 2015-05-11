package it.uniroma3.sdr.signalprocessing.library.operation;

import it.uniroma3.sdr.signalprocessing.model.Complex;
import it.uniroma3.sdr.signalprocessing.model.Signal;

public class Espansione implements Operation {
	
	private Signal a;
	private int l;

	public Espansione(Signal a, int l){
		this.a = a;
		this.l = l;
	}

	@Override
	public Signal esegui() {
		int nuovaLunghezza = a.size() * l;
		
		int j = 0;
		Signal b = new Signal(nuovaLunghezza);
		for(int i = 0; i < nuovaLunghezza; i ++){
			if(i % l == 0){
				b.add(i, a.get(j));
				j++;
			}else{
				b.add(i, new Complex(0,0));
			}
		}
		return b;
	}

}
