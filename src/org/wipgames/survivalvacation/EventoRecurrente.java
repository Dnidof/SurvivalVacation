package org.wipgames.survivalvacation;

public class EventoRecurrente extends Evento {
	private int idEvento=0;
	
	public EventoRecurrente(int pId, String pEnunciado, Opcion pOpcion1, Opcion pOpcion2, Opcion pOpcion3, int idEvento) {
		super(pId,pEnunciado,pOpcion1,pOpcion2,pOpcion3);
		this.idEvento= idEvento;
	}
	
	public void ejecutarEvento() {
		
	}

}
