package gestionmascotas_22a;

public class Perico extends Mascota {

    public Perico() {
    }

    public Perico(String nombre) {
        super(nombre);
    }
    

    @Override
    public String emitirSonido() {
        return "Galletita, galletita";
    }
    
}
