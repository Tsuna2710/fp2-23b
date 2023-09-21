import java.util.Scanner;

public class Actividad01 {
    	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Nombre1,Nombre4,Nombre2,Nombre3,Nombre5;
		System.out.print("Ingrese el nombre del soldado1: ");
		Nombre1=sc.nextLine();
		System.out.print("Ingrese el nombre del soldado2: ");
		Nombre2=sc.nextLine();
		System.out.print("Ingrese el nombre del soldado3: ");
		Nombre3=sc.nextLine();
		System.out.print("Ingrese el nombre del soldado4: ");
		Nombre4=sc.nextLine();
		System.out.print("Ingrese el nombre del soldado5: ");
		Nombre5=sc.nextLine();
		System.out.println("Soldado 1 :"+Nombre1+"\n"+
		"Soldado 2 :"+Nombre2+"\n"+
		"Soldado 3 :"+Nombre3+"\n"+
		"Soldado 4 :"+Nombre4+"\n"+
		"Soldado 5 :"+Nombre5);
	}
}
