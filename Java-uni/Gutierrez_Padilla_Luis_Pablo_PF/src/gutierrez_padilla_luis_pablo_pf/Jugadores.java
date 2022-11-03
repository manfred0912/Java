package gutierrez_padilla_luis_pablo_pf;

import java.util.ArrayList;

public class Jugadores{
    int puntaje;
    String nombre;
    
    public Jugadores(){
        puntaje = 0;
        nombre = " ";
    }
    
    public Jugadores(int puntos, String jugador){
        puntaje = puntos;
        nombre = jugador;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Jugador: " + nombre + ", Puntaje: " + puntaje;
    }
    
    
    
}

    
    

