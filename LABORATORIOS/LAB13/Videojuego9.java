package LAB13;
import java.util.ArrayList;
import java.util.Scanner;


public class Videojuego9 {
	
	public static void main(String[] args) {
		ArrayList<Soldado> Ejercito1=CrearEjercito();
		ArrayList<Soldado> Ejercito2=CrearEjercito(Ejercito1);
		System.out.println("\n");
		Tablero(Ejercito1, Ejercito2);
		
		MostrarEjercitos(Ejercito1, Ejercito2);
		
		MostrarDatos(Ejercito1, Ejercito2);
		
		
		Menu(Ejercito1, Ejercito2);
		
		
		
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
		System.out.println("\n\t\tOrdenar por Vida insercion \n");
		MostrarEjercitos(OrdenarVidaInsercion(a),OrdenarVidaInsercion(b));
	}
	public static int encontrar(ArrayList<Soldado> a){
		int auxiliar;
		Scanner sc =new Scanner (System.in);
		while(true){
			auxiliar=-1;
			System.out.println("\nIngrese la posicion del soldado a mover (ejm\"c 4\")");
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
	public static void mover(int x,ArrayList<Soldado> Ejercito){
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
				Ejercito.get(x).setFila(fila);
				Ejercito.get(x).setColumna(columna);
				contador=0;
				
				for(int i=0;i<Ejercito.size();i++){
					if(i!=x){
						if(CasilleroOcupado(Ejercito.get(i),Ejercito.get(x)))
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
		int SumaVidaTotal=a.getVidaActual()+b.getVidaActual();
		double ProbSola=(double)a.getVidaActual()*100/(double) SumaVidaTotal,ProbSolb=(double)b.getVidaActual()*100/(double) SumaVidaTotal;
		System.out.println("\t\t"+a.getNombre()+"\t"+b.getNombre()+"\n"+
		"Vida\t\t"+a.getVidaActual()+"\t"+ b.getVidaActual()+"\n"+
		"Prob de Vict\t"+ProbSola+"%\t"+ ProbSolb+"%");
		double probaleatoria=Math.random()*100+1;
		
		int opcion;
		if(probaleatoria<ProbSola){
			System.out.println("Ganador: "+a.getNombre());
			a.setVidaActual(a.getVidaActual()+1);
			opcion=1;
		}
		else if(probaleatoria<100){
			System.out.println("Ganador: "+b.getNombre());
			b.setVidaActual(b.getVidaActual()+1);
			opcion=2;
		}
		else {
			System.out.println("Empate ambos mueren");
			opcion=3;
		}
		return opcion;
	}
	//MenuPrincipal
	public static void Menu(ArrayList<Soldado> Ejercito1,ArrayList<Soldado> Ejercito2){
		Scanner sc=new Scanner(System.in);
		int menu;
		System.out.println("\n\nMenu principal:");
		System.out.println("1. Gestionar Ejercito 1\t2. Gestionar Ejercito 2");
		menu=sc.nextInt();
		if(menu==1 || menu==2){
			Gestion(menu,Ejercito1,Ejercito2);
		}
		else {
			Menu(Ejercito1,Ejercito2);    
			System.out.println("Opcion invalida, ingrese nuevamente");
		}
	}
	
	//Gestion de Ejercito
	public static void Gestion(int menu,ArrayList<Soldado> Ejercito1,ArrayList<Soldado> Ejercito2){
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
		+ "10. Jugar\n"
		+ "11. Volver menu Principal");
		opcionGestion=sc.nextInt();
		switch(opcionGestion){
			case 1:
			if(menu==1)
			CrearSoldado(Ejercito1,menu);
			else CrearSoldado(Ejercito2,menu);
			Menu(Ejercito1,Ejercito2);
			break;
			case 2:
			if(menu==1)EliminarSoldado(Ejercito1);
			else EliminarSoldado(Ejercito2);
			Menu(Ejercito1,Ejercito2);
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
			if(menu==1)
			VerSoldado(Ejercito1);
			else VerSoldado(Ejercito2);
			break;
			case 8:
			if(menu==1)
			VerEjercito(Ejercito1);
			else VerEjercito(Ejercito2);
			Menu(Ejercito1,Ejercito2);
			break;
			case 9:
			if(menu==1)SumarNivel(Ejercito1);
			else SumarNivel(Ejercito2);
			Menu(Ejercito1,Ejercito2);
			break;
			case 10:
			jugar(Ejercito1,Ejercito2);
			break;
			case 11:
			Menu(Ejercito1,Ejercito2);
			break;
			default:
			System.out.println("\nOpcion invalida\n");
			Menu(Ejercito1,Ejercito2);
			break;
		}
	}
	//1
	public static ArrayList<Soldado> CrearSoldado(ArrayList<Soldado> Ejercito,int menu){
		Scanner sc=new Scanner(System.in);
		if(Ejercito.size()<=10){
			
			int ataque,vida,defensa,velocidad,fila,columna;
			
			System.out.println("Ingrese datos del Soldado"+Ejercito.size()+"x"+menu);
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
				System.out.println("Soldado anadido correctamente");
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
	//10
	public static void jugar(ArrayList<Soldado> Ejercito1,ArrayList<Soldado> Ejercito2){
		while(!Ejercito1.isEmpty() && !Ejercito2.isEmpty()){
			int indiceAliado;
			int Opcion;
			int indiceEnemigo;
			System.out.println("\nTurno Ejercito 1");
			indiceAliado=encontrar(Ejercito1);
			mover(indiceAliado,Ejercito1);
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
				mover(indiceAliado,Ejercito2);
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
	//11
	
	
}
