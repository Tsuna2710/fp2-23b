package LAB01.Act04;

import java.util.Scanner;

public class Actividad04 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] Nombre=new String[5];
		int[] Vida=new int[5];
		for(int i =0;i<Nombre.length;i++){
			System.out.print("Ingrese el nombre del soldado"+(i+1)+": ");
			Nombre[i]=sc.next();
			System.out.print("Ingrese el vida del soldado"+(i+1)+": ");
			Vida[i]=sc.nextInt();
		}
		for(int i =0;i<Nombre.length;i++){
			System.out.println("Soldado"+(i+1)+" : "+Nombre[i]+","+Vida[i]);
		}
	}
    
}
