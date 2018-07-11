package com.unlam.parcial.grafos;

public class CostoAlNodo implements Comparable<CostoAlNodo>{
		
	int costo;
	int nodo;
	
	public CostoAlNodo ( int costo, int nodo) {
		this.costo = costo;
		this.nodo = nodo;
	}

	@Override
	public int compareTo(CostoAlNodo o) {

		return this.costo - o.costo;
	}
	
}
