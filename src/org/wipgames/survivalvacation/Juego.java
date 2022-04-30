package org.wipgames.survivalvacation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

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
		System.out.println("Presione 1 para iniciar partida, presione 2 para ver puntuaciones, 3 para crear eventos");
		int opcion = Teclado.getMiTeclado().leerOpcion();
		int eventosOcurridos = 1;
		boolean vivo=true;
		Eventos.getMisEventos().cargarEventosFichero("Eventos.txt");
		if (opcion==1) {
			Jugador.getJugador().resetearJugador();
			Inventario.getInventario().cargarObjetos();
			Inventario.getInventario().barco();
			while (vivo && !victoria && eventosOcurridos < Eventos.getMisEventos().cantidadEventos() + Eventos.getMisEventos().cantidadEventos() / 5) {
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
			if(victoria ||eventosOcurridos == Eventos.getMisEventos().cantidadEventos() + Eventos.getMisEventos().cantidadEventos() / 5 ) {
				System.out.println("Has ganado");
				}
			System.out.println("Introduce tu nombre");
			String nombre = Teclado.getMiTeclado().leerNombre();
			guardarEstadisticas(nombre, vivo, eventosOcurridos + 1);
			
		}
		else if (opcion==2) {
			imprimirEstadisticas();
		}else if (opcion == 3) {
			crearEventos();
		}
		
		partida();
	}
	

	
	
	public static Juego getJuego() {
		
		if (miJuego==null) {miJuego = new Juego();}
		return miJuego;
			
		}


	public void setVictoria() {
		victoria=true;
		
	}
	
	private static void escribirAFichero(String pLinea, String pNombreFichero) {
		String dirActual = System.getProperty("user.dir");
		String dirFicheroCompleto = dirActual +"\\src\\org\\wipgames\\survivalvacation\\"+ pNombreFichero;
		try(FileWriter fw = new FileWriter(dirFicheroCompleto, true);
			    PrintWriter out = new PrintWriter(fw))
			{
				out.println();
			    out.println(pLinea);

			} catch (IOException e) {

			}
	}
	
	private static void guardarEstadisticas(String pNombre, boolean pVictoria, int pNumEventosOcurridos) {
		Calendar c = new GregorianCalendar();
		int dia = c.get(Calendar.DATE);     // los dias empiezan a contar desde uno, pero
		int mes = c.get(Calendar.MONTH) +1; // los meses empiezan a contar desde cero
		int annio = c.get(Calendar.YEAR);
		int hora = c.get(Calendar.HOUR_OF_DAY);
		int minuto = c.get(Calendar.MINUTE);
		int segundo = c.get(Calendar.SECOND);
		
		String strDia = String.format("%02d", dia); 
		String strMes = String.format("%02d", mes);
		String strAnnio = String.format("%04d", annio);
		String strHora = String.format("%02d", hora); 
		String strMinuto = String.format("%02d", minuto);
		String strSegundo = String.format("%02d", segundo);
		
		String fechaConHora = strDia + "/" + strMes + "/" + strAnnio + "  " + strHora + ":" + strMinuto + ":" + strSegundo ;
		String lineaEstadistica = String.format("%-15.14s", pNombre );
		if(pVictoria) {
			lineaEstadistica +=  " ha ganado con  " + String.format("%-2.2s",Integer.toString(pNumEventosOcurridos)) + " eventos sobrevividos " + fechaConHora; 
		}else {
			lineaEstadistica +=  " ha sobrevivido " + String.format("%-2.2s",Integer.toString(pNumEventosOcurridos)) + " eventos " + fechaConHora; 
		}
		escribirAFichero(lineaEstadistica,"Estadisticas.txt");
		
	}
	
	private static void imprimirEstadisticas() {
		String dirActual = System.getProperty("user.dir");
		String dirFicheroCompleto = dirActual +"\\src\\org\\wipgames\\survivalvacation\\"+ "Estadisticas.txt";
		InputStream fichero;
		try {
			fichero = new FileInputStream(dirFicheroCompleto);
			Scanner sc = new Scanner(fichero);
			while(sc.hasNext()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero de estadisticas");
		}
		System.out.println();
		
	}
	
	private static void crearEventos() {
		System.out.println("Introduce 1 si quieres crear eventos unicos o 2 para eventos consecutivos");
		int inputUsuario = Teclado.getMiTeclado().leerOpcion();
		while (inputUsuario != 1 && inputUsuario != 2) {
			inputUsuario = Teclado.getMiTeclado().leerOpcion();
		}
		
		String eventoEnunciado = "";
		String aux;
		Teclado t =Teclado.getMiTeclado();
		//inputUsuario = t.leerOpcion();
		
		if(inputUsuario == 1) {
			System.out.println("Creando eventos unicos");
			//id$enunciado$opcion1$opcion2$opcion3 0-4
			//cada opcion enunciado%salud%hambre%sed%cordura%idConsecuenciaObjeto%cantidad%idObjetoReq%enunciado%victoria
			while(inputUsuario != -1) {
				System.out.println("Introduce el enunciado del evento");
				aux = t.leerNombre();
				eventoEnunciado =  Integer.toString(Eventos.getMisEventos().cantidadEventos())+"$"+aux;
				int numOpcion = 1;
				while(numOpcion <= 3 && !aux.equalsIgnoreCase("-1") ) {
					eventoEnunciado = pedirOpcion(eventoEnunciado, numOpcion);
					numOpcion++;
				}
				escribirAFichero(eventoEnunciado, "Eventos.txt");
				System.out.println("Pulsa -1 si no quieres crear más eventos");
				inputUsuario = t.leerOpcion();
			}
		}else if (inputUsuario == 2) {
			while(inputUsuario != -1) {
				for(int i = 1; i <= 3;i++) {
					System.out.println("Introduce el enunciado del evento" + Integer.toString(i));
					if(i == 1)System.out.println("Las opciones 2 y 3 del primer evento te llevaran al tercer evento, la 1 al segundo");
					aux = t.leerNombre();
					eventoEnunciado += "#" + Integer.toString(Eventos.getMisEventos().cantidadEventos())+"$"+aux;
					int numOpcion = 1;
					while(numOpcion <= 3 && !aux.equalsIgnoreCase("-1") ) {
						eventoEnunciado = pedirOpcion(eventoEnunciado, numOpcion);
						numOpcion++;
					}
				}
				escribirAFichero(eventoEnunciado, "Eventos.txt");
				System.out.println("Pulsa -1 si no quieres crear más eventos");
				inputUsuario = t.leerOpcion();
			}
			
		}
	}
	

	
	private static String pedirOpcion(String pEventoEnunciado, int pNumOpcion) {
		String aux;
		Teclado t = Teclado.getMiTeclado();
		System.out.println("Introduce el enunciado de la "+ pNumOpcion +" opcion, -1 si no quieres que haya opcion");
		aux = t.leerNombre();
		if(!aux.equals("-1")) {
			pEventoEnunciado = pEventoEnunciado + "$" +aux;
			System.out.println("Introduce la consecuencia de salud");
			aux = t.leerNombre();
			pEventoEnunciado = pEventoEnunciado + "%" +aux;
			System.out.println("Introduce la consecuencia de hambre");
			aux = t.leerNombre();
			pEventoEnunciado = pEventoEnunciado + "%" +aux;
			System.out.println("Introduce la consecuencia de sed");
			aux = t.leerNombre();
			pEventoEnunciado = pEventoEnunciado + "%" +aux;
			System.out.println("Introduce la consecuencia de cordura");
			aux = t.leerNombre();
			pEventoEnunciado = pEventoEnunciado + "%" +aux;
			System.out.println("Introduce el id de consecuenciaObjeto(-1 para que no haya una consecuencia de objeto)");
			aux = t.leerNombre();
			pEventoEnunciado = pEventoEnunciado + "%" +aux;
			if (!aux.equals("-1")) {
				System.out.println("Introduce la cantidad de ese objeto");
				aux = t.leerNombre();
				pEventoEnunciado = pEventoEnunciado + "%" +aux;
			}
			else {
				pEventoEnunciado = pEventoEnunciado + "%" +"0";
			}
			System.out.println("Introduce el id del objeto que requiere el evento (-1 para que no sea necesario ningun objeto)");
			aux = t.leerNombre();
			pEventoEnunciado = pEventoEnunciado + "%" +aux;
			System.out.println("Introduce el enunciado de la consecuencia");
			aux = t.leerNombre();
			pEventoEnunciado = pEventoEnunciado + "%" +aux;
			System.out.println("Introduce false/true (true si te lleva a la victoria de forma directa)");
			aux = t.leerNombre();
			pEventoEnunciado = pEventoEnunciado + "%" +aux;
		}else {
			pEventoEnunciado = pEventoEnunciado + "$-1%1%0%0%0%0%0%0% %false";
		}

		
		return pEventoEnunciado;
	}
		
}
