package LAB07;

public class Soldado {
    private final String nombre;
    private final int fila,columna;
    private final int vida;

    public Soldado(String nombre) {
		this.nombre = nombre;
		this.fila = (int)(Math.random()*10+1);
		this.columna = (int)(Math.random()*10+1);
		this.vida = (int)(Math.random()*5+1);
	}

    public String getNombre() {
        return nombre;
    }
    public int getNivelVida() {
		return vida;
	}
    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
    

    public int getVida() {
        return vida;
    }

    @Override
    public String toString() {
        return "Soldado{" + "nombre=" + nombre + ", fila=" + fila + ", columna=" + getColumnaLetra(columna) + ", vida=" + vida + '}';
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
