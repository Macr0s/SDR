package it.uniroma3.sdr.signalprocessing.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import it.uniroma3.sdr.signalprocessing.model.Complex;
import it.uniroma3.sdr.signalprocessing.model.Signal;

public class SignalUtils {

	public static Signal loadFromFile(File f){
		try {
			Scanner s = new Scanner(new FileInputStream(f));
			Signal out = new Signal();
			
			while(s.hasNext()){
				String[] data = s.next().split("\t");
				out.add(new Complex(new Double(data[0]).doubleValue(),
									new Double(data[1]).doubleValue() ));
			}
			s.close();
			return out;
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
