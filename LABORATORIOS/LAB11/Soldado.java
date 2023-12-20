
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
    }

    public boolean isVive() {
        return vive;
    }
    
    
    @Override
    public String toString() {
        return Nombre+", "+nivelVida+" >> "+getColumnaLetra(columna)+fila;
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
}

