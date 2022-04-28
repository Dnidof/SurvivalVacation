package org.wipgames.survivalvacation;

import java.util.ArrayList;
import java.util.Iterator;

public class EventoConsecutivo extends Evento {
	private ArrayList <EventoUnico> lista;

	public EventoConsecutivo(int pId,EventoUnico pEvento1,EventoUnico pEvento2, EventoUnico pEvento3) {
		super(pId,"",null,null,null);
		this.lista= new ArrayList <EventoUnico>();
		this.lista.add(pEvento1);
		this.lista.add(pEvento2);
		this.lista.add(pEvento3);
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

