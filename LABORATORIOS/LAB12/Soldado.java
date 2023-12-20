package LAB12;
public class Soldado {
	String Nombre;
	String Actitud;
	int nivelAtaque;
	int nivelVida;
	int nivelDefensa;
	int vidaActual;
	int velocidad;
	int fila;
	int columna;
	boolean vive;   
	
	public Soldado(String Nombre) {
		this.Nombre = Nombre;
		this.nivelAtaque=(int)(Math.random()*5+1);
		this.nivelVida = (int)(Math.random()*5+1);
		this.nivelDefensa = (int)(Math.random()*5+1);
		this.fila = (int)(Math.random()*10+1);
		this.columna = (int)(Math.random()*10+1);
		this.vive=true;
		this.vidaActual=nivelVida;
	}
	
	public Soldado( int nivelAtaque, int nivelVida, int nivelDefensa, int velocidad, int fila, int columna) {
		
		this.nivelAtaque = nivelAtaque;
		this.nivelVida = nivelVida;
		this.nivelDefensa = nivelDefensa;
		this.velocidad = velocidad;
		this.fila = fila;
		this.columna = columna;
		this.vidaActual=nivelVida;
		this.vive= true;
	}
	
	public Soldado(int nivelAtaque, int nivelVida, int nivelDefensa, int velocidad) {
		this.nivelAtaque = nivelAtaque;
		this.nivelVida = nivelVida;
		this.nivelDefensa = nivelDefensa;
		this.velocidad = velocidad;
	}
	
	public boolean isVive() {
		return vive;
	}
	
	
	@Override
	public String toString() {
		return Nombre+", "+vidaActual+" >> "+getColumnaLetra(columna)+fila;
	}
	public String MostarAtributos(){
		return "\nDatos:"
		+ "\nNombre: " + Nombre + "\n"
		+ "Actitud: " + Actitud + "\n"
		+ "NivelAtaque: " + nivelAtaque + "\n"
		+ "NivelVida: " + nivelVida + "\n"
		+ "NivelDefensa: " + nivelDefensa + "\n"
		+ "VidaActual: " + vidaActual + "\n"
		+ "velocidad: " + velocidad + "\n"
		+ "Posicion: " + getColumnaLetra(columna)+fila + "\n"
		+ "Vive: " + vive;
	}
	
	public int getFila() {
		return fila;
	}
	
	public int getColumna() {
		return columna;
	}
	
	public int getNivelVida() {
		return nivelVida;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public int getNivelAtaque() {
		return nivelAtaque;
	}
	
	public int getNivelDefensa() {
		return nivelDefensa;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	
	public void setFila(int fila) {
		this.fila = fila;
	}
	
	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	public void setNivelVida(int nivelVida) {
		this.nivelVida = nivelVida;
	}
	
	
	
	public void atacar(){
		//avanza
		Actitud="ofensiva";
		velocidad++;
	}
	public void defender(){
		//para
		Actitud="defensiva";
		velocidad=velocidad+2;
	}
	public void retroceder(){
		Actitud="defensiva";
		if(velocidad>0) defender();
		else if(velocidad==0) {
			//para 
			velocidad--;
		}
	}
	public void serAtacado(){
		vidaActual--;
		if(vidaActual<=0) vive=morir();
	}
	
	public void huir(){
		Actitud="fuga";
	}
	public boolean morir(){
		return false;
	}
	
	public int getVidaActual() {
		return vidaActual;
	}
	
	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}
	
	public char getColumnaLetra(int columna) {
		String columnas="abcdefghij";
		return columnas.charAt(columna-1);   
	}
	public Soldado suma(Soldado s){
		nivelVida=nivelVida+s.getNivelVida();
		nivelAtaque=nivelAtaque+s.getNivelAtaque();
		nivelDefensa=nivelDefensa+s.getNivelDefensa();
		velocidad=velocidad+s.getVelocidad();
		Soldado S=new Soldado(nivelAtaque,nivelVida,nivelDefensa,velocidad);
		return S;
	}
}
