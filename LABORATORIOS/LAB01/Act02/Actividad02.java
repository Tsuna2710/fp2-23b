package LAB01.Act02;
import java.util.Scanner;

public class Actividad02 {
    	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Nombre1,Nombre4,Nombre2,Nombre3,Nombre5;
		int Vida1,Vida2,Vida3,Vida4,Vida5;
		System.out.print("Ingrese el nombre del soldado1: ");
		Nombre1=sc.next();
		System.out.print("Ingrese el vida del soldado1: ");
		Vida1=sc.nextInt();
		
		System.out.print("Ingrese el nombre del soldado2: ");
		Nombre2=sc.next();
		System.out.print("Ingrese el vida del soldado2: ");
		Vida2=sc.nextInt();
		
		System.out.print("Ingrese el nombre del soldado3: ");
		Nombre3=sc.next();;
		System.out.print("Ingrese el vida del soldado3: ");
		Vida3=sc.nextInt();
		System.out.print("Ingrese el nombre del soldado4: ");
		Nombre4=sc.next();
		System.out.print("Ingrese el vida del soldado4: ");
		Vida4=sc.nextInt();
		System.out.print("Ingrese el nombre del soldado5: ");
		Nombre5=sc.next();
		System.out.print("Ingrese el vida del soldado5: ");
		Vida5=sc.nextInt();
		System.out.println("Soldado 1 :"+Nombre1+","+Vida1+"\n"+
		"Soldado 2 :"+Nombre2+","+Vida2+"\n"+
		"Soldado 3 :"+Nombre3+","+Vida3+"\n"+
		"Soldado 4 :"+Nombre4+","+Vida4+"\n"+
		"Soldado 5 :"+Nombre5+","+Vida5);
	}
}
