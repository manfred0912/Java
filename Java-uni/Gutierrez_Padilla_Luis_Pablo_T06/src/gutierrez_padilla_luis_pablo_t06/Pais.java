package gutierrez_padilla_luis_pablo_t06;

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
    
    public String desplegarDatos() {
        return super.desplegarDatos() + String.format(", su capital es %s", this.getCapital());
    }
    
    @Override
    public String himno() {
        return "himnoPais.mp3";
    }
    
}
