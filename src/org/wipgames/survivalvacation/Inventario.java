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
    
    public void añadirObjeto(Objeto pObjeto) {
    	
    }
    
    public void eliminarObjeto() {
    	
    }
    
    public boolean tieneEsteObjeto(Objeto pObjeto) {
    	
    }
    
    public void imprimirInventario() {
    	
    }
    
    public void barco() {
    	
    }
    
    public void cargarObjetos() {
    	
    }
    
    public void resetear() {
    	
    }
    
    private Objeto buscarObjetoPorId(int pId) {
    	
    }
    
    public void actualizarObjetoPorId(int pIdObjeto, int pUnidades) {
    	
    }
}