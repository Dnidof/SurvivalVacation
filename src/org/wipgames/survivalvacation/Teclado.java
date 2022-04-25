package org.wipgames.survivalvacation;

import java.util.Scanner;

public class Teclado {
	private Scanner sc;
	private static Teclado miTeclado;
	
	private Teclado() {
		this.sc = new Scanner(System.in);
	}
	
	public static Teclado getMiTeclado() {
		if(miTeclado == null) miTeclado = new Teclado();
		return miTeclado;
	}
	public int leerOpcion() {
		System.out.println("Introduce tu opcion:");
		String str = this.sc.nextLine();
		int opcion = -1;
		try {
			opcion = Integer.parseInt(str);
		} catch(NumberFormatException  e){
			System.out.println("Por favor introduzca una opcion válida");
			leerOpcion();
		}
		return opcion;
	}
	
	public String leerNombreFichero() {
		System.out.println("Introduce el nombre de tu fichero .txt, asegurate de que este en los archivos del juego:");
		String str = this.sc.nextLine();
		return str;
	}
	

}
//hola