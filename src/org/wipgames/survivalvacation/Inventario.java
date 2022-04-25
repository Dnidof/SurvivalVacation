package org.wipgames.survivalvacation;

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
    
    private Iterator<Objeto> getIterador(){
    	
    	return this.lista.iterator();
    }
}