package gutierrez_padilla_luis_pablo_t05;

public class Estado extends Pais {

    public Estado() {
        //super();
    }

    public Estado(String nombre) {
        super(nombre);
    }  
    
    @Override
    public String himno() {
        return "himnoEstado.mp3";
    }
    
    @Override
    public String toString() {
        return String.format("El estado se llama %s, su capital es %s", this.getNombre(), this.getCapital());
    }
    
}
