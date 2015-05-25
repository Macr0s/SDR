package it.uniroma3.sdr.signalprocessing.model;

import it.uniroma3.sdr.signalprocessing.model.utils.ComplexUtils;

/**
 * Classe che rappresenta i numeri complessi e le loro operazioni
 * 
 * @author Filippi, Oddi, Sgaraglia
 *
 */
public class Complex {
	private double pRe;
	private double pImm;
	
	public Complex(double pRe, double pImm){
		this.pRe = pRe;
		this.pImm = pImm;
	}

	public double getpRe() {
		return pRe;
	}

	public void setpRe(double pRe) {
		this.pRe = pRe;
	}

	public double getpImm() {
		return pImm;
	}

	public void setpImm(double pImm) {
		this.pImm = pImm;
	}
	
	public Complex coniugato(){
		return ComplexUtils.coniugato(this);
	}
	
	public Complex sum(Complex a){
		return ComplexUtils.somma(this, a);
	}
	
	public double modulo(){
		return ComplexUtils.modulo(this);
	}
	
	public Complex potenza(){
		return ComplexUtils.potenza(this);
	}
	
	public Complex prodotto(Complex a){
		return ComplexUtils.prodotto(this, a);
	}
	
	public double fase(){
		return ComplexUtils.fase(this);
	}
	
	public Complex reciproco(){
		return ComplexUtils.reciproco(this);
	}
	
	public Complex differenza(Complex a){
		return ComplexUtils.differenza(this, a);
	}
	
	public Complex rapporto(Complex a){
		return ComplexUtils.rapporto(this, a);
	} 
	
	public Complex scalare(double b){
		return ComplexUtils.scalare(b, this);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Complex(this.pRe, this.pImm);
	}
}
