package it.uniroma3.sdr.signalprocessing.library.filter;

import it.uniroma3.sdr.signalprocessing.library.type.CosSignal;
import it.uniroma3.sdr.signalprocessing.library.type.SincSignal;
import it.uniroma3.sdr.signalprocessing.model.Complex;
import it.uniroma3.sdr.signalprocessing.model.Signal;

public class BandPassFilter extends Filter {
	
	private double band;
	private double freqCampionamento;

	public BandPassFilter(double band, double freqCampionamento){
		this.band = band;
		this.freqCampionamento = freqCampionamento;
	}

	@Override
	public Signal genera() {
		int numCampioni = (int) (2 * ( 5 / band) +1);
		Signal out = new Signal(numCampioni);
		
		int center = numCampioni / 2;
		
		SincSignal sinc = new SincSignal(band);
		CosSignal cos = new CosSignal(freqCampionamento);
		
		out.add(center, new Complex(2*band, 0));
		
		for (int i = 1; i <= center; i++){
			Complex v = sinc.get(i).prodotto(cos.get(i)).scalare(band*2);
			out.add(center + i, v);
			out.add(center - 1, v);
		}
		return out;
	}

}
