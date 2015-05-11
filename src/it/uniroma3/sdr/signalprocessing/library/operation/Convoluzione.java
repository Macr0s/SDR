package it.uniroma3.sdr.signalprocessing.library.operation;

import it.uniroma3.sdr.signalprocessing.model.Signal;

public class Convoluzione implements Operation {
	
	private Signal v1;
	private Signal v2;

	public Convoluzione(Signal v1, Signal v2){
		this.v1 = v1;
		this.v2 = v2;
	}

	@Override
	public Signal esegui() {
		int n = v1.size() + v2.size() - 1;
		Signal result = new Signal(n);
		
		for(int k =  0; k < n; k++){
			int up = Math.min(k, v2.size() -1);
			int lower = Math.max(0, k - v2.size() + 1);
			
			for(int j = lower; j <= up; j++){
				result.add(k, result.get(k).sum(v1.get(k - j).prodotto(v2.get(j))));
			}
		}
		return result;
	}

}
