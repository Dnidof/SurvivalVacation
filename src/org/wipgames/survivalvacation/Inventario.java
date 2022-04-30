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
    	boolean tieneElObjeto = false;
    	if (this.lista.contains(pObjeto) && pObjeto.getCantidad() >=1) tieneElObjeto = true;
    	return tieneElObjeto;
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
    	
    	System.out.printf("Te encuentras en tu barco privado rumbo a Mallorca. Te diriges hacia tus esperadas vacaciones en un hotel de la ciudad.%nEstas disfrutando del oleaje y del sonido del viento cuando escuchas un fuerte sonido proveniente de la proa.%nRapidamente vas a ver que ha pasado y te das cuenta de lo peor, un agujero de tamanno considerable en la parte interna del barco.%nPronto te das cuenta de que te queda poco tiempo a flote, estimas unos 60 segundos y te propones agarrar todo lo que puedas.%n%nEn el camarote tienes esto a la vista, tendras que escoger sabiamente para no desperdiciar el poco tiempo que te queda:%n");
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
    			segundosRestantes= segundosRestantes - 10;
    		}
    		else if(opcionElegida==5 && segundosRestantes>=20 && !this.tieneEsteObjeto(this.buscarObjetoPorId(4))) {
    			this.buscarObjetoPorId(4).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - 20;
    		}
    		
    		else if(opcionElegida==6 && segundosRestantes>=20 && !this.tieneEsteObjeto(this.buscarObjetoPorId(5))) {
    			this.buscarObjetoPorId(5).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - 20;
    		}
    		
    		else if(opcionElegida==7 && segundosRestantes>=40 && !this.tieneEsteObjeto(this.buscarObjetoPorId(6))) {
    			this.buscarObjetoPorId(6).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - 30;
    		}
    		else if(opcionElegida==8 && segundosRestantes>=40 && !this.tieneEsteObjeto(this.buscarObjetoPorId(7))) {
    			this.buscarObjetoPorId(7).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - 40;
    		}
    		else if(opcionElegida==9 && segundosRestantes>=40 && !this.tieneEsteObjeto(this.buscarObjetoPorId(8))) {
    			this.buscarObjetoPorId(8).actualizarCantidad(1);
    			segundosRestantes= segundosRestantes - 40;
    		}
    		else {System.out.println("Introduce una opcion valida");}
    		System.out.println("Te quedan " + segundosRestantes + " segundos antes de que el barco se hunda" );
    		this.imprimirBarco(segundosRestantes);
    		
    		}
    		System.out.println("_____________________________________");
    		System.out.println("Recuerda que pulsando 8 y 9 respectivamente abres tus estadisticas e inventario.");
    		System.out.println();
    	}
    public void cargarObjetos() {
    	
    	this.lista = new ArrayList <Objeto>();
    	Objeto o = new Objeto("Vendas",0,2);
    	this.anadirObjeto(o);
    	
    	o = new Objeto("Lata de comida",1,2);
    	this.anadirObjeto(o);
    	
    	o = new Objeto("Botella de agua",2,2);
    	this.anadirObjeto(o);
    	
    	o = new Objeto("Llave misteriosa",3,0);
    	this.anadirObjeto(o);
    	
    	o = new Objeto("Linterna",4,0);
    	this.anadirObjeto(o);
    	
    	o = new Objeto("Monedas de oro",5,0);
    	this.anadirObjeto(o);
    	
    	o = new Objeto("Radio averiada",6,0);
    	this.anadirObjeto(o);
    	
    	o = new Objeto("Espada",7,0);
    	this.anadirObjeto(o);
    	  	
    	o = new Objeto("Palanca",8,0);
    	this.anadirObjeto(o);
    	
    	o = new Objeto("Reliquia Enana",9,0);
    	this.anadirObjeto(o);
    	
    	o = new Objeto("Baston electrico",10,0);
    	this.anadirObjeto(o);
    	
    	o = new Objeto("Kit de reparacion",11,0);
    	this.anadirObjeto(o);
    	
    	o = new Objeto("Silbato tribal",12,0);
    	this.anadirObjeto(o);
    	
    	o = new Objeto("Lanza",13,0);
    	this.anadirObjeto(o);
    }
    
    public Objeto buscarObjetoPorId(int pId) {
    	Iterator<Objeto> itr = this.getIterador();
    	Objeto objetoBuscado = null;
    	Objeto unObjeto = null;
    	while (itr.hasNext()) {
    		unObjeto=itr.next();
    		if (unObjeto.tieneEsteId(pId)) {
    			objetoBuscado = unObjeto;
    		}
    	}
    	return objetoBuscado;
    }
    
    private void imprimirBarco(int pNumSegundos) {
    	if (pNumSegundos >= 10) {
    		System.out.println("1-  "  + this.buscarObjetoPorId(0).devolverNombreObjeto() + "   -10 segundos");
    		System.out.println("2-  "  + this.buscarObjetoPorId(1).devolverNombreObjeto() + "   -10 segundos");
    		System.out.println("3-  "  + this.buscarObjetoPorId(2).devolverNombreObjeto() + "   -10 segundos");
    		if (!this.tieneEsteObjeto(this.buscarObjetoPorId(3))) {
    			System.out.println("4-  "  + this.buscarObjetoPorId(3).devolverNombreObjeto() + "   -10 segundos");
    		}
    	}
    	if (pNumSegundos >= 20) {
    		if (!this.tieneEsteObjeto(this.buscarObjetoPorId(4))) {
    			System.out.println("5-  "  + this.buscarObjetoPorId(4).devolverNombreObjeto() + "   -20  segundos");
    		}
    		if (!this.tieneEsteObjeto(this.buscarObjetoPorId(5))) {
    			System.out.println("6-  "  + this.buscarObjetoPorId(5).devolverNombreObjeto() + "   -20  segundos");
    		}
    	}
    	if (pNumSegundos >= 30) {
    		if (!this.tieneEsteObjeto(this.buscarObjetoPorId(6))) {
    			System.out.println("7-  "  + this.buscarObjetoPorId(6).devolverNombreObjeto() + "   -30  segundos");
    		}
    	}
    	if (pNumSegundos >= 40) {
    		if (!this.tieneEsteObjeto(this.buscarObjetoPorId(7))) {
    			System.out.println("8-  "  + this.buscarObjetoPorId(7).devolverNombreObjeto() + "   -40  segundos");
    		}
    		if (!this.tieneEsteObjeto(this.buscarObjetoPorId(8))) {
    			System.out.println("9-  "  + this.buscarObjetoPorId(8).devolverNombreObjeto() + "   -40  segundos");
    		}
    	}
    }
    	
    
    public void actualizarObjetoPorId(int pIdObjeto, int pUnidades) {
    	if(pIdObjeto != -1) {
    		this.buscarObjetoPorId(pIdObjeto).actualizarCantidad(pUnidades);
    	}
    }
}