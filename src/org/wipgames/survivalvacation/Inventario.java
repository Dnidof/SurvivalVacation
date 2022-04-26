package org.wipgames.survivalvacation;

import java.util.ArrayList;
import java.util.Iterator;

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
    
    private void anadirObjeto(Objeto pObjeto) {
    	this.lista.add(pObjeto);
    }
  
    public boolean tieneEsteObjeto(Objeto pObjeto) {
    	return this.lista.contains(pObjeto);
    }
    
    public void imprimirInventario() {
    	Iterator<Objeto> itr = this.getIterador();
    	Objeto unObjeto = null;
    	while (itr.hasNext()) {
    		unObjeto=itr.next();
    		if (unObjeto.getCantidad()>=1) {
    			unObjeto.imprimirObjeto();
    		}
    	}
    }
    
    public void barco() {
    	
    }
    
    public void cargarObjetos() {
    	
    }
    
    public void resetear() {
    	
    }
    
    public Objeto buscarObjetoPorId(int pId) {
    	
    }
    
    public void actualizarObjetoPorId(int pIdObjeto, int pUnidades) {
    	
    }
}