package com.unlam.parcial.grafos;

public class MatrizSimetrica extends Matriz{

	int[] vectorSimetrico;
	int dimensionVector;
	
	public MatrizSimetrica(int orden) {
		super(orden);
		dimensionVector = ((orden*orden)-orden)/2;
		vectorSimetrico = new int[dimensionVector];
	}
	
	@Override
	public int getValorEnPosicion(int fila,int columna) {
		if(fila<columna) {
			return vectorSimetrico[(int) (fila * orden + columna - ((Math.pow(fila, 2) +( 3 * fila )+ 2) / 2))];

		}
		return vectorSimetrico[(int) (columna * orden + fila - ((Math.pow(columna, 2) +( 3 * columna )+ 2) / 2))];
	
		}
	@Override
	public void setValorEnPosicion(int fila, int columna, int costo) {
		vectorSimetrico[(int) (fila * orden + columna - ((Math.pow(fila, 2) +( 3 * fila )+ 2) / 2))] = costo;
	}
	
	public int getDimensionVector() {
		return this.dimensionVector;
	}
	
}
