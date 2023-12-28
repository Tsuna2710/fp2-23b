package LAB16;

import java.util.ArrayList;
import java.util.Scanner;

public class Videojuego12 {
    
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        System.out.println("VIDEOJUEGO");
        System.out.println("SELECCIONE MODALIDAD DE PARTIDA");
        System.out.println("1. PARTIDA NORMAL");
        System.out.println("2. PARTIDA RAPIDA");
        System.out.println("3. SALIR");
        int opcion=sc.nextInt();
        if(opcion==2){
            ArrayList<Ejercito> Reino1=CrearReino(); 
            ArrayList<Ejercito> Reino2=CrearReino(Reino1);
            TableroReino(Reino1,Reino2);
            MostrarReinos(Reino1,Reino2);
            //Gestionar ejercito
            while(!Reino1.isEmpty() && !Reino2.isEmpty()){
                int indiceAliado;
                int Opcion;
                int indiceEnemigo;
                System.out.println("Turno Ejercito 1");
                indiceAliado=encontrar(Reino1);
                mover(indiceAliado,Reino1);
                indiceEnemigo=encontrarEnemigo(Reino1.get(indiceAliado),Reino2);
                if(indiceEnemigo!=-1){
                    System.out.println("Batalla");
                    Opcion=batalla(Reino1.get(indiceAliado),Reino2.get(indiceEnemigo));

                    switch(Opcion){
                        case 1:
                                Reino2.remove(indiceEnemigo);
                                break;
                            case 2:
                                Reino1.remove(indiceAliado);
                                break;
                            case 3:
                                Reino2.remove(indiceEnemigo);
                                Reino1.remove(indiceAliado);
                                break;
                        
                    }
                }
                TableroReino(Reino1, Reino2);
                MostrarReinos(Reino1, Reino2);
                if(!Reino2.isEmpty()){
                    System.out.println("\n Turno Reino 2");
                    indiceAliado=encontrar(Reino2);
                    mover(indiceAliado,Reino2);
                    indiceEnemigo=encontrarEnemigo(Reino2.get(indiceAliado),Reino1);
                    if(indiceEnemigo!=-1){
                        System.out.println("Batalla");
                        Opcion=batalla(Reino2.get(indiceAliado),Reino1.get(indiceEnemigo));
                        switch(Opcion){
                            case 1:
                                Reino1.remove(indiceEnemigo);
                                break;
                            case 2:
                                Reino2.remove(indiceAliado);
                                break;
                            case 3:
                                Reino1.remove(indiceEnemigo);
                                Reino2.remove(indiceAliado);
                                break;
                        }
                    }
                    TableroReino(Reino1, Reino2);
                    MostrarReinos(Reino1, Reino2);
                }

            }
            if(!Reino1.isEmpty()) System.out.println("\nGanador Ejercito 1\n");
            if(!Reino2.isEmpty()) System.out.println("\nGanador Ejercito 2\n");
            if(!Reino1.isEmpty() && !Reino2.isEmpty()) System.out.println("\nEmpate\n");
        }
        else if(opcion==2){
            
        }
        else System.out.println("juego finalizado");
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
    public static int encontrar(ArrayList<Ejercito> a){
        int auxiliar;
        Scanner sc =new Scanner (System.in);
        while(true){
            auxiliar=-1;
            System.out.println("\nIngrese la posicion del Ejercito a mover (ejm\"c 4\")");
            String Columna=sc.next();
            int fila=sc.nextInt();
            String Texto="abcdefghijklmnop";
            int columna=Texto.indexOf(Columna)+1;
            
            for(int i=0;i<a.size();i++){
                
                if(fila==a.get(i).getFila() && columna==a.get(i).getColumna()) auxiliar=i;    
            }
            
            if(auxiliar==-1) {
                System.out.println("Soldado no encontrado, ingrese de nuevo");
            } 
            else break;
        }
        return auxiliar;
    }
    public static void mover(int x,ArrayList<Ejercito> Reino){
        int contador;
        Scanner sc =new Scanner (System.in);
        while (true){
            System.out.println("\nIngrese nueva ubicacion (ejm\"c 4\")");
            String Columna=sc.next();
            int fila=sc.nextInt();
            String Texto="abcdefghijklmnop";
            int columna=Texto.indexOf(Columna)+1;
            
            if(fila>10 || columna>10) {
                System.out.println("Dato invalido- ingrese nuevamente");
            }
            else { 
                Reino.get(x).setFila(fila);
                Reino.get(x).setColumna(columna);
                contador=0;
                
                for(int i=0;i<Reino.size();i++){
                    if(i!=x){
                        if(CasilleroOcupado(Reino.get(i),Reino.get(x)))
                            contador++;
                    }
                }
                
                if(contador==0){
                    break;
                }
                else{
                    System.out.println("Casillero Ocupado - Ingrese nuevamente");
                }
                
            }
        }
    }
    public static int encontrarEnemigo(Ejercito a,ArrayList<Ejercito> b){
        int auxiliar=-1;
        for(int i=0;i<b.size();i++){
                
                if(a.getFila()==b.get(i).getFila() && a.getColumna()==b.get(i).getColumna()) 
                    auxiliar=i;
        }
        return auxiliar;
    }
    public static int batalla(Ejercito a,Ejercito b){
        Scanner sc =new Scanner (System.in);
        ArrayList<Soldado> Ejercito1=CrearEjercito();
        ArrayList<Soldado> Ejercito2=CrearEjercito(Ejercito1);
        a.setMiembros(Ejercito1);
        b.setMiembros(Ejercito2);
        TableroSoldados(a.getMiembros(),b.getMiembros());
        MostrarSoldados(a,b);
        int metodo;
        System.out.println(a.getNombre()+"Vs"+b.getNombre());
        System.out.println("Seleccione metodo de batalla\n"
                + "(1) Alatoria \t (2) Manual");
        metodo=sc.nextInt();
        int opcion=0;
        
            int SumaVidaTotal=a.getMiembros().size()+b.getMiembros().size();
            double ProbSola=(double)a.getMiembros().size()*100/(double) SumaVidaTotal,ProbSolb=(double)b.getMiembros().size()*100/(double) SumaVidaTotal;
            System.out.println("\t\t"+a.getNombre()+"\t"+b.getNombre()+"\n"+
                "Vida\t\t"+a.getMiembros().size()+"\t"+ b.getMiembros().size()+"\n"+
                "Prob de Vict\t"+ProbSola+"%\t"+ ProbSolb+"%");
            double probaleatoria=Math.random()*100+1;
            
            if(probaleatoria<ProbSola){
                System.out.println("Ganador: "+a.getNombre());
                opcion=1;
            }
            else if(probaleatoria<100){
                System.out.println("Ganador: "+b.getNombre());
                opcion=2;
            }
            else {
                System.out.println("Empate ambos mueren");
                opcion=3;
            }
            return opcion;
        
        
    }
    public static ArrayList<Soldado> CrearEjercito(){
        
        int n=(int)(Math.random()*10+1);
        
        String Nombre;
        Soldado aux;
        ArrayList<Soldado> Ejercito=new ArrayList<>();
        
        for(int i =0;i<n;i++){
                Nombre="Soldado"+(i)+"x"+1;
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
    public static ArrayList<Soldado> CrearEjercito(ArrayList<Soldado> Ejercito1){
        
        int n=(int)(Math.random()*10+1);
        
        String Nombre;
        Soldado aux;
        ArrayList<Soldado> Ejercito=new ArrayList<>();
        for(int i =0;i<n;i++){
            
                
                Nombre="Soldado"+(i)+"x"+2;

                aux=new Soldado(Nombre);
                Ejercito.add(aux);
                
                for(int j=0;j<i;j++){
                    
                    if(CasilleroOcupado(Ejercito.get(i),Ejercito.get(j))){
                        Ejercito.remove(i);
                        i--;
                        break;
                    }
                }
                for(int j=0;j<Ejercito1.size();j++){
                    if(CasilleroOcupado(Ejercito.get(i),Ejercito1.get(j))){
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
    public static void TableroSoldados(ArrayList<Soldado> MiEjercito ,ArrayList<Soldado> TuEjercito){
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
                for (int m=0;m<TuEjercito.size();m++) {
                    if (TuEjercito.get(m).getFila() == x+1 && TuEjercito.get(m).getColumna() == b+1) {
                        System.out.print(" $ ");
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
    public static void MostrarSoldados(Ejercito Ejercito1,Ejercito Ejercito2){
        int mayor;
        if(Ejercito1.getMiembros().size()>Ejercito2.getMiembros().size()) mayor=Ejercito1.getMiembros().size();
        else mayor=Ejercito2.getMiembros().size();
        System.out.println("\n"+Ejercito1.getNombre()+"-@- \t\t\t"+Ejercito2.getNombre()+"-$-");
        for(int i=0;i<mayor;i++){
            
            if(i<Ejercito1.getMiembros().size()){
                System.out.print(Ejercito1.getMiembros().get(i).toString()+"\t\t");
            }
            else System.out.print("\t\t\t\t");
            if(i<Ejercito2.getMiembros().size()){
                System.out.print(Ejercito2.getMiembros().get(i).toString());
            }
            System.out.print("\n");
        }
        
    }
    public static void parttidaRapida(){
        Ejercito Ejercito1,Ejercito2;
        do{
        Ejercito1=new Ejercito("",Ejercito.OpcionPais());
        Ejercito2=new Ejercito("",Ejercito.OpcionPais());
        }while(Ejercito1.getPais().equals(Ejercito2.getPais()));
        Ejercito1.setMiembros(CrearEjercito());
        Ejercito2.setMiembros(CrearEjercito(Ejercito1.getMiembros()));
        TableroSoldados(Ejercito1.getMiembros(),Ejercito2.getMiembros());
        MostrarSoldados(Ejercito1,Ejercito2);
    }
}
