package org.wipgames.survivalvacation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
					System.out.println("_____________________________________");
					}
				else {
					Eventos.getMisEventos().activarEventoAleatorio();
					System.out.println("_____________________________________");
					}
				eventosOcurridos++;
				vivo = Jugador.getJugador().sigueVivo(); 
			}
			if(victoria) {
				System.out.println("Has ganado");
				}
			System.out.println("Introduce tu nombre");
			String nombre = Teclado.getMiTeclado().leerNombre();
			guardarEstadisticas(nombre, vivo, eventosOcurridos);
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
	
	private static void escribirAFichero(String pLinea) {
		String dirActual = System.getProperty("user.dir");
		String dirFicheroCompleto = dirActual +"\\src\\org\\wipgames\\survivalvacation\\"+ "Estadisticas.txt";
		try(FileWriter fw = new FileWriter(dirFicheroCompleto, true);
			    PrintWriter out = new PrintWriter(fw))
			{
			    out.println(pLinea);

			} catch (IOException e) {

			}
	}
	
	private static void guardarEstadisticas(String pNombre, boolean pVictoria, int pNumEventosOcurridos) {
		Calendar c = new GregorianCalendar();
		int dia = c.get(Calendar.DATE);     // los dias empiezan a contar desde uno, pero
		int mes = c.get(Calendar.MONTH) +1; // los meses empiezan a contar desde cero
		int annio = c.get(Calendar.YEAR);
		int hora = c.get(Calendar.HOUR);
		int minuto = c.get(Calendar.MINUTE);
		int segundo = c.get(Calendar.SECOND);
		
		String strDia = String.format("%02d", dia); 
		String strMes = String.format("%02d", mes);
		String strAnnio = String.format("%04d", annio);
		String strHora = String.format("%02d", hora); 
		String strMinuto = String.format("%02d", minuto);
		String strSegundo = String.format("%02d", segundo);
		
		String fechaConHora = strDia + "/" + strMes + "/" + strAnnio + "  " + strHora + ":" + strMinuto + ":" + strSegundo ;
		String lineaEstadistica = "";
		if(pVictoria) {
			lineaEstadistica = pNombre + " ha ganado con " + Integer.toString(pNumEventosOcurridos) + " eventos sobrevividos " + fechaConHora; 
		}else {
			lineaEstadistica = pNombre + " ha sobrevivido " + Integer.toString(pNumEventosOcurridos) + " eventos " + fechaConHora; 
		}
		escribirAFichero(lineaEstadistica);
		
	}
		
}
