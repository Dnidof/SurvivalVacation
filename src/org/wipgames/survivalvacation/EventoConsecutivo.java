package org.wipgames.survivalvacation;

public class EventoConsecutivo extends Evento {
	private Arraylist <EventoUnico> lista;

	public EventoConsecutivo(int pId, String pEnunciado, Opcion pOpcion1, Opcion pOpcion2, Opcion pOpcion3) {
		super(pId,pEnunciado,pOpcion1,pOpcion2,pOpcion3);
		this.lista= new ArrayList <EventoUnico>();
	}
	
	public void ejecutarEvento() {
		
	}
}

