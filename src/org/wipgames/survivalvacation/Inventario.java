package org.wipgames.survivalvacation;

import java.util.ArrayList;

public class Inventario {
	
	private ArrayList<Objeto> lista;
	private static Inventario miInventario;
	
	private Inventario() {
		this.lista = new ArrayList<Objeto>();
	}
	public static Inventario getInventario() {
		if(miInventario == null) miInventario = new Inventario();
		return miInventario;
	}
}
