package org.wipgames.survivalvacation;

public class Jugador {

	
	private int salud;
	private int hambre;
	private int sed;
	private int cordura;
	private static Jugador miJugador;
	
	private Jugador() {
		
	}
	
	public static Jugador getJugador() {
		if (miJugador==null) {miJugador = new Jugador();}
		return miJugador;
			
	}
	
	
	public void imprimirEstadisticas() {
		
		
	}
	
	public void actualizarEstadisticas(int pSalud,int pHambre,int pSed,int pCordura) {
		
	}
	
	public void resetearJugador() {
		
	}
	
	public boolean sigueVivo() {
		//TODO no tiene que devolver false
		return false;
	}
}
