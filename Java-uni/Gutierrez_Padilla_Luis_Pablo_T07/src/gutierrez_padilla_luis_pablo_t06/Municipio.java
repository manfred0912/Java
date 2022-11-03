package gutierrez_padilla_luis_pablo_t06;

public class Municipio extends InfoGeneral {
    private String alcalde;
    private int numDeDistritos;

    public Municipio() {
        //super();
    }

    public Municipio(String nombre, String alcalde, int numDeDistritos) {
        super(nombre);
        this.alcalde = alcalde;
        this.numDeDistritos = numDeDistritos;
    }
    
    public Municipio(String nombre) {
        super(nombre);
    }

    public String getAlcalde() {
        return alcalde;
    }

    public void setAlcalde(String alcalde) {
        this.alcalde = alcalde;
    }

    public int getNumDeDistritos() {
        return numDeDistritos;
    }

    public void setNumDeDistritos(int numDeDistritos) {
        this.numDeDistritos = numDeDistritos;
    }

    @Override
    public String himno() {
        return "himnoMunicipio.mp3";
    }
    
    public String desplegarDatos() {
        return String.format("El municipio se llama %s, su alcalde es %s y tiene %d distritos", this.getNombre(), alcalde, this.getNumDeDistritos());
    }
}
