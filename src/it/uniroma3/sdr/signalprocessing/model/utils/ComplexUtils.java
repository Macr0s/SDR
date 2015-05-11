package it.uniroma3.sdr.signalprocessing.model.utils;

import it.uniroma3.sdr.signalprocessing.model.Complex;

public class ComplexUtils {
	
	public static Complex somma(Complex a, Complex b){
		return new Complex(a.getpRe() + b.getpRe(), a.getpImm() + b.getpImm());
	}
	
	public static Complex coniugato(Complex a){
		return new Complex(a.getpRe(), a.getpImm() * -1);
	}
	
	public static double modulo(Complex a){
		return Math.sqrt(Math.pow(a.getpRe(), 2) + Math.pow(a.getpImm(), 2));
	}
	
	public static Complex prodotto(Complex a, Complex b){
		return new Complex(a.getpRe() * b.getpRe() - a.getpImm() * b.getpImm(), 
				           a.getpRe() * b.getpImm() + a.getpImm() + b.getpRe());
	}
	
	public static Complex potenza(Complex a){
		return ComplexUtils.prodotto(a, a);
	}
	
	public static double fase(Complex a){
		return Math.atan2(a.getpImm(), a.getpRe());
	}
	
	public static Complex reciproco(Complex a){
		double divisore = Math.pow(a.getpRe(), 2) + Math.pow(a.getpImm(), 2);
		
		Complex coniugato = coniugato(a);
		return new Complex(coniugato.getpRe() / divisore, coniugato.getpImm() /divisore);
	}
	
	public static Complex differenza(Complex a, Complex b){
		return new Complex(a.getpRe() - b.getpRe(), a.getpImm() - b.getpImm());
	}
	
	public static Complex rapporto(Complex a, Complex b){
		double divisore = Math.pow(b.getpRe(), 2) + Math.pow(b.getpImm(), 2);
		double imm = (a.getpRe() * b.getpRe() - a.getpImm() * b.getpImm()) / divisore;
		double re = (a.getpRe() * b.getpImm() + a.getpImm() * b.getpRe()) / divisore;
		
		return new Complex(re, imm);
	}
	
	public static Complex scalare(double b, Complex a){
		return new Complex(a.getpRe() * b, a.getpImm() * b);
	}
}
