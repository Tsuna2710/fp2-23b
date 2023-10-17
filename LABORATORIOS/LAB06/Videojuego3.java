package LAB06;

public class Videojuego3 {
    public static void main(String[] args) {
        Soldado[] Ejercito1=CrearEjercito(); 
        Soldado[] Ejercito2=CrearEjercito();
        Tablero(Ejercito1, Ejercito2);
        System.out.println("Ejercito 1 ( 0 )");
        for(int i=0;i<Ejercito1.length;i++){
            System.out.println(Ejercito1[i].toString());
        }
        System.out.println("===========================");
        System.out.println("Ejercito 1 - Mayor vida");
        System.out.println(mayorVida(Ejercito1).getNombre()+" \t Vida:"+
                mayorVida(Ejercito1).getVida());
        System.out.println("===========================");
        System.out.println("Ordenar por vida");
        OrdenarPorVida(Ejercito1);
        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("Ejercito 2 ( X )");
        for(int i=0;i<Ejercito2.length;i++){
            System.out.println(Ejercito2[i].toString());
        }
        System.out.println("===========================");
        System.out.println("Ejercito 2 - Mayor vida");
        System.out.println(mayorVida(Ejercito2).getNombre()+" \t Vida:"+
                mayorVida(Ejercito2).getVida());
        System.out.println("===========================");
        System.out.println("Ordenar por vida");
        OrdenarPorVida(Ejercito1);
        
    }
        
    public static Soldado[] CrearEjercito(){
        
        int n=(int)(Math.random()*10+1),Vida,Fila,Columna=0,contador;
        String Nombre;
        Soldado[] miEjercito=new Soldado[n];
        for(int i =0;i<miEjercito.length;i++){
            while(true){
                contador=0;
                Nombre="Soladodo"+(i+1);
                Vida=(int)(Math.random()*5+1);
                Fila=(int)(Math.random()*10+1);
                Columna=(int)(Math.random()*10+1);
                miEjercito[i]=new Soldado(Nombre,Fila,Columna,Vida);
                for(int j=0;j<i;j++){
                    if(Fila==miEjercito[j].getFila() && Columna==miEjercito[j].getColumna()){
                        contador++;
                    }
                }
                if(contador==0) {
                    break;
                    
                }
            }
            
            
        }
        return miEjercito;
    }
    public static void Tablero(Soldado[] MiEjercito,Soldado[] TuEjercito){
        int Auxiliar;
        for (int x=0;x<10;x++){
            for (int a=0;a<10;a++){
                System.out.print(" ___ \t");
            }
            System.out.println("");
            
            for (int b=0;b<10;b++){
                Auxiliar=0;
                System.out.print("|");
                for (int m=0;m<MiEjercito.length;m++) {
                    if (MiEjercito[m].getFila() == x+1 && MiEjercito[m].getColumna() == b+1) {
                        System.out.print(" 0 ");
                        Auxiliar=1;
                    }
                }
                for (int m=0;m<TuEjercito.length;m++) {
                    if (TuEjercito[m].getFila() == x+1 && TuEjercito[m].getColumna() == b+1) {
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
    public static Soldado mayorVida(Soldado[] a){
        int mayor=0;
        Soldado Mayor=null;
        for(int i=0;i<a.length;i++){
            if(a[i].getVida()>mayor){
                Mayor=a[i];
                mayor=a[i].getVida();
            }
                
        }
        return Mayor;
    }
    public static double promedioVida(Soldado[] a){
        int suma=0;
        for(int i=0;i<a.length;i++){
            suma=suma+a[i].getVida();
        }
        return (double)(suma)/(double)(a.length);
    }
    public static void OrdenarPorVida(Soldado[] a){
        Soldado aux;
        for(int x=0;x<a.length-1;x++){
            int menor=a[x].getVida(),pos=x;
            for(int i=x+1;i<a.length;i++){
               if(menor>a[i].getVida()) {
                    menor=a[i].getVida();
                    pos=i;
                }  
            }
            aux=a[pos];
            a[pos]=a[x];
            a[x]=aux;
        }
        for(int i=0;i<a.length;i++){
            System.out.println(a[i].getNombre()+" \tVida: "+a[i].getVida());
        }
    }
}
