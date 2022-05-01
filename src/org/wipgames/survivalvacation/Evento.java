package org.wipgames.survivalvacation;

public abstract class Evento {
	private int idEvento;
	private String enunciado;
	private boolean activado;
	private Opcion opcion1;
	private Opcion opcion2;
	private Opcion opcion3;
	
	public Evento(int pId, String pEnunciado, Opcion pOpcion1, Opcion pOpcion2, Opcion pOpcion3) {
		this.idEvento = pId;
		this.enunciado = pEnunciado;
		this.opcion1 = pOpcion1;
		this.opcion2 = pOpcion2;
		this.opcion3 = pOpcion3;	
		this.activado = false;
		
		
	}
	public abstract int ejecutarEvento();

	public void imprimirEvento() {
		if(this.enunciado.length() >= 200 ) {			
			String consecuenciaLarga[] = this.enunciado.split(" ");
			int contadorPalabra = 1;
			System.out.println();
			for(String palabra:consecuenciaLarga) {
				System.out.printf("%s ",palabra);
				if(contadorPalabra >= 30) {
					//Cada linea tendra como maximo 30 palabras en la consecuencia
					contadorPalabra = 0;
					System.out.println();
				}
				contadorPalabra++;
			}
			System.out.println();
		}else {
			System.out.println(this.enunciado);
		}
		this.opcion1.imprimirOpcion("1");
		this.opcion2.imprimirOpcion("2");
		this.opcion3.imprimirOpcion("3");
		
	}
	
	protected Opcion getOpcion(int pNum) {
		Opcion unaOpcion;
		if (pNum==1) {
			unaOpcion=opcion1;
		}
		else if (pNum==2) {
			unaOpcion=opcion2;
		}
		else {
			unaOpcion=opcion3;
		}
		return unaOpcion;
	}

	public boolean estaActivado() {
		return this.activado;
	}
	protected void activarEvento() {
		this.activado = true;
	} 
}
