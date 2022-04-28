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
		String dirFicheroCompleto = "C:\\Users\\imano\\git\\SurvivalVacation\\src\\org\\wipgames\\survivalvacation\\" + pNombreFichero;
		try {
			InputStream fichero = new FileInputStream(dirFicheroCompleto);
			Scanner sc = new Scanner(fichero);
			while(sc.hasNextLine()) {
				linea = sc.nextLine();
				String[] parametrosEvento = linea.split("\\$");
				//id$enunciado$opcion1$opcion2$opcion3 0-4
				//cada opcion enunciado%salud%hambre%sed%cordura%idConsecuenciaObjeto%cantidad%idObjetoReq%enunciado%victoria 0-9
				Opcion opcion1,opcion2,opcion3;
				try {
					int pSalud,pHambre,pSed,pCordura,pConsecuenciaObjeto,pReqObjeto,pCantidadConsecuenciaObjeto;
					boolean pOpcionVictoria;
					String[] opcionString = parametrosEvento[2].split("\\%");
					pSalud = Integer.parseInt(opcionString[1]);
					pHambre = Integer.parseInt(opcionString[2]);
					pSed = Integer.parseInt(opcionString[3]);
					pCordura = Integer.parseInt(opcionString[4]);
					pConsecuenciaObjeto = Integer.parseInt(opcionString[5]);
					pReqObjeto = Integer.parseInt(opcionString[7]);
					pCantidadConsecuenciaObjeto =  Integer.parseInt(opcionString[6]);
					pOpcionVictoria = Boolean.parseBoolean(opcionString[9]);
					opcion1 = new Opcion(opcionString[0],pSalud,pHambre,pSed,pCordura,pConsecuenciaObjeto,opcionString[8],pReqObjeto,pCantidadConsecuenciaObjeto,pOpcionVictoria);
					
					opcionString = parametrosEvento[3].split("\\%");
					pSalud = Integer.parseInt(opcionString[1]);
					pHambre = Integer.parseInt(opcionString[2]);
					pSed = Integer.parseInt(opcionString[3]);
					pCordura = Integer.parseInt(opcionString[4]);
					pConsecuenciaObjeto = Integer.parseInt(opcionString[5]);
					pReqObjeto = Integer.parseInt(opcionString[7]);
					pCantidadConsecuenciaObjeto =  Integer.parseInt(opcionString[6]);
					pOpcionVictoria = Boolean.parseBoolean(opcionString[9]);
					opcion2 = new Opcion(opcionString[0],pSalud,pHambre,pSed,pCordura,pConsecuenciaObjeto,opcionString[8],pReqObjeto,pCantidadConsecuenciaObjeto,pOpcionVictoria);
					
					opcionString = parametrosEvento[4].split("\\%");
					pSalud = Integer.parseInt(opcionString[1]);
					pHambre = Integer.parseInt(opcionString[2]);
					pSed = Integer.parseInt(opcionString[3]);
					pCordura = Integer.parseInt(opcionString[4]);
					pConsecuenciaObjeto = Integer.parseInt(opcionString[5]);
					pReqObjeto = Integer.parseInt(opcionString[7]);
					pCantidadConsecuenciaObjeto =  Integer.parseInt(opcionString[6]);
					pOpcionVictoria = Boolean.parseBoolean(opcionString[9]);
					opcion3 = new Opcion(opcionString[0],pSalud,pHambre,pSed,pCordura,pConsecuenciaObjeto,opcionString[8],pReqObjeto,pCantidadConsecuenciaObjeto,pOpcionVictoria);
					
					this.lista.add(new EventoUnico(Integer.parseInt(parametrosEvento[0]),parametrosEvento[1],opcion1,opcion2,opcion3));
				} catch(NumberFormatException e) {
					System.out.println("Se  ha producido una NumberFormatException");
				} catch(IndexOutOfBoundsException e) {	//Si alguna linea tiene algun error de formato no se añade ese evento y pasamos de línea
					System.out.println("Se  ha producido una IndexOutOfBoundsException");
				}		
			}
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
	

}
