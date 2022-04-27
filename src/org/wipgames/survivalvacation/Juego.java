package org.wipgames.survivalvacation;

public class Juego {
	
	private static Juego miJuego;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public void partida() {
		
		System.out.println("Presione 1 para iniciar partida o presione 2 para ver puntuaciones");
		//Jugador.getJugador().resetearJugador();
		int opcion = Teclado.getMiTeclado().leerOpcion();
		int eventosOcurridos = 0;
		boolean vivo=true;
		boolean victoria = false;
		if (opcion==1) {
			Eventos.getMisEventos().cargarEventosFichero("Eventos.txt");
			Inventario.getInventario().barco();
			while (vivo&&!victoria&&eventosOcurridos<=Eventos.getMisEventos().cantidadEventos()) {
				if (eventosOcurridos % 5==0) {
					Eventos.getMisEventos().activarEventoRecurrente();
					}
				else {
					Eventos.getMisEventos().activarEventoAleatorio();
					}
				eventosOcurridos++;
				vivo = Jugador.getJugador().sigueVivo();
				victoria 
			}
			if(victoria) {
				System.out.println("Has ganado");
				}
		
			this.finPartida();
		}
		else if (opcion==2) {
			//nos queda implementarlo
		}
		
		else {
			this.finPartida();}
	}
	
	
	private void finPartida() {
		//Falta hacer que al terminar una partida te lo guarde en el record
		System.out.println("Presione 1 para volver a jugar o presione 2 para ver puntuaciones");
		int opcion = Teclado.getMiTeclado().leerOpcion();
		if (opcion==1) {
			this.partida();
		}
		else if (opcion==2) {
			//nos queda implementarlo
		}
		
		else {
			this.finPartida();
		}
	}
	
	
	public static Juego getJuego() {
		
		if (miJuego==null) {miJuego = new Juego();}
		return miJuego;
			
		}
		
}
