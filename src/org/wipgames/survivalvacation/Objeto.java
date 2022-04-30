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
		System.out.println(this.cantidad +"  " + this.devolverNombreObjeto() + "/s");
	}
	
	public void actualizarCantidad(int pCantidad) {
		this.cantidad = this.cantidad + pCantidad;
	}
	public int getCantidad() {
		return this.cantidad;
	}

	public String devolverNombreObjeto() {
		
			return String.format("%-30.30s", this.nombre);
			
	}
}