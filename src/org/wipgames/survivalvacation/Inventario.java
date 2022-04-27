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
    	
    	System.out.println("Tienes 60 segundos");
    	int segundosRestantes=60;
    	System.out.println("1-   "  + this.buscarObjetoPorId(0).imprimirNombreObjeto() + "   -10 segundos");
    	System.out.println("2-   "  + this.buscarObjetoPorId(1).imprimirNombreObjeto() + "   -10 segundos");
    	System.out.println("3-   "  + this.buscarObjetoPorId(2).imprimirNombreObjeto() + "   -10 segundos");
    	System.out.println("4-   "  + this.buscarObjetoPorId(3).imprimirNombreObjeto() + "   -x  segundos");
    	System.out.println("5-   "  + this.buscarObjetoPorId(4).imprimirNombreObjeto() + "   -x  segundos");
    	System.out.println("6-   "  + this.buscarObjetoPorId(5).imprimirNombreObjeto() + "   -x  segundos");
    	System.out.println("7-   "  + this.buscarObjetoPorId(6).imprimirNombreObjeto() + "   -x  segundos");
    	int opcionElegida =Teclado.getMiTeclado().leerOpcion();
    	while (segundosRestantes>=0) {
    		if(opcionElegida==1 && segundosRestantes>=10) {
    			this.buscarObjetoPorId(0).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - 10;
    		}
    		else if(opcionElegida==2 && segundosRestantes>=10) {
    			this.buscarObjetoPorId(1).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - 10;
    		}
    		else if(opcionElegida==3 && segundosRestantes>=10) {
    			this.buscarObjetoPorId(2).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - 10;
    		}
    		
    		else if(opcionElegida==4 && segundosRestantes>=x) {
    			this.buscarObjetoPorId(3).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - x;
    		}
    		else if(opcionElegida==5 && segundosRestantes>=x) {
    			this.buscarObjetoPorId(4).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - x;
    		}
    		
    		else if(opcionElegida==6 && segundosRestantes>=x) {
    			this.buscarObjetoPorId(5).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - x;
    		}
    		
    		else if(opcionElegida==7 && segundosRestantes>=x) {
    			this.buscarObjetoPorId(6).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - x;
    		}
    		System.out.println("Te quedan " + segundosRestantes + " segundos" );
    	}
    	
    	}
    
    public void cargarObjetos() {
    	this.anadirObjeto(null);
    }
    
    public void resetear() {
    	
    }
    
    public Objeto buscarObjetoPorId(int pId) {
    	return this.lista.get(pId);
    }
    
    public void actualizarObjetoPorId(int pIdObjeto, int pUnidades) {
    	this.buscarObjetoPorId(pIdObjeto).actualizarCantidad(pUnidades);
    }
}