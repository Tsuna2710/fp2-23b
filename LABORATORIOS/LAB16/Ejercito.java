package LAB16;

import java.util.ArrayList;

public class Ejercito {
    ArrayList<Soldado> Miembros;
    String Pais;
    String Nombre;
    int Fila;
    int Columna;

    public Ejercito(String Nombre,String Pais) {
        this.Nombre = Nombre;
        this.Pais = Pais;
        this.Fila=(int)(Math.random()*10+1);
        this.Columna=(int)(Math.random()*10+1);
    }

    public int getFila() {
        return Fila;
    }

    public int getColumna() {
        return Columna;
    }

    public String getNombre() {
        return Nombre;
    }
    

    public String getPais() {
        return Pais;
    }

    public ArrayList<Soldado> getMiembros() {
        return Miembros;
    }
    

    public void setFila(int Fila) {
        this.Fila = Fila;
    }

    public void setColumna(int Columna) {
        this.Columna = Columna;
    }

    public void setMiembros(ArrayList<Soldado> Miembros) {
        this.Miembros = Miembros;
    }
    

    @Override
    public String toString() {
        
        return Nombre+",  >> "+getColumnaLetra(Columna)+Fila;
    }
    
    public char getColumnaLetra(int columna) {
        String columnas="abcdefghij";
        return columnas.charAt(columna-1);   
    }
    
    
    
    
    
    public static String OpcionPais(){
        int n=(int)(Math.random()*6+1);
        switch(n){
            case 1:
                return "Inglaterra";
            case 2:
                return "Francia";
            case 3:
                return "Sacro imperio";
            case 4:
                return "Castilla";
            case 5:
                return "Aragon";
            default:
                return "Moros";
        }   
    }
}
