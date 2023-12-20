
import java.util.Scanner;
import java.util.ArrayList;
public class Videojuego7 {
    public static void main(String[] args) {
        
        ArrayList<Soldado> Ejercito1=CrearEjercito();
        ArrayList<Soldado> Ejercito2=CrearEjercito(Ejercito1);
        System.out.println("\n");
        

        Tablero(Ejercito1, Ejercito2);
        
        MostrarEjercitos(Ejercito1, Ejercito2);
        
        MostrarDatos(Ejercito1, Ejercito2);
        
        System.out.println("\n\n\t\tEmpieza el juego\n");
        while(!Ejercito1.isEmpty() && !Ejercito2.isEmpty()){
            int indiceAliado;
            int Opcion;
            int indiceEnemigo;
            System.out.println("Turno Ejercito 1");
            indiceAliado=encontrar(Ejercito1);
            mover(Ejercito1.get(indiceAliado));
            indiceEnemigo=encontrarEnemigo(Ejercito1.get(indiceAliado),Ejercito2);
            if(indiceEnemigo!=-1){
                System.out.println("Batalla");
                Opcion=batalla(Ejercito1.get(indiceAliado),Ejercito2.get(indiceEnemigo));
                
                switch(Opcion){
                    case 1:
                        Ejercito2.remove(indiceEnemigo);
                        break;
                    case 2:
                        Ejercito1.remove(indiceAliado);
                        break;
                    case 3:
                        Ejercito2.remove(indiceEnemigo);
                        Ejercito1.remove(indiceAliado);
                        break;
                }
            }
            Tablero(Ejercito1, Ejercito2);
            MostrarEjercitos(Ejercito1, Ejercito2);
            if(!Ejercito2.isEmpty()){
                System.out.println("\n Turno Ejercito 2");
                indiceAliado=encontrar(Ejercito2);
                mover(Ejercito2.get(indiceAliado));
                indiceEnemigo=encontrarEnemigo(Ejercito2.get(indiceAliado),Ejercito1);
                if(indiceEnemigo!=-1){
                    System.out.println("Batalla");
                    Opcion=batalla(Ejercito2.get(indiceAliado),Ejercito1.get(indiceEnemigo));
                    switch(Opcion){
                        case 1:
                            Ejercito1.remove(indiceEnemigo);
                            break;
                        case 2:
                            Ejercito2.remove(indiceAliado);
                            break;
                        case 3:
                            Ejercito1.remove(indiceEnemigo);
                            Ejercito2.remove(indiceAliado);
                            break;
                    }
                }
                Tablero(Ejercito1, Ejercito2);
                MostrarEjercitos(Ejercito1, Ejercito2);
            }
            
        }
        if(!Ejercito1.isEmpty()) System.out.println("\nGanador Ejercito 1\n");
        if(!Ejercito2.isEmpty()) System.out.println("\nGanador Ejercito 2\n");
        if(!Ejercito1.isEmpty() && !Ejercito2.isEmpty()) System.out.println("\nEmpate\n");
        
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
    public static void Tablero(ArrayList<Soldado> MiEjercito ,ArrayList<Soldado> TuEjercito){
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
            System.out.print("\t");
            for (int c=0;c<10;c++){
                System.out.print("|___|\t");
            }
            System.out.println("");
        }
        
    }
    public static void MostrarEjercitos(ArrayList<Soldado> Ejercito1,ArrayList<Soldado> Ejercito2){
        int mayor;
        if(Ejercito1.size()>Ejercito2.size()) mayor=Ejercito1.size();
        else mayor=Ejercito2.size();
        System.out.println("\nEjercito 1 -0- \t\t\tEjercito 2 -X-");
        for(int i=0;i<mayor;i++){
            
            if(i<Ejercito1.size()){
                System.out.print(Ejercito1.get(i).toString()+"\t\t");
            }
            else System.out.print("\t\t\t\t");
            if(i<Ejercito2.size()){
                System.out.print(Ejercito2.get(i).toString());
            }
            System.out.print("\n");
        }
        
    }
    public static Soldado mayorVida(ArrayList<Soldado> a){
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
    public static double promedioVida(ArrayList<Soldado> a){
        return (double)sumaVida(a)/(double)a.size();
    }
    public static int sumaVida(ArrayList<Soldado> a){
        int suma=0;
        for(int i=0;i<a.size();i++){
            suma=suma+a.get(i).getNivelVida();
        }
        return suma;
    }
    public static ArrayList<Soldado> OrdenarPorVida(ArrayList<Soldado> Ejercito){
        ArrayList<Soldado> a =Ejercito;
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
            
            a.set(pos, a.get(x));
            a.set(x, aux);
        }
        return a;
    }
    public static ArrayList<Soldado> OrdenarVidaInsercion(ArrayList<Soldado> Ejercito){
        ArrayList<Soldado>a=Ejercito;
        int auxiliar,y;
        Soldado aux;
        for(int x=1;x<a.size();x++){
            aux=a.get(x);
            auxiliar=a.get(x).getNivelVida();
            y=x-1;
            while(y>-1 && a.get(y).getNivelVida()>auxiliar){
                a.set(y+1, a.get(y));
                y=y-1;
            }
            a.set(y+1, aux);
        }
        return a;
    }
    public static void MostrarDatos(ArrayList<Soldado> a,ArrayList<Soldado> b){
        
        System.out.println("\n\t\t\tMayor VIda\n");
        System.out.println("\nEjercito 1 -0- \t\t\tEjercito 2 -X-");
        System.out.println(mayorVida(a).toString()+"\t\t"+mayorVida(b).toString());
        System.out.println("\n\t\t\tPromedio\n");
        System.out.println("\nEjercito 1 -0- \t\t\tEjercito 2 -X-");
        System.out.println("Prom vida:"+promedioVida(a)+"\t\t"+"Prom vida:"+promedioVida(b));
        System.out.println("\n\t\tOrdenar por Vida inspeccion \n");
        MostrarEjercitos(OrdenarPorVida(a),OrdenarPorVida(b));
        System.out.println("\n\t\tOrdenar por Vida inserción \n");
        MostrarEjercitos(OrdenarVidaInsercion(a),OrdenarVidaInsercion(b));
    }
    public static int encontrar(ArrayList<Soldado> a){
        int auxiliar;
        Scanner sc =new Scanner (System.in);
        while(true){
            auxiliar=-1;
            System.out.println("Ingrese la posicion del soldado a mover (ejm\"c 4\")");
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
    public static Soldado mover(Soldado a){
        Scanner sc =new Scanner (System.in);
        while (true){
            System.out.println("Ingrese nueva ubicacion (ejm\"c 4\")");
            String Columna=sc.next();
            int fila=sc.nextInt();
            String Texto="abcdefghijklmnop";
            int columna=Texto.indexOf(Columna)+1;
            if(fila>10 || columna>10) {
                System.out.println("Dato invalido- ingrese nuevamente");
            }
            else { 
                a.setFila(fila);
                a.setColumna(columna);
                break;
            }
        }
        return a;
    }
    public static int encontrarEnemigo(Soldado a,ArrayList<Soldado> b){
        int auxiliar=-1;
        for(int i=0;i<b.size();i++){
                
                if(a.getFila()==b.get(i).getFila() && a.getColumna()==b.get(i).getColumna()) 
                    auxiliar=i;
        }
        return auxiliar;
    }
    public static int batalla(Soldado a,Soldado b){
        System.out.println(a.getNombre()+"Vs"+b.getNombre());
        int SumaVidaTotal=a.getNivelVida()+b.getNivelVida();
        double ProbSola=(double)a.getNivelVida()*100/(double) SumaVidaTotal,ProbSolb=(double)b.getNivelVida()*100/(double) SumaVidaTotal;
        System.out.println("\t\t"+a.getNombre()+"\t"+b.getNombre()+"\n"+
                "Vida\t\t"+a.getNivelVida()+"\t"+ b.getNivelVida()+"\n"+
                "Prob de Vict\t"+ProbSola+"%\t"+ ProbSolb+"%");
        double probaleatoria=Math.random()*100+1;
        
        int opcion;
        if(probaleatoria<ProbSola){
            System.out.println("Ganador: "+a.getNombre());
            a.setNivelVida(a.getNivelVida()+1);
            opcion=1;
        }
        else if(probaleatoria<100){
            System.out.println("Ganador: "+b.getNombre());
            b.setNivelVida(b.getNivelVida()+1);
            opcion=2;
        }
        else {
            System.out.println("Empate ambos mueren");
            opcion=3;
        }
        return opcion;
    }
}
