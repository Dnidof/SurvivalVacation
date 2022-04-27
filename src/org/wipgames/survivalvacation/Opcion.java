package org.wipgames.survivalvacation;

public class Opcion {
	private String enunciadoOpcion;
	private int consecuenciaSalud;
	private int consecuenciaHambre;
	private int consecuenciaSed;
	private int consecuenciaCordura;
	private int consecuenciaObjeto;
	private int cantidadConsecuenciaObjeto;
	private String consecuenciaEscrita;
	private int requerimientoObjeto;
	private boolean opcionVictoria;
	
	public Opcion(String pEnunciado, int pSalud, int pHambre, int pSed, int pCordura,
			int pConsecuenciaObjeto, String pConsecuencia, int pReqObjeto ,int pCantidadConsecuenciaObjeto,boolean pOpcionVictoria) {
		this.enunciadoOpcion = pEnunciado;
		this.consecuenciaSalud = pSalud;
		this.consecuenciaHambre = pHambre;
		this.consecuenciaSed = pSed;
		this.consecuenciaCordura = pCordura;
		this.consecuenciaObjeto = pConsecuenciaObjeto;
		this.consecuenciaEscrita = pConsecuencia;
		this.requerimientoObjeto = pReqObjeto;
		this.cantidadConsecuenciaObjeto = pCantidadConsecuenciaObjeto;
		this.opcionVictoria = pOpcionVictoria; 
	}
	
	public void aplicarConsecuencias() {
		//FALTA LA CONSECUENCIA OBJETO
		//tendra que imprimir las estadisticas del jugador y el inventario
		Jugador.getJugador().actualizarEstadisticas(this.consecuenciaSalud, this.consecuenciaHambre, this.consecuenciaSed, this.consecuenciaCordura);
		//Inventario.getInventario().actualizarObjetoPorId(this.consecuenciaObjeto,this.cantidadConsecuenciaObjeto );
		Jugador.getJugador().imprimirEstadisticas();
		Inventario.getInventario().imprimirInventario();
		System.out.println(this.consecuenciaEscrita);
	}
	
	public boolean cumpleRequisitoObjeto() {
		Objeto objetoReq = Inventario.getInventario().buscarObjetoPorId(this.requerimientoObjeto);
		boolean cumpleRequisito = false;
		if (objetoReq != null) {
			if (objetoReq.getCantidad() >= 1  || objetoReq == null) {
				cumpleRequisito = true;
			}
		}
		return cumpleRequisito; 
	}
	
	public void imprimirOpcion() {
		System.out.print(this.enunciadoOpcion);
		Objeto objetoNecesario = Inventario.getInventario().buscarObjetoPorId(this.requerimientoObjeto);
		System.out.print(".Y necesitas este objeto");
		objetoNecesario.imprimirObjeto();
	}

}
