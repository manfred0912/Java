package gestionmascotas_22a;

public class Perro extends Mascota {
    public Perro() {
    }

    // Constructores
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public String emitirSonido() {
        return "Guau";
    }
    
}
