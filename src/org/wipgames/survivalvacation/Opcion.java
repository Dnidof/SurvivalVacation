package org.wipgames.survivalvacation;

import java.util.Random;

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
			if (this.requerimientoObjeto != 0 && this.requerimientoObjeto != 1 && this.requerimientoObjeto != 2) {
				Random dado = new Random();
				int numeroRandom = dado.nextInt(1,10);
				if (numeroRandom >7) {
					System.out.print("Vaya, se te ha roto tu /s ");
					Inventario.getInventario().buscarObjetoPorId(this.requerimientoObjeto).imprimirNombreObjeto();
					Inventario.getInventario().actualizarObjetoPorId(this.requerimientoObjeto,-1);
				}
			}
			else {
				Inventario.getInventario().actualizarObjetoPorId(this.requerimientoObjeto,-1);
			}
		}
		if(this.opcionVictoria) {
			Juego.getJuego().setVictoria();
		}
		System.out.printf("%n%s%n",this.consecuenciaEscrita);
	
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
		else if (objetoReq.getCantidad() < 1){
			System.out.println("No tienes el objeto requerido");
		}
		else {
			System.out.println("No existe esa opcion");
		}
		return cumpleRequisito; 
	}
	
	public void imprimirOpcion(String pNumOpcion) {
		if (!this.enunciadoOpcion.equals("-1")) { //si el enuncaido de la opcion es -1 es como si no hubiese opcion
			System.out.print(pNumOpcion + " " + String.format("%-10.100s", this.enunciadoOpcion+"."));
			if (this.requerimientoObjeto != -1) {// si el id del ibjeto es -1 no se necesita objeto
				Objeto objetoNecesario = Inventario.getInventario().buscarObjetoPorId(this.requerimientoObjeto);
				System.out.println("Necesitas este objeto: " + objetoNecesario.imprimirNombreObjeto());
				} 
			else {
				System.out.println();
				}
			}
		}
}
