package gutierrez_padilla_luis_pablo_t06;

public abstract class InfoGeneral {
    // Campos
    private String nombre;
    
    // Constructores

    public InfoGeneral() {
        this("Sin nombre");
    }

    public InfoGeneral (String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Metodo que simula el himno de cada estado
    public abstract String himno();
    
    public String desplegarDatos() {
        return String.format("El pais se llama %s", this.getNombre());
    }
    

}


