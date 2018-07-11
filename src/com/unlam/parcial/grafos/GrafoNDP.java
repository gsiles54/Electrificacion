package com.unlam.parcial.grafos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GrafoNDP extends Grafo{

	public GrafoNDP(File f) {
		super(f);
		leerArchivo(f);
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
			matrizGrafo = new MatrizSimetrica(getCantCiudades());
			nodos = new ArrayList<>();
			linea = br.readLine();
			valores = linea.split(" ");
			for(String valorActual:valores) {
				getNodosCentrales().add(Integer.valueOf(valorActual));
			}
			
			for(int i = 0; i < getCantCiudades();i++) {
				linea = br.readLine();
				Nodo nodoActual = new Nodo(i);
				nodos.add(nodoActual);
				cantNodos++;
				valores = linea.split(" ");
				for(int j = 0 ; j <getCantCiudades();j++) {
					
					if(i!=j)
					nodoActual.agregarVecino(j);
					
					if(i<j)
					matrizGrafo.setValorEnPosicion(i, j, Integer.valueOf(valores[j]));
					if(j<i) 
					matrizGrafo.setValorEnPosicion(j, i, Integer.valueOf(valores[j]));
							
					
					}
				}
				
			
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}

}
