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
		
		System.out.println("Tines" + this.salud + "de salud");
		System.out.println("Tines" + this.hambre + "de hambre");
		System.out.println("Tines" + this.sed + "de sed");
		System.out.println("Tines" + this.cordura + "de cordura");
		
	}
	
	public void actualizarEstadisticas(int pSalud,int pHambre,int pSed,int pCordura) {
		
		this.salud = this.salud + pSalud;
		this.hambre = this.hambre + pHambre;
		this.sed = this.sed + pSed;
		this.cordura = this.cordura + pCordura;
		
	}
	
	public void resetearJugador() {
		
		this.cordura=10;
		this.hambre=10;
		this.salud=10;
		this.sed=10;
	}
	
	public boolean sigueVivo() {
		boolean vivo= true;
		if (this.salud<=0 || this.hambre<=0|| this.sed<=0||this.cordura<=0) {
			vivo=false;
			if(this.salud<=0) {System.out.println("Has muerto desangrado");}
			else if(this.hambre<=0) {System.out.println("Has muerto de inanicion y ahora sirves de abono");}
			else if(this.sed<=0) {System.out.println("Te has quedado seco");}
			else if(this.cordura<=0) {System.out.println("Te has vuelto loco y te has suicidado");}
		}
		return vivo;
	}
}
