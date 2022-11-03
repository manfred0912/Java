package gutierrez_padilla_luis_pablo_t06;

public class Estado extends InfoGeneral {
    private int numDeMunicipios;
    private String Capital;

    public Estado() {
        //super();
    }

    public Estado(String nombre, String Capital, int numDeMunicipios) {
        super(nombre);
        this.numDeMunicipios = numDeMunicipios;
        this.Capital = Capital;
    }
    
    public Estado(String nombre) {
        super(nombre);
    }  

    public int getNumDeMunicipios() {
        return numDeMunicipios;
    }

    public void setNumDeMunicipios(int numDeMunicipios) {
        this.numDeMunicipios = numDeMunicipios;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String Capital) {
        this.Capital = Capital;
    }
    
    @Override
    public String himno() {
        return "himnoEstado.mp3";
    }
    

public String desplegarDatos() {
        return String.format("El estado se llama %s, su capital es %s y tiene %d municipios", this.getNombre(), this.getCapital(), this.getNumDeMunicipios());
    }
}
