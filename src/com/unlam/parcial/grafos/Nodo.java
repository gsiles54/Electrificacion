package com.unlam.parcial.grafos;

import java.util.ArrayList;
import java.util.List;

public class Nodo {

	int nroNodo;
	List<Integer> nodosVecinos;
	
	public Nodo(int nroNodo) {
		this.nroNodo =  nroNodo;
		nodosVecinos = new ArrayList<>();
	}
	
	public List<Integer> getNodosVecinos(){
		return nodosVecinos;
	}
	public int getNroNodo() {
		return nroNodo;
	}
	public void agregarVecino(int nodoVecino) {
		nodosVecinos.add(nodoVecino);
	}
}
