package LAB04;

import java.util.Scanner;

public class DemoBatalla {
	public static void main(String[] args) {
		
		Nave [] misNaves = new Nave[3];
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
		System.out.println("\nNave con mayor numero de puntos: " + mostrarMayorPuntos(misNaves).getNombre());
		//leer un nombre
		//mostrar los datos de la nave con dicho nombre, mensaje de "no encontrado" en caso contrario
		System.out.println("Ingrese el nombre de a nave a buscar: ");
		String nombre=sc.next();
		int pos=busquedaLinealNombre(misNaves,nombre);
		if (pos!=-1) {
			System.out.println("nave: "+misNaves[pos].getNombre());
			System.out.println("puntos: "+misNaves[pos].getPuntos());
			System.out.println("posicion: "+misNaves[pos].getFila()+","+misNaves[pos].getColumna());
		}
		else System.out.println("No encontrado");
		System.out.println("Ordanar por puntos (Usando Burbuja)");
		ordenarPorPuntosBurbuja(misNaves);
		mostrarNaves(misNaves);
		System.out.println("Ordanar por nombre (Usando Burbuja)");
		ordenarPorNombreBurbuja(misNaves);
		mostrarNaves(misNaves);
		//mostrar los datos de la nave con dicho nombre, mensaje de "no encontrado" en caso contrario
		System.out.println("Ingrese el nombre de a nave a buscar: ");
		nombre=sc.next();
		pos=busquedaLinealNombre(misNaves,nombre);
		if (pos!=-1) {
			System.out.println("nave: "+misNaves[pos].getNombre());
			System.out.println("puntos: "+misNaves[pos].getPuntos());
			System.out.println("posicion: "+misNaves[pos].getFila()+","+misNaves[pos].getColumna());
		}
		else System.out.println("No encontrado");
		pos=busquedaBinariaNombre(misNaves,nombre);
		System.out.println("Ordanar por Puntos (Selección)");
		ordenarPorPuntosSeleccion(misNaves);
		mostrarNaves(misNaves);
		System.out.println("Ordanar por Puntos (inserción)");
		ordenarPorPuntosInsercion(misNaves);
		mostrarNaves(misNaves);
		System.out.println("Ordanar por Nombre (Selección)");
		ordenarPorNombreSeleccion(misNaves);
		mostrarNaves(misNaves);
		System.out.println("Ordanar por Nombre (inserción)");
		ordenarPorNombreInsercion(misNaves);
		mostrarNaves(misNaves);
	}
	//Metodo para mostrar todas las naves
	public static void mostrarNaves(Nave[] flota){
		for(int i=0;i<flota.length;i++){
			System.out.println(flota[i].getNombre());
		}
	}
	//Metodo para mostrar todas las naves de un nombre que se pide por teclado
	public static void mostrarPorNombre(Nave[] flota){
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
	//Metodo para mostrar todas las naves con un numero de puntos inferior o igual
	//al numero de puntos que se pide por teclado
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
	
	//Metodo que devuelve la Nave con mayor numero de Puntos
	public static Nave mostrarMayorPuntos(Nave[] flota){
		int mayor=0,pos=0;
		for(int i=0;i<flota.length;i++){
			if(flota[i].getPuntos()>=mayor){
				mayor=flota[i].getPuntos();
				pos=i; 
			}
		}
		
		return flota[pos];
	}
	//Metodo para buscar la primera nave con un nombre que se pidio por teclado
	public static int busquedaLinealNombre(Nave[] flota, String s){
		for(int i=0;i<flota.length;i++){
			if(s.equals(flota[i].getNombre())) return i;
		}
		return -1;
	}
	//Metodo que ordena por numero de puntos de menor a mayor
	public static void ordenarPorPuntosBurbuja(Nave[] flota){
		System.out.println("Ordenado por puntos");
		for(int i=0;i<flota.length;i++){
			for(int j=0;j<flota.length-1;j++){
				if(flota[j].getPuntos()>flota[j+1].getPuntos())
				intercambiar(flota,j,j+1);
			}
		}
		for(int i=0;i<flota.length;i++) System.out.println(flota[i].getNombre());
		
	}
	public static void intercambiar(Nave[] flota,int i, int j){
		Nave aux;
		aux=flota[i];
		flota[i]=flota[j];
		flota[j]=aux;
	}
	//Metodo que ordena por nombre de A a Z
	public static void ordenarPorNombreBurbuja(Nave[] flota){
		for(int i=0;i<flota.length;i++){
			for(int j=0;j<flota.length-1;j++){
				if(flota[j].getNombre().compareTo(flota[j+1].getNombre())>0){
					intercambiar(flota,j,j+1);
				}
			}
		}
		for(int i=0;i<flota.length;i++) System.out.println(flota[i].getNombre());
	}
	//Metodo para buscar la primera nave con un nombre que se pidio por teclado
	public static int busquedaBinariaNombre(Nave[] flota, String s){
		for(int i=0;i<flota.length;i++){
			if(s.equals(flota[i].getNombre())) return i;
		}
		return -1;   
	}
	//Metodo que ordena por numero de puntos de menor a mayor
	public static void ordenarPorPuntosSeleccion(Nave[] flota){
		System.out.println("Ordenado por puntos");
		for(int i=0;i<flota.length;i++){
			for(int j=0;j<flota.length-1;j++){
				if(flota[j].getPuntos()>flota[j+1].getPuntos())
				intercambiar(flota,j,j+1);
			}
		}
		for(int i=0;i<flota.length;i++) System.out.println(flota[i].getNombre());
	}
	//Metodo que ordena por nombre de A a Z
	public static void ordenarPorNombreSeleccion(Nave[] flota){
		for(int i=0;i<flota.length;i++){
			for(int j=0;j<flota.length-1;j++){
				if(flota[j].getNombre().compareTo(flota[j+1].getNombre())>0){
					intercambiar(flota,j,j+1);
				}
			}
		}
		for(int i=0;i<flota.length;i++) System.out.println(flota[i].getNombre());
	}
	//Metodo que muestra las naves ordenadas por numero de puntos de mayor a menor
	public static void ordenarPorPuntosInsercion(Nave[] flota){
		int j,Aux;
		Nave X;
		for(int i=0;i<flota.length;i++){
			Aux=flota[i].getPuntos();
			X=flota[i];
			j=i-1;
			while((j>=0) && (Aux<flota[i].getPuntos())){
				
				flota[j+1]=flota[j];
				
				j--;
			}
			
			flota[j+1]=X;
		}
	}
	//Metodo que muestra las naves ordenadas por nombre de Z a A
	public static void ordenarPorNombreInsercion(Nave[] flota){
		for(int i=0;i<flota.length;i++){
			for(int j=0;j<flota.length-1;j++){
				if(flota[j].getNombre().compareTo(flota[j+1].getNombre())>0){
					intercambiar(flota,j,j+1);
				}
			}
		}
		for(int i=0;i<flota.length;i++) System.out.println(flota[i].getNombre());
	}

	}
