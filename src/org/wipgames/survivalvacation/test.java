package org.wipgames.survivalvacation;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class test {
	// Esta clase la voy a utilizar para prepararar los metodos de estadisticas, luego la borramos
	public static void main(String[] args) {
		imprimirEstadisticas();

	}
	
	private static void escribirAFichero(String pLinea,String pNombreFichero) {
		String dirActual = System.getProperty("user.dir");
		String dirFicheroCompleto = dirActual +"\\src\\org\\wipgames\\survivalvacation\\"+ pNombreFichero;
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
		
	}
	
	private static void crearEventos() {
		System.out.println("Introduce 1 si quieres crear eventos unicos o 2 para eventos consecutivos");
		int inputUsuario = Teclado.getMiTeclado().leerOpcion();
		while (inputUsuario != 1 || inputUsuario != 2) {
			inputUsuario = Teclado.getMiTeclado().leerOpcion();
		}
		if(inputUsuario == 1) {
			while(inputUsuario != -1) {
				System.out.println("Creando evento unico, introduce -1 si desea cancelar");
				//id$enunciado$opcion1$opcion2$opcion3 0-4
				//cada opcion enunciado%salud%hambre%sed%cordura%idConsecuenciaObjeto%cantidad%idObjetoReq%enunciado%victoria
				String eventoEnunciado;
				String aux;
				Teclado t =Teclado.getMiTeclado();
			
				System.out.println("Introduce el enunciado del evento");
				aux = t.leerNombre();
				eventoEnunciado =  Integer.toString(Eventos.getMisEventos().cantidadEventos())+"$"+aux;
				int numOpcion = 1;
				while(numOpcion <= 3 && !aux.equalsIgnoreCase("-1")) {
					eventoEnunciado = pedirOpcion(eventoEnunciado, numOpcion);
					numOpcion++;
				}
				escribirAFichero(eventoEnunciado, "Eventos.txt");
			}
		}else {
			
		}
	}
	

	
	private static String pedirOpcion(String pEventoEnunciado, int pNumOpcion) {
		String aux;
		Teclado t = Teclado.getMiTeclado();
		System.out.println("Introduce el enunciado de la "+ pNumOpcion +" opcion");
		aux = t.leerNombre();
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
		System.out.println("Introduce la cantidad de ese objeto");
		aux = t.leerNombre();
		pEventoEnunciado = pEventoEnunciado + "%" +aux;
		System.out.println("Introduce el id del objeto que requiere el evento (-1 para que no sea necesario ningun objeto)");
		aux = t.leerNombre();
		pEventoEnunciado = pEventoEnunciado + "%" +aux;
		System.out.println("Introduce el enunciado de la consecuencia");
		aux = t.leerNombre();
		pEventoEnunciado = pEventoEnunciado + "%" +aux;
		System.out.println("Introduce false/true (true si te lleva a la victoria de forma directa)");
		aux = t.leerNombre();
		pEventoEnunciado = pEventoEnunciado + "%" +aux;
		
		pEventoEnunciado = pEventoEnunciado +"$";
		
		return pEventoEnunciado;
	}

}
