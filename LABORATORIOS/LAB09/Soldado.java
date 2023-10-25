package LAB09;

public class Soldado {
    String Nombre,Actitud;
    int nivelAtaque,nivelVida,nivelDefensa;
    int vidaActual,velocidad;
    boolean vive=true;
    int fila,columna;

    public Soldado(String Nombre, String Actitud, int nivelAtaque, int nivelVida, int nivelDefensa, int vidaActual, int velocidad, int fila, int columna) {
        this.Nombre = Nombre;
        this.Actitud = Actitud;
        this.nivelAtaque = nivelAtaque;
        this.nivelVida = nivelVida;
        this.nivelDefensa = nivelDefensa;
        this.vidaActual = vidaActual;
        this.velocidad = velocidad;
        this.fila = fila;
        this.columna = columna;
    }

    public Soldado(String Nombre, int nivelVida, int fila, int columna) {
        this.Nombre = Nombre;
        this.nivelVida = nivelVida;
        this.fila = fila;
        this.columna = columna;
    }

    public Soldado(String Nombre, int nivelAtaque, int nivelVida, int nivelDefensa, int fila, int columna) {
        this.Nombre = Nombre;
        this.nivelAtaque = nivelAtaque;
        this.nivelVida = nivelVida;
        this.nivelDefensa = nivelDefensa;
        this.fila = fila;
        this.columna = columna;
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
        if(vidaActual<=0) morir();
    }
    
    public void huir(){
        Actitud="fuga";
    }
    public void morir(){
        vive=false;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
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
    
    @Override
    public String toString() {
        return Nombre+", "+nivelVida+" >> "+getColumnaLetra(columna)+fila+"\n";
    }
    
    public String getColumnaLetra(int columna) {
            switch(columna){
                case 1:
                    return "a";
                case 2:
                    return "b";
                case 3:
                    return "c";
                case 4:
                    return "d";
                case 5:
                    return "f";
                case 6:
                    return "g";
                case 7:
                    return "h";
                case 8:
                    return "i";
                case 9:
                    return "j";
                case 10:
                    return "k";
            }
        return "inv";
    }
}
