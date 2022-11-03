package gutierrez_padilla_luis_pablo_t06;

public class Pais extends InfoGeneral {
    private String capital;
    private int numDeEstados;

    public Pais() {
        //super();
    }

    public Pais(String nombre, String capital, int numDeEstados) {
        super(nombre);
        this.capital = capital;
        this.numDeEstados = numDeEstados;
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

    public int getNumDeEstados() {
        return numDeEstados;
    }

    public void setNumDeEstados(int numDeEstados) {
        this.numDeEstados = numDeEstados;
    }
    
    public String desplegarDatos() {
        return super.desplegarDatos() + String.format(", su capital es %s y tiene %d estados", this.getCapital(), this.getNumDeEstados());
    }
    
    @Override
    public String himno() {
        return "himnoPais.mp3";
    }
    
}
