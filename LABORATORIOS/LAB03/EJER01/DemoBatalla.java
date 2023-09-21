package LAB03.EJER01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DemoBatalla {
	public static void main(String [] args){
		Nave [] misNaves = new Nave[5];
		Scanner sc = new Scanner(System.in);
		String nomb, col;
		int fil, punt;
		boolean est;
		for (int i = 0; i < misNaves.length; i++) {
			System.out.println("Nave " + (i+1));
			System.out.print("Nombre: ");
			nomb = sc.next();
			System.out.println("Fila ");
			fil = sc.nextInt();
			System.out.print("Columna: ");
			col = sc.next();
			System.out.print("Estado: ");
			est = sc.nextBoolean();
			System.out.print("Puntos: ");
			punt = sc.nextInt();
			misNaves[i] = new Nave(); //Se crea un objeto Nave y se asigna su referencia a misNaves
			misNaves[i].setNombre(nomb);
			misNaves[i].setFila(fil);
			misNaves[i].setColumna(col);
			misNaves[i].setEstado(est);
			misNaves[i].setPuntos(punt);
		}
		System.out.println("\nNaves creadas:");
		mostrarNaves(misNaves);
		mostrarPorNombre(misNaves);
		mostrarPorPuntos(misNaves);
		System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves).getNombre());
		mostrarDesordenado(misNaves);
	}
	//Método para mostrar todas las naves
	public static void mostrarNaves(Nave [] flota){
		for(int i=0;i<flota.length;i++){
			System.out.println(flota[i].getNombre());
		}
	}
	//Método para mostrar todas las naves de un nombre que se pide por teclado
	public static void mostrarPorNombre(Nave [] flota){
		Scanner sc = new Scanner(System.in);
		int n;
		do{
			System.out.println("Ingrese el numero de naves a mostrar: ");
			n=sc.nextInt();
			if(n>0 && n<=flota.length) break;
			else System.out.println("Numero invalido"); 
		}while(true);
		for(int i=0;i<n;i++){
			System.out.println(flota[i].getNombre());
		}
	}
	//Método para mostrar todas las naves con un número de puntos inferior o igual
	//al número de puntos que se pide por teclado
	public static void mostrarPorPuntos(Nave[] flota){
		Scanner sc = new Scanner(System.in);
		int puntos;
		do{
			System.out.println("Ingrese el numero de puntos de referencia: ");
			puntos=sc.nextInt();
			if(puntos>0 ) break;
			else System.out.println("Numero invalido"); 
		}while(true);
		for(int i=0;i<flota.length;i++){
			if(flota[i].getPuntos()<=puntos){
				System.out.println(flota[i].getNombre()); 
			}
		}
	}
	//Método que devuelve la Nave con mayor número de Puntos
	public static Nave mostrarMayorPuntos(Nave [] flota){
		int mayor=0,pos=0;
		for(int i=0;i<flota.length;i++){
			if(flota[i].getPuntos()>=mayor){
				mayor=flota[i].getPuntos();
				pos=i; 
			}
		}
		return flota[pos];
	}
	//Crear un método que devuelva un nuevo arreglo de objetos con todos los objetos previamente ingresados
	//pero aleatoriamente desordenados
	public static void mostrarDesordenado(Nave [] flota){
		Random r = new Random();
		int posAleatoria;
		Nave temp;
        for (int i=0; i<flota.length; i++) {
            posAleatoria = r.nextInt(flota.length);
            temp = flota[i];
            flota[i] = flota[posAleatoria];
            flota[posAleatoria] = temp;
        }
		System.out.println("\n Naves desaordenadas\n");
		mostrarNaves(flota);
	}
}
