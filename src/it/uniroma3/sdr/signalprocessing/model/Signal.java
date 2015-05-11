package it.uniroma3.sdr.signalprocessing.model;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.uniroma3.sdr.signalprocessing.library.SignalProcessor;
import it.uniroma3.sdr.signalprocessing.library.SignalUtils;
import it.uniroma3.sdr.signalprocessing.library.type.SignalType;

public class Signal implements SignalType {
	private List<Complex> values;
	
	public Signal(){
		this.values = new LinkedList<>();
	}
	
	public Signal(int lunghenza){
		this.values = new ArrayList<>(lunghenza);
	}
	
	public Signal(Complex a[]){
		this(a.length);
		
		for(int i = 0; i < a.length; i++){
			this.add(i, a[i]);
		}
	}
	
	public Signal(Signal in) {
		this(in.size());
		for(int i = 0; i < in.size(); i++){
			try {
				this.add(i, (Complex)(in.get(i).clone()));
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Complex> getValues() {
		return values;
	}

	public void setValues(List<Complex> values) {
		this.values = (LinkedList<Complex>) values;
	}
	
	public Complex get(int i){
		Complex r = this.values.get(i);
		
		return (r == null) ? new Complex(0,0): r;
	}
	
	public void add(Complex a){
		this.values.add(a);
	}
	
	public void add(int i, Complex a){
		this.values.add(i, a);
	}
	
	public int size(){
		return this.values.size();
	}
	
	public Signal convolviCon(Signal a){
		return SignalProcessor.convoluzione(this, a);
	}
	
	public Signal lowPassFiltering(double band){
		return SignalProcessor.lowPassFiltering(band, this);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Signal(this);
	}
	
	public static Signal createFromFile(File f){
		return SignalUtils.loadFromFile(f);
	}
	
	public boolean saveOnFile(File f){
		return SignalUtils.saveOnFile(this, f);
	}
}
