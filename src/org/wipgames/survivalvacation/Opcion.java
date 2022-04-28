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

		Jugador.getJugador().actualizarEstadisticas(this.consecuenciaSalud, this.consecuenciaHambre, this.consecuenciaSed, this.consecuenciaCordura);
		Inventario.getInventario().actualizarObjetoPorId(this.consecuenciaObjeto,this.cantidadConsecuenciaObjeto);
		if(this.requerimientoObjeto!=-1) {
			Inventario.getInventario().actualizarObjetoPorId(this.requerimientoObjeto,-1);
		}
		if(this.opcionVictoria) {
			Juego.getJuego().setVictoria();
		}
		System.out.println(this.consecuenciaEscrita);
				
	}
	
	public boolean cumpleRequisitoObjeto() {
		Objeto objetoReq = Inventario.getInventario().buscarObjetoPorId(this.requerimientoObjeto);
		boolean cumpleRequisito = false;
		if (objetoReq == null) {
			cumpleRequisito = true;
		}
		else if (objetoReq.getCantidad() >= 1 && !this.enunciadoOpcion.equals("-1")) {
				cumpleRequisito = true;
		}
		return cumpleRequisito; 
	}
	
	public void imprimirOpcion(String pnumOpcion) {
		if (!this.enunciadoOpcion.equals("-1")) { //si el enuncaido de la opcion es -1 es como si no hubiese opcion
			System.out.print(pnumOpcion + " " +this.enunciadoOpcion);
			Objeto objetoNecesario = Inventario.getInventario().buscarObjetoPorId(this.requerimientoObjeto);
			if (!objetoNecesario.tieneEsteId(-1)) {// si el id del ibjeto es -1 no se necesita objeto
				System.out.println(". Necesitas este objeto: " + objetoNecesario.imprimirNombreObjeto());
				}
			}
		}
}
