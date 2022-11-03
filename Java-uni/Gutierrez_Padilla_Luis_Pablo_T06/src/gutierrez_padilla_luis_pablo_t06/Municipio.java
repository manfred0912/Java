package gutierrez_padilla_luis_pablo_t06;

public class Municipio extends InfoGeneral {
    private String alcalde;

    public Municipio() {
        //super();
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

    @Override
    public String himno() {
        return "himnoMunicipio.mp3";
    }
    
    public String desplegarDatos() {
        return String.format("El municipio se llama %s y su alcalde es %s", this.getNombre(), alcalde);
    }
}
