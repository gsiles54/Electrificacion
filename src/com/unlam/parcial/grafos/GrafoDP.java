package com.unlam.parcial.grafos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GrafoDP extends Grafo{

	public GrafoDP(File f) {
		super(f);
		}

	@Override
	public void leerArchivo(File f) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			String linea = br.readLine();
			String[] valores = linea.split(" ");
			
			setCantCiudades(Integer.valueOf(valores[0]));
			setCantCentrales(Integer.valueOf(valores[1]));
			setNodosCentrales(new ArrayList<>(getCantCentrales()));
			linea = br.readLine();
			valores = linea.split(" ");
			for(String valorActual:valores) {
				getNodosCentrales().add(Integer.valueOf(valorActual));
			}
			
			for(int i = 0; i < getCantCiudades()+getCantCentrales();i++) {
				linea = br.readLine();
				valores = linea.split(" ");
				
			}
		}catch(IOException ex) {
			
		}
		
	}

}
