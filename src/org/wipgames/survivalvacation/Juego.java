package org.wipgames.survivalvacation;

public class Juego {
	
	private static Juego miJuego;
	private boolean finPartida;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public void partida() {
		
		System.out.println("Presione 1 para iniciar partida o presione 2 para ver puntuaciones");
		int opcion = Teclado.getMiTeclado().leerOpcion();
		int eventosOcurridos = 0;
		if (opcion==1) {
		Eventos.getMisEventos().cargarEventosFichero("Eventos.txt");
		Inventario.getInventario().barco();
		while (Jugador.getJugador().sigueVivo()) {
			if (eventosOcurridos % 5==0) {
				Eventos.getMisEventos().activarEventoRecurrente();
				}
			else {
				Eventos.getMisEventos().activarEventoAleatorio();
				}
			eventosOcurridos++;
			
			}
		}
		else if (opcion==2) {
			//nos queda implementarlo
		}
		
		else {
			this.finPartida();}
		
	}
	
	
	private void finPartida() {
		
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
