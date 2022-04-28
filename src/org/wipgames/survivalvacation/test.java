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

}
