package org.wipgames.survivalvacation;

public class EventoUnico extends Evento{
	
	public EventoUnico(int pId, String pEnunciado, Opcion pOpcion1, Opcion pOpcion2, Opcion pOpcion3) {
		super(pId,pEnunciado,pOpcion1,pOpcion2,pOpcion3);
	}
	
	public int ejecutarEvento() {
		
		super.imprimirEvento();
		boolean seHaRealizado = false;
		int opcion = 0;
		while (!seHaRealizado) {
			
			opcion = Teclado.getMiTeclado().leerOpcion();
			
			if (opcion==1 || opcion==2 || opcion==3 || opcion==8 || opcion==9) {
			
				if(opcion==1 && this.getOpcion(1).cumpleRequisitoObjeto()) {
					this.getOpcion(1).aplicarConsecuencias();
					seHaRealizado=true;
				}
			
				else if(opcion==2 && this.getOpcion(2).cumpleRequisitoObjeto()) {
					this.getOpcion(2).aplicarConsecuencias();
					seHaRealizado=true;
				}
			
				else if(opcion==3 && this.getOpcion(3).cumpleRequisitoObjeto()) {
					this.getOpcion(3).aplicarConsecuencias();
					seHaRealizado=true;
				}
				
				else if(opcion==8) {
					Jugador.getJugador().imprimirEstadisticas();
				}
				
				else if(opcion==9) {
					Inventario.getInventario().imprimirInventario();
				}
			
			}
			else {
				System.out.println("Introduce una opcion valida");
			}
		}
		super.activarEvento();
		return opcion;

	}

}

