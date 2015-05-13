package it.uniroma3.sdr.signalprocessing.model;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import it.uniroma3.sdr.signalprocessing.library.SignalProcessor;
import it.uniroma3.sdr.signalprocessing.library.SignalUtils;

public class Signal implements SignalType {
	private Complex[] values;

	public Signal(int lunghezza){
		this.values = new Complex[lunghezza];
	}

	public Signal(Complex a[]){
		this.values = a;
	}

	public Signal(List<Complex> l){
		this.values = l.toArray(new Complex[0]);
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
		return Arrays.asList(this.values);
	}

	@Override
	public Complex get(int i){
		Complex r = this.values[i];

		return (r == null) ? new Complex(0,0): r;
	}

	public void add(int i, Complex a){
		this.values[i] = a;
	}

	public int size(){
		return this.values.length;
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

	public double energy(){
		return SignalProcessor.energy(this);
	}

	public double snrCalculator(){
		double snrNonDB = 1.0/(this.energy()-1);
		System.out.println(snrNonDB);
		return 10*Math.log10(snrNonDB);
	}

	public List<Signal> divideInto(int num) {
		List<Signal> dividedSignal= new LinkedList<>();
		for(int i =0; i< this.size(); i+= num){
			dividedSignal.add(new Signal(Arrays.copyOfRange(this.values, i, i+num -1 )));
		}
		return dividedSignal;
	}


}
