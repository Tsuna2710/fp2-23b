package LAB02.EJER01;

import java.util.Arrays;
import java.util.Scanner;

public class Ejer01 {
	public static void main(String[] args) {
		String ahor1 = " +---+ \n"+
		" | | \n" +
		" | \n" +
		" | \n" +
		" | \n" +
		" | \n" +
		"========= ";
		String ahor2 = " +---+ \n"+
		" | | \n"+
		" O | \n"+
		" | \n"+
		" | \n"+
		" | \n"+
		"=========";
		String ahor3 = " +---+ \n"+
		" | | \n"+
		" O | \n"+
		" | | \n"+
		" | \n"+
		" | \n"+
		"=========";
		String ahor4 = " +---+ \n"+
		" | | \n"+
		" O | \n"+
		" /| | \n"+
		" | \n"+
		" | \n"+
		"=========";
		String ahor5 = " +---+ \n"+
		" | | \n"+
		" O | \n"+
		" /|\\ | \n"+
		" | \n"+
		" | \n"+
		"=========";
		String ahor6 = " +---+ \n"+
		" | | \n"+
		" O | \n"+
		" /|\\ | \n"+
		" / | \n"+
		" | \n"+
		"=========";    
		String ahor7 = " +---+ \n"+
		" | | \n"+
		" O | \n"+
		" /|\\ | \n"+
		" / \\ | \n"+
		" | \n"+
		"=========";    
		String [] figuras = {ahor1, ahor2, ahor3,ahor4,ahor5,ahor6,ahor7};
		int contador=1,intentos=0;
		String letra;
		String [] palabras = {"programacion", "java", "identacion", "clases",
			"objetos", "desarrollador", "pruebas"};
		String palSecreta = getPalabraSecreta(palabras);
		System.out.println(figuras[0]);
		mostrarBlancos(palSecreta);
		System.out.println("\n");
		String[] palSecArray=new String[palSecreta.length()];
		for(int i=0;i<palSecArray.length;i++){
			palSecArray[i]="_";     
		}
		while(contador <= 6){    
			int aux=0;
			for(int i=0;i<palSecArray.length;i++){
				
				if("_".equals(palSecArray[i])) aux++;
			}
			if(aux!=0){
				letra = ingreseLetra();
				if (letraEnPalabraSecreta(letra, palSecreta)){
					palSecArray=mostrarBlancosActualizados(letra, palSecreta,palSecArray);               
				}
				else{
					System.out.println(figuras[contador]);
					contador=contador+1;
				}
				intentos++;    
				System.out.println("\n");
			}
			
			
			else {
				System.out.println("Ganador, intentos: "+intentos);
				break;
			}        
		}
	}
	public static String getPalabraSecreta(String [] lasPalabras){
		String palSecreta;
		int ind;
		int indiceMayor = lasPalabras.length -1;
		int indiceMenor =0;
		ind = (int) ((Math.random()*(indiceMayor - indiceMenor + 1) + indiceMenor));
		return lasPalabras[ind];
	}
	public static void mostrarBlancos(String palabra) {
		for(int i=0; i< palabra.length(); i++)
		System.out.print("_ " );
	}
	public static String ingreseLetra(){
		String laLetra;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese letra: ");
		laLetra = sc.next();
		while(laLetra.length()!= 1){
			System.out.println("Ingrese letra: "); //COMPLETAR PARA VALIDAR CARACTERES PERMITIDOS
			laLetra = sc.next();
		}
		return laLetra;
	}
	public static boolean letraEnPalabraSecreta(String letra, String palSecreta ){
		for(int i =0;i<palSecreta.length();i++){
			if(letra.equals(palSecreta.substring(i, i+1))) return true;
		}
		return false;
	}
	public static String[] mostrarBlancosActualizados(String letra, String palSecreta,String[] palSecArray){
		for(int i=0; i< palSecreta.length(); i++){
			if(palSecArray[i].equals("_")){
				if(letra.equals(palSecreta.substring(i, i+1))) palSecArray[i]=letra;
			}
		}
		for(int i=0; i< palSecArray.length; i++){
			System.out.print(palSecArray[i]);
		}
		System.out.println("\n");
		return palSecArray;
	}
	    
}
