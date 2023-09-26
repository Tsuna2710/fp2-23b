package LAB05;

public class videoJuego2 {
	public static void main(String[] args) {
		//Genrando los n soldados aleatorios
		Soldado[] miEjercito=CrearEjercito(); 		
		Tablero(miEjercito);
		System.out.println("Mi ejercito");
		mostrarEjercito(miEjercito);
		System.out.println(mayorVida(miEjercito).getNombre()+" \t Vida:"+ mayorVida(miEjercito).getVida());
		System.out.println("Promedio de vida (miEjercito):\t"+promedioVida(miEjercito));
		System.out.println("Nivel de vida del ejercito (miEjercito):\t"+nivelDeVidaEjercito(miEjercito));
		System.out.println("Ordenar por vida");
		OrdenarPorVida(miEjercito);

		
	}
	
	public static Soldado[] CrearEjercito(){
		
		int n=(int)(Math.random()*10+1),Vida,Fila,Columna=0;
		String Nombre;
		Soldado[] miEjercito=new Soldado[n];
		for(int i =0;i<miEjercito.length;i++){
			Nombre="Soldado"+i;
			Vida=(int)(Math.random()*5+1);
			Fila=(int)(Math.random()*10+1);
			Columna=(int)(Math.random()*10+1);
			miEjercito[i]=new Soldado(Nombre,Fila,Columna,Vida);
			
		}
		return miEjercito;
	}
	public static void Tablero(Soldado[] MiEjercito){
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
						System.out.print(MiEjercito[m].getFila()+" "+MiEjercito[m].getColumnaLetra(b+1));
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
	public static void mostrarEjercito(Soldado[] a){
		for(int i=0;i<a.length;i++){
            System.out.println(a[i].toString());
        }
	}
    public static double promedioVida(Soldado[] a){
        int suma=0;
        for(int i=0;i<a.length;i++){
            suma=suma+a[i].getVida();
        }
        return (double)(suma)/(double)(a.length);
    }
	public static double nivelDeVidaEjercito(Soldado[] a){
		int suma=0;
		for(int i=0;i<a.length;i++){
            suma=suma+a[i].getVida();
        }
		return suma;
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
