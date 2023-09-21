package LAB01.Act05;

import java.util.Scanner;

public class Actividad05 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int EjercitoCan1,EjercitoCan2;
		EjercitoCan1=(int)(Math.random()*5+1);
		EjercitoCan2=(int)(Math.random()*5+1);
		String[] Ejercito1=new String[EjercitoCan1];
		String[] Ejercito2=new String[EjercitoCan2];
		System.out.println("Ejercito 1");
		for(int i =0;i<Ejercito1.length;i++){
			System.out.println("Soldado"+(i+1));
		}
		System.out.println("Ejercito 2");
		for(int i =0;i<Ejercito2.length;i++){
			System.out.println("Soldado"+(i+1));
		}
		if(EjercitoCan1>EjercitoCan2)System.out.println("Ganador ejercito 1");
		else if(EjercitoCan1==EjercitoCan2)System.out.println("Empate");
		else System.out.println("Ganador ejercito 2");
	}   
}
