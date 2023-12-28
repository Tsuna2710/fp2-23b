package LAB15;

import java.util.ArrayList;
import java.util.Scanner;

public class Videojuego11 {
        public static void main(String[] args) {
        
        ArrayList<Ejercito> Reino1=CrearReino(); 
        ArrayList<Ejercito> Reino2=CrearReino(Reino1);
        TableroReino(Reino1,Reino2);
        MostrarReinos(Reino1,Reino2);
        //Gestionar ejercito
        gestionarReinos(Reino1,Reino2);
        
    }
    public static ArrayList<Ejercito> CrearReino(){
        
        int n=(int)(Math.random()*10+1);
        String Nombre;
        String Pais=Ejercito.OpcionPais();
        Ejercito aux;
        ArrayList<Ejercito> Reino=new ArrayList<>();
        
        for(int i =0;i<n;i++){
                Nombre=Pais+" "+(i+1);
                aux=new Ejercito(Nombre,Pais);
                Reino.add(aux);
                for(int j=0;j<i;j++){
                    if(CasilleroOcupado(Reino.get(i),Reino.get(j))){
                        Reino.remove(i);
                        i--;
                        break;
                    }
                }
        }
        return Reino;
    }
    public static ArrayList<Ejercito> CrearReino(ArrayList<Ejercito> Reino1){
        
        int n=(int)(Math.random()*10+1);
        
        String Nombre;
        Ejercito aux;
        String Pais=Ejercito.OpcionPais();
        ArrayList<Ejercito> Reino2=new ArrayList<>();
        if(Pais.equals(Reino1.get(0).getPais())){
            CrearReino(Reino1);
        }
        else {
            
            
            for(int i =0;i<n;i++){

                    Nombre=Pais+" "+(i+1);

                    aux=new Ejercito(Nombre,Pais);
                    Reino2.add(aux);

                    for(int j=0;j<i;j++){
                        if(CasilleroOcupado(Reino2.get(i),Reino2.get(j))){
                            Reino2.remove(i);
                            i--;
                            break;
                        }
                    }
                    for(int j=0;j<Reino1.size();j++){
                        if(CasilleroOcupado(Reino2.get(i),Reino1.get(j))){
                            Reino2.remove(i);
                            i--;
                            break;
                        }
                    }
            }
        }
        return Reino2;
    }
    public static boolean CasilleroOcupado(Ejercito a,Ejercito b){
        return a.getFila()==b.getFila() && a.getColumna()==b.getColumna();
    }
    public static void TableroReino(ArrayList<Ejercito> Reino1 ,ArrayList<Ejercito> Reino2){
        int Auxiliar;
        System.out.println("\t  a\t  b\t  c\t  d\t  e\t  f\t  g\t  h\t  i\t  j");
        for (int x=0;x<10;x++){
            System.out.print("\t");
            for (int a=0;a<10;a++){
                System.out.print(" ___ \t");
            }
            System.out.println("");
            
            System.out.print((x+1)+"\t");
            for (int b=0;b<10;b++){
                Auxiliar=0;
                System.out.print("|");
                for (int m=0;m<Reino1.size();m++) {
                    if (Reino1.get(m).getFila() == x+1 && Reino1.get(m).getColumna() == b+1) {
                        System.out.print(" 0 ");
                        Auxiliar=1;
                    }
                }
                for (int m=0;m<Reino2.size();m++) {
                    if (Reino2.get(m).getFila() == x+1 && Reino2.get(m).getColumna() == b+1) {
                        System.out.print(" X ");
                        Auxiliar=1;
                    }
                }
                
                if(Auxiliar==0) {
                    System.out.print("   ");
                }
                System.out.print("|\t");
                
            }
            System.out.println("");
            System.out.print("\t");
            for (int c=0;c<10;c++){
                System.out.print("|___|\t");
            }
            System.out.println("");
        }
    }
    public static void MostrarReinos(ArrayList<Ejercito> Reino1,ArrayList<Ejercito> Reino2){
        int mayor;
        if(Reino1.size()>Reino2.size()) mayor=Reino1.size();
        else mayor=Reino2.size();
        System.out.println("\n"+Reino1.get(0).getPais()+" -0- \t\t\t"+Reino2.get(0).getPais()+"-X-");
        for(int i=0;i<mayor;i++){
            
            if(i<Reino1.size()){
                System.out.print(Reino1.get(i).toString()+"\t\t");
            }
            else System.out.print("\t\t\t\t");
            if(i<Reino2.size()){
                System.out.print(Reino2.get(i).toString());
            }
            System.out.print("\n");
        }
        
    }
    public static void gestionarReinos(ArrayList<Ejercito> a,ArrayList<Ejercito> b){
        Scanner sc =new Scanner (System.in);
        System.out.println("Ejija reino a gestionar\n"
                +"Opcion 1: "+a.get(0).getPais()+"\t Opcion 2: "+b.get(0).getPais());
        int Opcion=sc.nextInt();
        switch (Opcion) {
            case 1:
                Menu(a);
                break;
            case 2:
                Menu(b);
                break;
            default:
                System.out.println("Opcion invalida");
                gestionarReinos(a,b);
                break;
        }
        
    }
    public static void Menu(ArrayList<Ejercito> a){
        Scanner sc =new Scanner (System.in);
        int opcionEjercito;
        System.out.println("Escoja Ejercito a gestionar:");
        for(int i=0;i<a.size();i++){
            System.out.println((i+1)+".- "+a.get(i).toString());
        }
        opcionEjercito=sc.nextInt();
        ArrayList<Soldado> Ejercito1=CrearEjercito();
        a.get(opcionEjercito-1).setMiembros(Ejercito1);
        MenuEjercito(a.get(opcionEjercito-1).getMiembros());
    }
    public static void MenuEjercito(ArrayList<Soldado> a){
        TableroSoldados(a);
        
        MostrarSoldados(a);
        Gestion(a);
        
    }
    public static ArrayList<Soldado> CrearEjercito(){
        
        int n=(int)(Math.random()*10+1);
        
        String Nombre;
        Soldado aux;
        ArrayList<Soldado> Ejercito=new ArrayList<>();
        
        for(int i =0;i<n;i++){
                Nombre="Soldado"+(i);
                aux=new Soldado(Nombre);
                Ejercito.add(aux);
                
                for(int j=0;j<i;j++){
                    
                    if(CasilleroOcupado(Ejercito.get(i),Ejercito.get(j))){
                        Ejercito.remove(i);
                        i--;
                        break;
                    }
                }
        }
        return Ejercito;
    }
   
    
        //metodo para verificar si dos soldados ocupan el mismo casillero
    public static boolean CasilleroOcupado(Soldado a,Soldado b){
        return a.getFila()==b.getFila() && a.getColumna()==b.getColumna();
        }
    public static void TableroSoldados(ArrayList<Soldado> MiEjercito){
        int Auxiliar;
        System.out.println("\t  a\t  b\t  c\t  d\t  e\t  f\t  g\t  h\t  i\t  j");
        for (int x=0;x<10;x++){
            System.out.print("\t");
            for (int a=0;a<10;a++){
                System.out.print(" ___ \t");
            }
            System.out.println("");
            
            System.out.print((x+1)+"\t");
            for (int b=0;b<10;b++){
                Auxiliar=0;
                System.out.print("|");
                for (int m=0;m<MiEjercito.size();m++) {
                    if (MiEjercito.get(m).getFila() == x+1 && MiEjercito.get(m).getColumna() == b+1) {
                        System.out.print(" @ ");
                        Auxiliar=1;
                    }
                }
                
                if(Auxiliar==0) {
                    System.out.print("   ");
                }
                System.out.print("|\t");
                
            }
            System.out.println("");
            System.out.print("\t");
            for (int c=0;c<10;c++){
                System.out.print("|___|\t");
            }
            System.out.println("");
        }
        
    }
    public static void MostrarSoldados(ArrayList<Soldado> a){
        System.out.println("\n"+"Soldados"+"-@-");
        for(int i=0;i<a.size();i++){
                System.out.println(a.get(i).toString());
        }
        
    }   
    
    
    //Gestion de Ejercito
    public static void Gestion(ArrayList<Soldado> Ejercito1){
        int opcionGestion;
        Scanner sc=new Scanner(System.in);
        System.out.println("Menu de Gestion");
        System.out.println("1. Crear Soldado\n"
                + "2. Eliminar Soldado\n"
                + "3. Clonar Soldado\n"
                + "4. Modificar Soldado\n"
                + "5. Comparar Soldados\n"
                + "6. Intercambiar Soldados\n"
                + "7. Ver Soldado\n"
                + "8. Ver Ejercito\n"
                + "9. Sumar niveles\n"
                + "10. Volver menu Principal");
        opcionGestion=sc.nextInt();
        switch(opcionGestion){
            case 1:
                CrearSoldado(Ejercito1);
                MenuEjercito(Ejercito1);
                break;
            case 2:
                EliminarSoldado(Ejercito1);
                MenuEjercito(Ejercito1);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                VerSoldado(Ejercito1);
                break;
            case 8:
                VerEjercito(Ejercito1);
                MenuEjercito(Ejercito1);
                break;
            case 9:
                SumarNivel(Ejercito1);
                MenuEjercito(Ejercito1);
                break;
            case 10:
                MenuEjercito(Ejercito1);
                break;
            default:
                System.out.println("\nOpcion invalida\n");
                MenuEjercito(Ejercito1);
                break;
        }
    }
    //1
    public static ArrayList<Soldado> CrearSoldado(ArrayList<Soldado> Ejercito){
        Scanner sc=new Scanner(System.in);
        if(Ejercito.size()<=10){
            
            int ataque,vida,defensa,velocidad,fila,columna;
            
            System.out.println("Ingrese datos del Soldado"+Ejercito.size());
            System.out.print("Nivel deAtaque: ");
            ataque=sc.nextInt();
            System.out.print("Nivel de Vida: ");
            vida=sc.nextInt();
            System.out.print("Nivel de Defensa: ");
            defensa=sc.nextInt();
            System.out.print("Velocidad: ");
            velocidad=sc.nextInt();    
            System.out.print("Ingrese la posicion del nuevo soldado (ejm\"c 4\"): ");
            String Columna=sc.next();
            fila=sc.nextInt();
            String Texto="abcdefghijklmnop";
            columna=Texto.indexOf(Columna)+1;
            if((ataque>0 &&ataque<=5)&&(vida>0 &&vida<=5)&&
                    (defensa>0 &&defensa<=5)&&(velocidad>0 &&velocidad<=5)&&(fila>0 &&fila<=10)
                    &&(columna>0 &&columna<=10)){
                    System.out.println("Soldado añadido correctamente");
                    Ejercito.add(new Soldado(ataque,vida,defensa,velocidad,fila,columna));
            }
            else System.out.println("Soldado incompatilble");
        }
        else System.out.println("Numero maximo de soldados");
        return Ejercito;
    }
    //2
    public static ArrayList<Soldado> EliminarSoldado(ArrayList<Soldado> Ejercito){
        Scanner sc=new Scanner(System.in);
        int elegir;
        while(true){
            System.out.println("\nElija Soldado");
            for(int i=0;i<Ejercito.size();i++){
                System.out.println(i+".\t"+Ejercito.get(i).getNombre());
            }
            elegir=sc.nextInt();
            if(elegir>=0 && elegir<Ejercito.size()){
                Ejercito.remove(elegir);
                break;
            }
            else System.out.println("Opcion invalida");
        }
        return Ejercito;
    }
    //3
    
