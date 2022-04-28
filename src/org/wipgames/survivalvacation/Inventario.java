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
    	Iterator<Objeto> itr = this.getIterador();
    	Objeto unObjeto = null;
    	boolean loTiene=false;
    	while (itr.hasNext() && !loTiene) {
    		unObjeto=itr.next();
    		if (unObjeto.getCantidad()>=1) {
    			loTiene = true;
    		}
    	}
    	return loTiene;
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
    	this.imprimirBarco(segundosRestantes);
    	while (segundosRestantes>0) {
    		int opcionElegida =Teclado.getMiTeclado().leerOpcion();
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
    		
    		else if(opcionElegida==4 && segundosRestantes>=20 && !this.tieneEsteObjeto(this.buscarObjetoPorId(3))) {
    			this.buscarObjetoPorId(3).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - 20;
    		}
    		else if(opcionElegida==5 && segundosRestantes>=30 && !this.tieneEsteObjeto(this.buscarObjetoPorId(4))) {
    			this.buscarObjetoPorId(4).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - 30;
    		}
    		
    		else if(opcionElegida==6 && segundosRestantes>=20 && !this.tieneEsteObjeto(this.buscarObjetoPorId(5))) {
    			this.buscarObjetoPorId(5).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - 20;
    		}
    		
    		else if(opcionElegida==7 && segundosRestantes>=40 && !this.tieneEsteObjeto(this.buscarObjetoPorId(6))) {
    			this.buscarObjetoPorId(6).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - 40;
    		}
    		else if(opcionElegida==8 && segundosRestantes>=10 && !this.tieneEsteObjeto(this.buscarObjetoPorId(7))) {
    			this.buscarObjetoPorId(7).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - 10;
    		}
    		else if(opcionElegida==9 && segundosRestantes>=30 && !this.tieneEsteObjeto(this.buscarObjetoPorId(8))) {
    			this.buscarObjetoPorId(8).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - 30;
    		}
    		else {System.out.println("Introduce una opcion valida");}
    		System.out.println("Te quedan " + segundosRestantes + " segundos" );
    		
    		}
    		
    	}
    	
   
    
    public void cargarObjetos() {
    	
    	this.lista = new ArrayList <Objeto>();
    	Objeto o1 = new Objeto("Vendas          ",0,2);
    	this.anadirObjeto(o1);
    	
    	Objeto o2 = new Objeto("Lata de comida  ",1,2);
    	this.anadirObjeto(o2);
    	
    	Objeto o3 = new Objeto("Botella de agua ",2,2);
    	this.anadirObjeto(o3);
    	
    	Objeto o4 = new Objeto("Palanca         ",3,0);
    	this.anadirObjeto(o4);
    	
    	Objeto o5 = new Objeto("Espada          ",4,0);
    	this.anadirObjeto(o5);
    	
    	Objeto o6 = new Objeto("Linterna        ",5,0);
    	this.anadirObjeto(o6);
    	
    	Objeto o7 = new Objeto("Oro             ",6,0);
    	this.anadirObjeto(o7);
    	
    	Objeto o8 = new Objeto("Llave Misteriosa",7,0);
    	this.anadirObjeto(o8);
    	
    	Objeto o9 = new Objeto("Radio",8,0);
    	this.anadirObjeto(o9);
    }
    
    public Objeto buscarObjetoPorId(int pId) {
    	return this.lista.get(pId);
    }
    
    private void imprimirBarco(int pNumSegundos) {
    	if (pNumSegundos >= 10) {
    		System.out.println("1-  "  + this.buscarObjetoPorId(0).imprimirNombreObjeto() + "   -10 segundos");
    		System.out.println("2-  "  + this.buscarObjetoPorId(1).imprimirNombreObjeto() + "   -10 segundos");
    		System.out.println("3-  "  + this.buscarObjetoPorId(2).imprimirNombreObjeto() + "   -10 segundos");
    		if (!this.tieneEsteObjeto(this.buscarObjetoPorId(7))) {
    			System.out.println("8-  "  + this.buscarObjetoPorId(7).imprimirNombreObjeto() + "   -10 segundos");
    		}
    	}
    	if (pNumSegundos >= 20) {
    		if (!this.tieneEsteObjeto(this.buscarObjetoPorId(3))) {
    			System.out.println("4-  "  + this.buscarObjetoPorId(3).imprimirNombreObjeto() + "   -20  segundos");
    		}
    		if (this.tieneEsteObjeto(this.buscarObjetoPorId(5))) {
    			System.out.println("6-  "  + this.buscarObjetoPorId(5).imprimirNombreObjeto() + "   -20  segundos");
    		}
    	}
    	if (pNumSegundos >= 30) {
    		if (!this.tieneEsteObjeto(this.buscarObjetoPorId(4))) {
    			System.out.println("5-  "  + this.buscarObjetoPorId(4).imprimirNombreObjeto() + "   -30  segundos");
    		}
    	}
    	if (pNumSegundos >= 40) {
    		if (!this.tieneEsteObjeto(this.buscarObjetoPorId(6))) {
    			System.out.println("7-  "  + this.buscarObjetoPorId(6).imprimirNombreObjeto() + "   -40  segundos");
    		}
    	}
    }
    	
    
    public void actualizarObjetoPorId(int pIdObjeto, int pUnidades) {
    	this.buscarObjetoPorId(pIdObjeto).actualizarCantidad(pUnidades);
    }
}