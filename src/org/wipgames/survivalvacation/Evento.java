package org.wipgames.survivalvacation;

public abstract class Evento {
	private int idEvento;
	private String enunciado;
	private boolean activado;
	private Opcion opcion1;
	private Opcion opcion2;
	private Opcion opcion3;
	
	public Evento(int pId, String pEnunciado, Opcion pOpcion1, Opcion pOpcion2, Opcion pOpcion3) {
		this.idEvento = pId;
		this.enunciado = pEnunciado;
		this.opcion1 = pOpcion1;
		this.opcion2 = pOpcion2;
		this.opcion3 = pOpcion3;	
		this.activado = false;
	}
	public abstract void ejecutarEvento();

	public void imprimirEvento() {
		
	}
	
	public Opcion getOpcion(int pNum) {
		return null;
	}

}
