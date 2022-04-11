package org.wipgames.survivalvacation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
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
		String linea;
		String dirActual = System.getProperty("user.dir");
		String dirFicheroCompleto = dirActual + File.separator + pNombreFichero;
		try {
			InputStream fichero = new FileInputStream(dirFicheroCompleto);
			Scanner sc = new Scanner(fichero);
			while(sc.hasNextLine()) {
				linea = sc.nextLine();
				String[] parametrosEvento = linea.split("$");
				//id$enunciado$opcion1$opcion2$opcion3 0-4
				//cada opcion enunciado%2%3%4%5%6%enunciado%8 0-7
				Opcion opcion1,opcion2,opcion3;
				try {
					int pSalud,pHambre,pSed,pCordura,pConsecuenciaObjeto,pReqObjeto;
					String[] opcionString = parametrosEvento[2].split("%");
					pSalud = Integer.parseInt(opcionString[1]);
					pHambre = Integer.parseInt(opcionString[2]);
					pSed = Integer.parseInt(opcionString[3]);
					pCordura = Integer.parseInt(opcionString[4]);
					pConsecuenciaObjeto = Integer.parseInt(opcionString[5]);
					pReqObjeto = Integer.parseInt(opcionString[7]);
					opcion1 = new Opcion(opcionString[0],pSalud,pHambre,pSed,pCordura,pConsecuenciaObjeto,opcionString[6],pReqObjeto);
					
					opcionString = parametrosEvento[3].split("%");
					pSalud = Integer.parseInt(opcionString[1]);
					pHambre = Integer.parseInt(opcionString[2]);
					pSed = Integer.parseInt(opcionString[3]);
					pCordura = Integer.parseInt(opcionString[4]);
					pConsecuenciaObjeto = Integer.parseInt(opcionString[5]);
					pReqObjeto = Integer.parseInt(opcionString[7]);
					opcion2 = new Opcion(opcionString[0],pSalud,pHambre,pSed,pCordura,pConsecuenciaObjeto,opcionString[6],pReqObjeto);
					
					opcionString = parametrosEvento[4].split("%");
					pSalud = Integer.parseInt(opcionString[1]);
					pHambre = Integer.parseInt(opcionString[2]);
					pSed = Integer.parseInt(opcionString[3]);
					pCordura = Integer.parseInt(opcionString[4]);
					pConsecuenciaObjeto = Integer.parseInt(opcionString[5]);
					pReqObjeto = Integer.parseInt(opcionString[7]);
					opcion3 = new Opcion(opcionString[0],pSalud,pHambre,pSed,pCordura,pConsecuenciaObjeto,opcionString[6],pReqObjeto);
					
					this.lista.add(new EventoUnico(Integer.parseInt(parametrosEvento[0]),parametrosEvento[1],opcion1,opcion2,opcion3));
				} catch(NumberFormatException e) {
					
				} catch(IndexOutOfBoundsException e) {}		
			}
		} catch (FileNotFoundException e) {
			//sino se ha encontrado eventos.txt (parámetro primera llamada) solicitamos el nombre del fichero al usuario 
			System.out.println("Fichero no encontrado");
			String str = Teclado.getMiTeclado().leerNombreFichero();
			cargarEventosFichero(str);
		}
		
	}
	
	public void anadirEvento(int pIdEvento, String pEnunciado, Opcion pOpcion1, Opcion pOpcion2, Opcion pOpcion3) {
		
		
	}
	
	

}
