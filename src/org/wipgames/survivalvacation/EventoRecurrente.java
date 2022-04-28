package org.wipgames.survivalvacation;

public class EventoRecurrente extends Evento {
	
	public EventoRecurrente(int pId, String pEnunciado, Opcion pOpcion1, Opcion pOpcion2, Opcion pOpcion3) {
		super(0,pEnunciado,pOpcion1,pOpcion2,pOpcion3);
	}
	
	public int ejecutarEvento() {
		
		super.imprimirEvento();
		System.out.println("En caso de no querer usar tus recursos puedes pulsar 4. Si quieres ver tus estadisticas o objetos pulsa 8 o 9");
		boolean haPodidoRealizarse = false;
		while (!haPodidoRealizarse) {
			int opcion = Teclado.getMiTeclado().leerOpcion();
			if(opcion==1 && Inventario.getInventario().tieneEsteObjeto(Inventario.getInventario().buscarObjetoPorId(0))) {
				//el objeto 0 son las vendas y la opcion 1 es la salud
				this.getOpcion(1).aplicarConsecuencias();
				haPodidoRealizarse=true;
			}
			
			else if(opcion==2 && Inventario.getInventario().tieneEsteObjeto(Inventario.getInventario().buscarObjetoPorId(1))) {
				//el objeto 1 son las latas de comida y la opcion 2 es la comida
				this.getOpcion(2).aplicarConsecuencias();
				haPodidoRealizarse=true;
			}
			
			else if (opcion==3 && Inventario.getInventario().tieneEsteObjeto(Inventario.getInventario().buscarObjetoPorId(2))) {
				//el objeto 2 son las botellas de agua y la opcion 3 es la sed
				this.getOpcion(3).aplicarConsecuencias();
				haPodidoRealizarse=true;
			}
			
			else if (opcion==4)
			{
				haPodidoRealizarse=true;
			}
			
			else if(opcion==8) {
				Jugador.getJugador().imprimirEstadisticas();
			}
			
			else if(opcion==9) {
				Inventario.getInventario().imprimirInventario();
			}
					
			else
			{
				System.out.println("Intentalo de nuevo");
			}
			
		}
		Jugador.getJugador().actualizarEstadisticas(0, 0, 0, 1);
		System.out.println("�Tu cordura aumenta!");
		return 0;
}
}