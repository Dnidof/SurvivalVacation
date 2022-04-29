package org.wipgames.survivalvacation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Eventos {
	private ArrayList<Evento> lista;
	private static Eventos misEventos;
	private Eventos() {
		this.lista = new ArrayList<Evento>();
	}
	public static Eventos getMisEventos() {
		if(misEventos == null) misEventos = new Eventos();
		return misEventos;
	}
	
	public void cargarEventosFichero(String pNombreFichero) {
		this.lista= new ArrayList <Evento>();
		String linea;
		String dirActual = System.getProperty("user.dir");
		String dirFicheroCompleto = dirActual +"\\src\\org\\wipgames\\survivalvacation\\"+ pNombreFichero;
		try {
			InputStream fichero = new FileInputStream(dirFicheroCompleto);
			Scanner sc = new Scanner(fichero);
			while(sc.hasNextLine()) {
				linea = sc.nextLine();
				if(linea.length() != 0 && linea.charAt(0) == '#') {
					try {
					linea = linea.substring(1);
					String[] eventos = linea.split("\\#");
					String[] parametrosEvento1 = eventos[0].split("\\$");
					String[] parametrosEvento2 = eventos[1].split("\\$");
					String[] parametrosEvento3 = eventos[2].split("\\$");
					
					EventoUnico e1 = this.crearEventoUnico(parametrosEvento1);
					EventoUnico e2 = this.crearEventoUnico(parametrosEvento2);
					EventoUnico e3 = this.crearEventoUnico(parametrosEvento3);
					EventoConsecutivo e4 = new EventoConsecutivo(this.cantidadEventos(),e1,e2,e3);
					this.lista.add(e4);
					} catch(NumberFormatException e) {
						System.out.println("Se  ha producido una NumberFormatException");
					} catch(IndexOutOfBoundsException e) {	//Si alguna linea tiene algun error de formato no se añade ese evento y pasamos de línea
						System.out.println("Se  ha producido una IndexOutOfBoundsException");
					}	
				}else { 
				String[] parametrosEvento = linea.split("\\$");
				//id$enunciado$opcion1$opcion2$opcion3 0-4
				//cada opcion enunciado%salud%hambre%sed%cordura%idConsecuenciaObjeto%cantidad%idObjetoReq%enunciado%victoria 0-9

				try {
					EventoUnico e = this.crearEventoUnico(parametrosEvento);
					
					this.lista.add(e);
				} catch(NumberFormatException e) {
					System.out.println("Se  ha producido una NumberFormatException");
				} catch(IndexOutOfBoundsException e) {	//Si alguna linea tiene algun error de formato no se añade ese evento y pasamos de línea
					System.out.println("Se  ha producido una IndexOutOfBoundsException");
				}		
			}// fin del else
			}// fin del while	
			sc.close();
		} catch (FileNotFoundException e) {
			//sino se ha encontrado eventos.txt (parámetro primera llamada) solicitamos el nombre del fichero al usuario 
			System.out.println("Fichero no encontrado");
			String str = Teclado.getMiTeclado().leerNombreFichero();
			cargarEventosFichero(str);
		}
		
	}
	public void activarEventoAleatorio() {
		
		Random dado = new Random();
		int numeroRandom = dado.nextInt(1,this.lista.size());
		if (!this.lista.get(numeroRandom).estaActivado()) {
			this.lista.get(numeroRandom).ejecutarEvento();

			}
		
		else {
			this.activarEventoAleatorio();
		}
		
	}
	public void activarEventoRecurrente() {
		
		this.lista.get(0).ejecutarEvento();
	}
	
	public int cantidadEventos() {
		return this.lista.size();
	}
	private Opcion crearOpcion(String[] pOpcionString) {
		int pSalud = Integer.parseInt(pOpcionString[1]);
		int pComida = Integer.parseInt(pOpcionString[2]);
		int pHidratacion = Integer.parseInt(pOpcionString[3]);
		int pCordura = Integer.parseInt(pOpcionString[4]);
		int pConsecuenciaObjeto = Integer.parseInt(pOpcionString[5]);
		int pReqObjeto = Integer.parseInt(pOpcionString[7]);
		int pCantidadConsecuenciaObjeto =  Integer.parseInt(pOpcionString[6]);
		boolean pOpcionVictoria = Boolean.parseBoolean(pOpcionString[9]);
		Opcion opcion = new Opcion(pOpcionString[0],pSalud,pComida,pHidratacion,pCordura,pConsecuenciaObjeto,pOpcionString[8],pReqObjeto,pCantidadConsecuenciaObjeto,pOpcionVictoria);
		return opcion;
	}
	private EventoUnico crearEventoUnico(String[] pParametrosEvento) {
		Opcion opcion1,opcion2,opcion3;
		String[] opcionString = pParametrosEvento[2].split("\\%");
		opcion1 = this.crearOpcion(opcionString);
		
		opcionString = pParametrosEvento[3].split("\\%");
		opcion2 = this.crearOpcion(opcionString);
		
		opcionString = pParametrosEvento[4].split("\\%");
		opcion3 = this.crearOpcion(opcionString);
		
		return new EventoUnico(Integer.parseInt(pParametrosEvento[0]),pParametrosEvento[1],opcion1,opcion2,opcion3);
		
	}
	
	

}
