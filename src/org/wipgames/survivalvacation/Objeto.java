package org.wipgames.survivalvacation;

public class Objeto {

	
	private String nombre;
	private int idObjeto;
	private int cantidad;
	
	public Objeto(String pNombre, int pIdObjeto, int pCantidad) {
		
		this.nombre=pNombre;
		this.idObjeto=pIdObjeto;
		this.cantidad=pCantidad;

	}
	
	public boolean tieneEsteId(int pId) {
		return pId == this.idObjeto;
	}
		
	public void imprimirObjeto() {
		System.out.println("hay " + this.cantidad +" " + this.nombre + "/s");
	}
	
	public void actualizarCantidad(int pCantidad) {
		this.cantidad = this.cantidad + pCantidad;
	}
		
}