package LAB03.EJER02;

public class Soldado {
    String Nombre;
    int Vida;

    public Soldado (String Nombre, int Vida){
        this.Nombre=Nombre;
        this.Vida=Vida;
    }

    public String toString (){
        return "Nombre: "+Nombre+"\tVida: "+Vida;
    }
}
