package com.unlam.parcial.grafos;


import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijsktra {

	private Queue<CostoAlNodo> nodosSinVisitar;
	private boolean[] nodosVisitados;
	private Grafo grafo;
	private int nodoInicial;
	private int[] costos;
	private List<Integer> nodosVecinos;

	public Dijsktra(Grafo grafo,int nodoInicial) {
		this.grafo = grafo;
		this.nodoInicial = nodoInicial;
		nodosSinVisitar = new PriorityQueue<>();
		nodosVisitados = new boolean[grafo.getCantNodos()];
		costos = new int[grafo.getCantNodos()];
	}
	
	public int[] resolver() {
		CostoAlNodo costoInicial = new CostoAlNodo(0,nodoInicial);
		nodosSinVisitar.add(costoInicial);
		inicializarCostos();
		nodosVisitados[nodoInicial] = true;
		
		while(!nodosSinVisitar.isEmpty()) {
			int nodoActual = nodosSinVisitar.poll().nodo;
			nodosVecinos =grafo.getNodos().get(nodoActual).getNodosVecinos();
			for(Integer nodoVecino : nodosVecinos) {
				
				if(nodoVecino==nodoActual)
					continue;
				
				int costoTentativo = costos[nodoActual] + costoArista(nodoActual,nodoVecino);
				
				if(!nodosVisitados[nodoVecino]&&costoTentativo < costos[nodoVecino]) {
					costos[nodoVecino] = costoTentativo;
					nodosSinVisitar.add(new CostoAlNodo(costos[nodoVecino],nodoVecino));
				}
			}
			nodosVisitados[nodoActual] = true;
		}
		return costos;
	}

	private int costoArista(int nodoActual, int nroNodoVecino) {
	return	grafo.getMatrizGrafo().getValorEnPosicion(nodoActual, nroNodoVecino);
	
	}

	private void inicializarCostos() {
		for(int i = 0 ;  i < costos.length ; i++) {
			costos[i] = Integer.MAX_VALUE;
		}
		costos[nodoInicial] = 0;
	}
}
