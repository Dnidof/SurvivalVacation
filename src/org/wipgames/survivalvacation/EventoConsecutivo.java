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
	
	public int ejecutarEvento() {
		super.activarEvento();
		EventoUnico unEventoUnico = this.lista.get(0);
		int eleccion = unEventoUnico.ejecutarEvento();
		if(eleccion == 1) {
			this.lista.get(1).ejecutarEvento();
		}else if(eleccion == 2 || eleccion == 3) {
			this.lista.get(2).ejecutarEvento();
		}	
		
		return 0;
	}
	
}

