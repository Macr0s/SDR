package it.uniroma3.sdr.signalprocessing.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import it.uniroma3.sdr.signalprocessing.model.Complex;
import it.uniroma3.sdr.signalprocessing.model.Signal;

/**
 * 
 * Classe che si occupa della gestione di campioni contenuti in file
 *
 * @author Filippi,Sgaraglia,Oddi
 *
 */
public class SignalUtils {

	
	public static Signal loadFromFile(File f){
		try {
			Scanner s = new Scanner(new FileInputStream(f));
			s.useDelimiter("\n");
			List<Complex> signalRaw = new LinkedList<>();
			String[] data;
			while(s.hasNext()){
				data = s.next().split("\t");
				signalRaw.add(new Complex(new Double(data[0]).doubleValue(),
									new Double(data[1]).doubleValue() ));
			}
			s.close();
			return new Signal(signalRaw);
		} catch (FileNotFoundException e) {
			return null;
		}
	}


	public static boolean saveOnFile(Signal in, File file){
		try {
			FileOutputStream fop = new FileOutputStream(file);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			for(Complex a: in.getValues()){
				byte[] data = (a.getpRe() + "\t" + a.getpImm() + "\n").getBytes();
				fop.write(data);
				fop.flush();
			}
			
			fop.close();
			
			return true;
		} catch (IOException e) {
			return false;
		}
	}


}
