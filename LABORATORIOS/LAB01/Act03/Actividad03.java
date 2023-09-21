package LAB01.Act03;

import java.util.Scanner;

public class Actividad03 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] Nombre=new String[5];
        for(int i =0;i<Nombre.length;i++){
            System.out.print("Ingrese el nombre del soldado"+(i+1)+": ");
            Nombre[i]=sc.next();
        }
        for(int i =0;i<Nombre.length;i++){
            System.out.println("Soldado"+(i+1)+" : "+Nombre[i]);
            
        }
    }
}
