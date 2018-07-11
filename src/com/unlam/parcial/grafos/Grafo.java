package com.unlam.parcial.grafos;

import java.io.File;
import java.util.List;

public abstract class Grafo {

	protected int cantNodos;
	protected int cantAristas;
	protected List<Nodo> nodos;
	protected Matriz matrizGrafo;
	protected File entrada;
	private int cantCiudades;
	private int cantCentrales;
	private List<Integer> nodosCentrales;
	public Grafo(File f) {
		entrada = f;
	}

	abstract public void leerArchivo(File f);

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}

	public List<Nodo> getNodos() {
		return nodos;
	}

	public void setNodos(List<Nodo> nodos) {
		this.nodos = nodos;
	}

	public Matriz getMatrizGrafo() {
		return matrizGrafo;
	}

	public void setMatrizGrafo(Matriz matrizGrafo) {
		this.matrizGrafo = matrizGrafo;
	}

	public int getCantCentrales() {
		return cantCentrales;
	}

	public void setCantCentrales(int cantCentrales) {
		this.cantCentrales = cantCentrales;
	}

	public int getCantCiudades() {
		return cantCiudades;
	}

	public void setCantCiudades(int cantCiudades) {
		this.cantCiudades = cantCiudades;
	}

	public List<Integer> getNodosCentrales() {
		return nodosCentrales;
	}

	public void setNodosCentrales(List<Integer> nodosCentrales) {
		this.nodosCentrales = nodosCentrales;
	}

}
