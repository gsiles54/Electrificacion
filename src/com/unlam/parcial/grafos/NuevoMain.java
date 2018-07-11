package com.unlam.parcial.grafos;

import java.io.File;

public class NuevoMain {

	public static void main(String[] args) {
		Electrificacion electrificacion;
		File entrada;
		File salida;
		
		for(int i = 1; i < 9 ; i++) {
			entrada = new File("entrada_"+i+".in");
			salida = new File("salida_"+i+".out");
			electrificacion = new Electrificacion(entrada, salida);
			electrificacion.resolver();
		}
	}

}
