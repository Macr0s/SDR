package it.uniroma3.sdr.signalprocessing.library.phases;



import it.uniroma3.sdr.signalprocessing.library.MethodDetection;
import it.uniroma3.sdr.signalprocessing.model.Signal;

public class EnergyDetection implements MethodDetection{
	private IpotesiH0 h0;
	private IpotesiH1 h1;
	private double soglia;
	private boolean sogliaCalcolata = false;
	
	
	public EnergyDetection(double snr, double pfa,int size){
		this(snr, pfa, size, size); 
	}
	
	public EnergyDetection(double snr, double pfa,int size, int noiseSize){
		this.h0 = new IpotesiH0(pfa, snr, noiseSize); 
		this.h1 = new IpotesiH1(); 
	}

/**
 * per chi non conoscesse il greco  il simbolo della soglia si pronuncia Eta
 * @return
 * @throws Exception 
 */
	public double getEta() throws Exception {
		this.soglia= this.h0.calcolaSoglia();
		this.sogliaCalcolata = true;
		return soglia;
	}
	
	@Override
	public boolean isSpectrumHole(Signal signal) {
		if (!this.sogliaCalcolata){
			try {
				this.getEta();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		return this.h1.isSpectrumHole(this.soglia,signal);
	}
}
