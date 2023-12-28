package LAB06;

import java.util.ArrayList;


public class Videojuego3 {
    public static void main(String[] args) {
		
		ArrayList<Soldado> Ejercito1=CrearEjercito();
		ArrayList<Soldado> Ejercito2=CrearEjercito(Ejercito1);
		System.out.println("\n");
		
		
		Tablero(Ejercito1, Ejercito2);
		
		MostrarEjercitos(Ejercito1, Ejercito2);
		
		MostrarDatos(Ejercito1, Ejercito2);		
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
		System.out.println("\nEjercito 1 -0- \t\t\t\t\t\t\tEjercito 2 -X-");
		for(int i=0;i<mayor;i++){
			
			if(i<Ejercito1.size()){
				System.out.print(Ejercito1.get(i).toString()+"\t\t");
			}
			else System.out.print("\t\t\t\t\t\t\t\t");
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
		System.out.println("\nEjercito 1 -0- \t\t\t\t\ttEjercito 2 -X-");
		MostrarEjercitos(a,b);
		System.out.println("\n\t\t\tPromedio\n");
		System.out.println("\nEjercito 1 -0- \t\t\ttEjercito 2 -X-");
		System.out.println("Prom vida:"+promedioVida(a)+"\t\t"+"Prom vida:"+promedioVida(b));
		System.out.println("\n\t\tOrdenar por Vida inspeccion \n");
		MostrarEjercitos(OrdenarPorVida(a),OrdenarPorVida(b));
		System.out.println("\n\t\tOrdenar por Vida insercion \n");
		MostrarEjercitos(OrdenarVidaInsercion(a),OrdenarVidaInsercion(b));
	}
	    
}
