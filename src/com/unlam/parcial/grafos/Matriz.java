package com.unlam.parcial.grafos;

public class Matriz {

	protected int[][] matriz;
	protected int orden;
	public Matriz(int orden) {
		this.orden = orden;
		matriz = new int[orden][orden];
	}
	
	
	public int getValorEnPosicion(int fila, int columna) {
		return matriz[fila][columna];
	}
	
	public void setValorEnPosicion(int fila, int columna, int costo) {
		 matriz[fila][columna] = costo;
	}
	
	public int getOrden() {
		return this.orden;
	}
}
