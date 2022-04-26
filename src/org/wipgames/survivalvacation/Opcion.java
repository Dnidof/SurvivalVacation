package org.wipgames.survivalvacation;

public class Opcion {
	private String enunciadoOpcion;
	private int consecuenciaSalud;
	private int consecuenciaHambre;
	private int consecuenciaSed;
	private int consecuenciaCordura;
	private int consecuenciaObjeto;
	private String consecuenciaEscrita;
	private int requerimientoObjeto;
	
	public Opcion(String pEnunciado, int pSalud, int pHambre, int pSed, int pCordura,
			int pConsecuenciaObjeto, String pConsecuencia, int pReqObjeto) {
		this.enunciadoOpcion = pEnunciado;
		this.consecuenciaSalud = pSalud;
		this.consecuenciaHambre = pHambre;
		this.consecuenciaSed = pSed;
		this.consecuenciaCordura = pCordura;
		this.consecuenciaObjeto = pConsecuenciaObjeto;
		this.consecuenciaEscrita = pConsecuencia;
		this.requerimientoObjeto = pReqObjeto;
	}
	
	public void aplicarConsecuencias() {
		//tendra que imprimir las estadisticas del jugador y el inventario
		Jugador.getJugador().actualizarEstadisticas(this.consecuenciaSalud, this.consecuenciaHambre, this.consecuenciaSed, this.consecuenciaCordura);
		Jugador.getJugador().imprimirEstadisticas();
		Inventario.getInventario().imprimirInventario();
		System.out.println(this.consecuenciaEscrita);
	}
	
	public void imprimirOpcion() {
		System.out.println(this.enunciadoOpcion);
	}

}
