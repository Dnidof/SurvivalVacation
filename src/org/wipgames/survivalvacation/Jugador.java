package org.wipgames.survivalvacation;

public class Jugador {

	
	private int salud;
	private int comida;
	private int hidratacion;
	private int cordura;
	private static Jugador miJugador;
	
	private Jugador() {
		
	}
	
	public static Jugador getJugador() {
		if (miJugador==null) {miJugador = new Jugador();}
		return miJugador;
			
	}
	
	
	public void imprimirEstadisticas() {
		
		System.out.println("Tienes " + String.format("%-2.30s", this.salud) + " de salud");
		System.out.println("Tienes " + String.format("%-2.30s", this.comida) + " de comida");
		System.out.println("Tienes " + String.format("%-2.30s", this.hidratacion) + " de hidratacion");
		System.out.println("Tienes " + String.format("%-2.30s", this.cordura) + " de cordura");
		
	}

	public void actualizarEstadisticas(int pSalud,int pComida,int phidratacion,int pCordura) {
		
		this.salud = this.salud + pSalud;
		if (this.salud >= 10) {this.salud=10;}
		this.comida = this.comida + pComida;
		if (this.comida >= 10) {this.comida=10;}
		this.hidratacion = this.hidratacion + phidratacion;
		if (this.hidratacion >= 10) {this.hidratacion=10;}
		this.cordura = this.cordura + pCordura;
		if (this.cordura >= 10) {this.cordura=10;}
		
	}
	
	public void resetearJugador() {
		
		this.cordura=10;
		this.comida=5;
		this.salud=10;
		this.hidratacion=5;
	}
	
	public boolean sigueVivo() {
		boolean vivo= true;
		if (this.salud<=0 || this.comida<=0|| this.hidratacion<=0||this.cordura<=0) {
			vivo=false;
			if(this.salud<=0) {System.out.println("Has muerto desangrado");}
			else if(this.comida<=0) {System.out.println("Has muerto de inanicion y ahora sirves de abono");}
			else if(this.hidratacion<=0) {System.out.println("Te has quedado seco");}
			else if(this.cordura<=0) {System.out.println("Te has vuelto loco y te has suicidado");}
		}
		return vivo;
	}
}
