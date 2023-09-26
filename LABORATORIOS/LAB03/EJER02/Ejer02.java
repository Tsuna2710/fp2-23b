package LAB03.EJER02;

import java.util.Scanner;

public class Ejer02 {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String Nombre;
        int Vida;
        Soldado [] miEjercito= new Soldado[5];
        for (int i=0;i<miEjercito.length;i++){
            System.out.println("Ingrese Nombre: ");
            Nombre=sc.next();
            System.out.println("Ingrese Vida: ");
            Vida=sc.nextInt();
            miEjercito[i]=new Soldado(Nombre,Vida);
        }
        for (int j=0;j<miEjercito.length;j++){
            System.out.println(miEjercito[j].toString());
        }
    }
}
