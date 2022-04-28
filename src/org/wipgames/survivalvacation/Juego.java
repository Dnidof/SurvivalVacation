package org.wipgames.survivalvacation;

public class Juego {
	
	private static Juego miJuego;
	private  static boolean victoria;
	public static void main(String[] args) {

		partida();

	}
	
	private Juego(){
		victoria=false;
		
	}

	
	public static void partida() {
		victoria=false;
		System.out.println("Presione 1 para iniciar partida o presione 2 para ver puntuaciones");
		int opcion = Teclado.getMiTeclado().leerOpcion();
		int eventosOcurridos = 0;
		boolean vivo=true;
		if (opcion==1) {
			Jugador.getJugador().resetearJugador();
			Inventario.getInventario().cargarObjetos();
			Eventos.getMisEventos().cargarEventosFichero("Eventos.txt");
			Inventario.getInventario().barco();
			while (vivo && !victoria && eventosOcurridos <= Eventos.getMisEventos().cantidadEventos()) {
				if (eventosOcurridos % 5==0) {
					Eventos.getMisEventos().activarEventoRecurrente();
					}
				else {
					Eventos.getMisEventos().activarEventoAleatorio();
					}
				eventosOcurridos++;
				vivo = Jugador.getJugador().sigueVivo(); 
			}
			if(victoria) {
				System.out.println("Has ganado");
				}
		
			finPartida();
		}
		else if (opcion==2) {
			//nos queda implementarlo
		}
		
		else {
			finPartida();}
	}
	
	
	private static void finPartida() {
		partida();
	}
	
	
	public static Juego getJuego() {
		
		if (miJuego==null) {miJuego = new Juego();}
		return miJuego;
			
		}


	public void setVictoria() {
		victoria=true;
		
	}
		
}
