package it.uniroma3.sdr.signalprocessing.library.filter;

import it.uniroma3.sdr.signalprocessing.library.type.SincSignal;
import it.uniroma3.sdr.signalprocessing.model.Complex;
import it.uniroma3.sdr.signalprocessing.model.Signal;

public class LowPassFilter extends Filter {

	private double band;
	private boolean normal;
	
	public LowPassFilter(double band){
		this.setBand(band);
	}
	
	public LowPassFilter(int f1){
		this.setF1(f1);
	}

	@Override
	public Signal genera() {	
		int numCampioni = (int) (2 * ( 5 / band) +1);
		Signal b = new Signal(numCampioni);
		
		int center = numCampioni / 2;
		
		SincSignal sinc = new SincSignal(band);
		
		b.add(center, new Complex((this.normal)? band : 1, 0));
		
		for (int i = 1; i <= center; i++){	
			Complex v = sinc.get(i).scalare((this.normal)? band : 1);
			b.add(center + i, v);
			b.add(center - 1, v);
		}
		return b;
	}
	
	public void setBand(double band){
		this.band = band;
		this.normal = true;
	}

	public void setF1(int f1){
		this.band = 1 / (double) f1;
		this.normal = false;
	}
}
