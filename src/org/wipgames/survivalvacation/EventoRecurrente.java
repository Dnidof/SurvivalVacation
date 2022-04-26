package org.wipgames.survivalvacation;

public class EventoRecurrente extends Evento {
	private int idEvento=0;
	
	public EventoRecurrente(int pId, String pEnunciado, Opcion pOpcion1, Opcion pOpcion2, Opcion pOpcion3, int idEvento) {
		super(pId,pEnunciado,pOpcion1,pOpcion2,pOpcion3);
		this.idEvento= idEvento;
	}
	
	public void ejecutarEvento() {
		
		super.imprimirEvento();
		System.out.println("En caso de no querer usar tus recursos puedes pulsar 4");
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
			else
			{
				System.out.println("No tienes el objeto master");
			}
			Jugador.getJugador().actualizarEstadisticas(0, 0, 0, 1);
			System.out.println("�Tu cordura aumenta!");
	}

}
}