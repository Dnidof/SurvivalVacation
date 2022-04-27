package org.wipgames.survivalvacation;

import java.util.ArrayList;
import java.util.Iterator;

public class EventoConsecutivo extends Evento {
	private ArrayList <EventoUnico> lista;

	public EventoConsecutivo(int pId, String pEnunciado, Opcion pOpcion1, Opcion pOpcion2, Opcion pOpcion3) {
		super(pId,pEnunciado,pOpcion1,pOpcion2,pOpcion3);
		this.lista= new ArrayList <EventoUnico>();
	}
	
	public void ejecutarEvento() {
		Iterator<EventoUnico> itr = this.getIterador();
		EventoUnico unEventoUnico;
		while(itr.hasNext()) {
			// TODO se tiene que salir si detecta victoria,sino el de victoria tendra que ser el ultimo evento
			unEventoUnico = itr.next();
			unEventoUnico.ejecutarEvento();
		}
	}
	
	private Iterator<EventoUnico> getIterador(){
		//TODO anadir al diagrama de clases getIterador en EventoConsecutivo
		return this.lista.iterator();
	}
}

