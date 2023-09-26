package LAB03.EJER03;

public class Ejer03 {

    public static void main(String [] args){
        int n,m;
        n=(int)(Math.random()*5+1);
        m=(int)(Math.random()*5+1);
        Soldado [] Ejercito1= new Soldado[n];
        Soldado [] Ejercito2= new Soldado[m];
        crearEjercito(Ejercito2);
        crearEjercito(Ejercito1);
        System.out.println("Ejercito 1");
        mostrarEjercito(Ejercito1);
        System.out.println("Ejercito 2");
        mostrarEjercito(Ejercito2);
        if (n>m)
        System.out.println("\nGanador: Ejercito 1");
        else if (n<m) System.out.println("\nGanador: Ejercito 2");
        else System.out.println("\nEmpate");
    }
    public static void crearEjercito(Soldado [] Ejercito){
        for(int i=0;i<Ejercito.length;i++){
            Ejercito[i]= new Soldado("Soldado"+i);    
        }
    }
    public static void mostrarEjercito(Soldado [] Ejercito){
        for(int i=0;i<Ejercito.length;i++){
            System.out.println(Ejercito[i].toString());
        }

    }
}