    //4
    //5
    //6
    //7
    public static void VerSoldado(ArrayList<Soldado> Ejercito){
        Scanner sc=new Scanner(System.in);
        int elegir;
        while(true){
            System.out.println("\nElija Soldado");
            for(int i=0;i<Ejercito.size();i++){
                System.out.println(i+".\t"+Ejercito.get(i).getNombre());
            }

            elegir=sc.nextInt();
            if(elegir>=0 && elegir<Ejercito.size()){
                System.out.println(Ejercito.get(elegir).MostarAtributos());
                break;
            }
            else System.out.println("Opcion invalida");
        }
    }
    //8
    public static void VerEjercito(ArrayList<Soldado> Ejercito){
        System.out.println("");
        for(int i=0;i<Ejercito.size();i++){
            System.out.println(i+".\t"+Ejercito.get(i).toString());
        }
    }
    //9
    public static void SumarNivel(ArrayList<Soldado> Ejercito){
        Soldado S=Ejercito.get(0);
        for(int i=1;i<Ejercito.size();i++){
            S=S.suma(Ejercito.get(i));
        }
        System.out.println("Vida:"+S.getNivelVida()+"\n"
                    + "Ataque: "+S.getNivelAtaque()+"\n"
                    + "Defensa: "+S.getNivelDefensa()+"\n"
                    + "Velocidad: "+S.getVelocidad()+"\n");
    }
}
