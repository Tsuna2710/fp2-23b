package LAB09;

import java.util.HashMap;

public class Videojuego6 {
    public static void main(String[] args) {
        
            
        HashMap<Integer,Soldado> Ejercito1= CrearEjercito();
        
        HashMap<Integer,Soldado> Ejercito2= CrearEjercito();
        

        Tablero(Ejercito1, Ejercito2);
        
        System.out.println("");
        System.out.println("Ejercito 1 ( 0 )");
        for(int i=0;i<Ejercito1.size();i++){
            System.out.println(Ejercito1.get(i).toString());
        }
        
        System.out.println("===========================");
        System.out.print("Mayor vida: ");
        System.out.println(mayorVida(Ejercito1).toString());
        System.out.println("Promedio de Vida: "+promedioVida(Ejercito1));
        System.out.println("===========================");
        System.out.println("Ordenar por vida(mayor a menor)");
        imprimirVida(OrdenarPorVida(Ejercito1));
        System.out.println("Ordenar por vida-Insercion(menor a mayor)");
        imprimirVida(OrdenarVidaInsercion(Ejercito1));
        System.out.println("");
        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("");
        
        System.out.println("\n \n \n");
        System.out.println("Ejercito 2 ( X )");
        for(int i=0;i<Ejercito2.size();i++){
            System.out.println(Ejercito2.get(i).toString());
        }
        System.out.println("===========================");
        System.out.print("Mayor vida: ");
        System.out.println(mayorVida(Ejercito2).toString());
        System.out.println("Promedio de Vida: "+promedioVida(Ejercito2));
        System.out.println("===========================");
        System.out.println("Ordenar por vida(mayor a menor)");
        imprimirVida(OrdenarPorVida(Ejercito2));
        System.out.println("Ordenar por vida-Insercion(menor a mayor)");
        imprimirVida(OrdenarVidaInsercion(Ejercito2));
        
        System.out.println("");
        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("");
        System.out.println("\n \n \nBATALLA");
        Batalla(Ejercito1,Ejercito2);
        System.out.println("\n \n \n");
        
    }
        
    public static HashMap<Integer,Soldado> CrearEjercito(){
        
        int n=(int)(Math.random()*10+1),Vida,Fila,Columna=0,contador;
        int Ataque,Defensa;
        String Nombre;
        Soldado aux;
        HashMap<Integer,Soldado> Ejercito= new HashMap<Integer,Soldado>();
        for(int i =0;i<n;i++){
            
                
                Nombre="Soldado"+(i+1);
                Vida=(int)(Math.random()*5+1);
                Fila=(int)(Math.random()*10+1);
                Ataque=(int)(Math.random()*5+1);
                Defensa=(int)(Math.random()*5+1);
                Columna=(int)(Math.random()*10+1);
                aux=new Soldado(Nombre,Ataque,Vida,Defensa,Fila,Columna);
                Ejercito.put(i, aux);
                
                for(int j=0;j<i;j++){
                    //if(Fila==miEjercito[j].getFila() && Columna==miEjercito[j].getColumna())
                    if(Fila==Ejercito.get(j).getFila() && Columna==Ejercito.get(i).getColumna()){
                        
                        Ejercito.remove(i);
                        i--;
                        break;
                    }
                }
                
            
            
            
        }
        return Ejercito;
    }
    public static void Tablero(HashMap<Integer,Soldado> MiEjercito,HashMap<Integer,Soldado> TuEjercito){
        int Auxiliar;
        for (int x=0;x<10;x++){
            for (int a=0;a<10;a++){
                System.out.print(" ___ \t");
            }
            System.out.println("");
            
            for (int b=0;b<10;b++){
                Auxiliar=0;
                System.out.print("|");
                for (int m=0;m<MiEjercito.size();m++) {
                    if (MiEjercito.get(m).getFila() == x+1 && MiEjercito.get(m).getColumna() == b+1) {
                        System.out.print(" 0 ");
                        Auxiliar=1;
                    }
                }
                for (int m=0;m<TuEjercito.size();m++) {
                    if (TuEjercito.get(m).getFila() == x+1 && TuEjercito.get(m).getColumna() == b+1) {
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
            for (int c=0;c<10;c++){
                System.out.print("|___|\t");
            }
            System.out.println("");
        }
        
    }  
    public static Soldado mayorVida(HashMap<Integer,Soldado> a){
        int mayor=0;
        Soldado Mayor=null;
        for(int i=0;i<a.size();i++){
            if(a.get(i).getNivelVida()>mayor){
                Mayor=a.get(i);
                mayor=a.get(i).getNivelVida();
            }
                
        }
        return Mayor;
    }
    public static double promedioVida(HashMap<Integer,Soldado> a){
        return (double)sumaVida(a)/(double)a.size();
    }
    public static int sumaVida(HashMap<Integer,Soldado> a){
        int suma=0;
        for(int i=0;i<a.size();i++){
            suma=suma+a.get(i).getNivelVida();
        }
        return suma;
    }
    public static HashMap<Integer,Soldado> OrdenarPorVida(HashMap<Integer,Soldado> a){
        int auxiliar;
        Soldado aux;
        for(int x=0;x<a.size()-1;x++){
            int mayor=a.get(x).getNivelVida(),pos=x;
            for(int i=x+1;i<a.size();i++){
               if(mayor<a.get(i).getNivelVida()) {
                    mayor=a.get(i).getNivelVida();
                    pos=i;
                }  
            }
            aux=a.get(pos);
            a.put(pos, a.get(x));
            a.put(x, aux);
        }
        return a;
    }
    public static void imprimirVida(HashMap<Integer,Soldado> a){
        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i).getNombre()+" \tVida: "+a.get(i).getNivelVida());
        }
    }
    public static HashMap<Integer,Soldado> OrdenarVidaInsercion(HashMap<Integer,Soldado> a){
        int auxiliar,y;
        Soldado aux;
        for(int x=1;x<a.size();x++){
            aux=a.get(x);
            auxiliar=a.get(x).getNivelVida();
            y=x-1;
            while(y>-1 && a.get(y).getNivelVida()>auxiliar){
                a.put(y+1, a.get(y));
                y=y-1;
            }
            a.put(y+1, aux);
        }
        return a;
    }
    //Definiremos al ganador all ejercito que tenga mayor acumulacion de vida.
    public static void Batalla(HashMap<Integer,Soldado> a,HashMap<Integer,Soldado> b){
        if(sumaVida(a)>sumaVida(b)) System.out.println("Victoria del Ejercito 1");
        else if(sumaVida(a)<sumaVida(b)) System.out.println("Victoria del Ejercito 2");
        else System.out.println("Empate - sin ganador");
    }   
}
