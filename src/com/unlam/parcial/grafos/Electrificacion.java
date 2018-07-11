package com.unlam.parcial.grafos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Electrificacion {
	File entrada;
	File salida;
	
	public Electrificacion(File entrada, File salida) {
		this.salida = salida;
		this.entrada = entrada;
	}
	
	public  void resolver() {
	 

	 Grafo grafo = new GrafoNDP(entrada);
	
	int[][] matrizResultado = new int[grafo.getCantCentrales()][grafo.getCantCiudades()];
	Dijsktra dijsktra;
	List<Integer>nroCentrales = grafo.getNodosCentrales();
	for( int i = 0 ; i < grafo.getCantCentrales(); i++) {
		int central = nroCentrales.get(i);
		 dijsktra = new Dijsktra(grafo,central-1);
		 matrizResultado[i]=dijsktra.resolver();
	}
	int menor=Integer.MAX_VALUE;
	int centralConectada=-1;
	boolean centralDetectada=false;
	int sumador=0;
	List<CiudadCentral> listaPares = new ArrayList<>();
	int ciudadConectada = -1;
	for(int ciudad = 0 ; ciudad < grafo.getCantCiudades();ciudad++) {
		if(esCentral(ciudad,nroCentrales)) {
				centralDetectada = true;
				menor = Integer.MAX_VALUE;
				continue;
			}
		for(int nroCentral = 0 ; nroCentral < grafo.getCantCentrales();nroCentral++) {
			
				
			if(matrizResultado[nroCentral][ciudad]<menor) {
				menor = matrizResultado[nroCentral][ciudad];
				centralConectada = nroCentrales.get(nroCentral);
				ciudadConectada = ciudad;
			}
				
			
			
			
		}
		
			sumador+=menor;
			listaPares.add(new CiudadCentral(ciudadConectada+1,centralConectada));
			centralDetectada=false;
		
		
		
		menor = Integer.MAX_VALUE;
	}
	System.out.println("");
	imprimirResultado(salida,sumador,listaPares);
}

private  boolean esCentral(int j, List<Integer> nroCentrales) {

	return nroCentrales.contains(j+1);

}

public void imprimirResultado(File salida,int sumador,List<CiudadCentral> listaPares) {
	FileWriter fw =null;
	BufferedWriter bw = null;
	
	try {
		fw = new FileWriter(salida);
		bw = new BufferedWriter(fw);
		
		bw.append(new Integer(sumador).toString());
		bw.newLine();
		int i = 0;
		while(!listaPares.isEmpty()) {
			CiudadCentral pares = listaPares.remove(i);
			Integer central = pares.central;
			Integer ciudad = pares.ciudad;
			bw.append(central.toString());
			bw.append(" ");
			bw.append(ciudad.toString());
			bw.newLine();
		}
		bw.flush();
	}catch(IOException e) {
		
	}
}
}
