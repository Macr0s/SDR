package it.uniroma3.sdr.signalprocessing.library;

import java.util.List;

import it.uniroma3.sdr.signalprocessing.library.filter.*;
import it.uniroma3.sdr.signalprocessing.library.operation.*;
import it.uniroma3.sdr.signalprocessing.library.phases.*;
import it.uniroma3.sdr.signalprocessing.model.*;

public class SignalProcessor {
	
	public static Signal convoluzione(Signal v1, Signal v2){
		return new Convoluzione(v1, v2).esegui();
	}
	
	public static Signal bandPassFilter(double band, double fc){
		return new BandPassFilter(band, fc).genera();
	}
	
	public static Signal lowPassFilter(double band){
		return new LowPassFilter(band).genera();
	}
	
	public static Signal lowPassFilter(int f1){
		return new LowPassFilter(f1).genera();
	}
	
	public static Signal lowPassFiltering(double band, Signal in){
		return new LowPassFilter(band).applica(in);
	}
	
	public static Signal espansione(Signal a, int l){
		return new Espansione(a, l).esegui();
	}
	
	public static Signal interpolazione(Signal in, int f1){
		return new Interpolazione(in, f1).esegui();
	}
	
	public static Signal decimazione(Signal in, int f2){
		return new Decimazione(in, f2).esegui();
	}
	
	public static Signal cambioTassoCampionamento(int T1, int T2, Signal signalIN){
		return new CambioTassoCampionamento(T1, T2, signalIN).esegui();
	}
	
	public static Signal ddc(Signal in, double freq, double band, int t1, int t2){
		return (Signal) new DDC(in, freq, band, t1, t2).esegui();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Double> demodulatore(Signal in){				
		return (List<Double>) new Demodulatore(in).esegui();
	}
	
	public static double energy(Signal s){
		int n = s.size();
		double zParziale =0;
		for(Complex c : s.getValues()){
			zParziale += Math.pow(c.modulo(), 2);
		}
		return zParziale*(1/n);
	}
}
