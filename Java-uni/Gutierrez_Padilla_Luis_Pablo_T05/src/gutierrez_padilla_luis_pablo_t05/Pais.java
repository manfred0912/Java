package gutierrez_padilla_luis_pablo_t05;

public class Pais extends InfoGeneral {
    private String capital;

    public Pais() {
        //super();
    }

    public Pais(String nombre) {
        super(nombre);
    }
    
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
    
    @Override
    public String toString() {
        return String.format("El pais se llama %s, su capital es %s", this.getNombre(), this.getCapital());
    }
    
    @Override
    public String himno() {
        return "himnoPais.mp3";
    }
    
}
