package Valencia_Saldana_Uriel_Israel_T06;

public abstract class AvionBoletos {
    
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private int edad;
    private int numAsiento;
    
    //Creamos los constructores
    public AvionBoletos(){
        nombre = "";
        apellidoP = "";
        apellidoM = "";
        edad = 0;
        numAsiento = 0;
    }

    public AvionBoletos(String nombre, String apellidoP, String apellidoM, int edad, int numAsiento) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.edad = edad;
        this.numAsiento = numAsiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getnumAsiento() {
        return numAsiento;
    }

    public void setAsiento(int numAsiento) {
        this.numAsiento = numAsiento;
    }
    
    public abstract String clienteClase();
    public abstract String comidaClase();
    
    @Override
    public String toString(){
        String s;
        //Construir cadena de String
        s = String.format("El nombre del cliente es: %s, su apellido paterno es: %s y /n"
                + "el apellido Materno es: %s, tiene la edad de %s, su asiento es: %s, "
                + "la clase es: %s y su lonche es: %s \n", this.nombre,this.apellidoP,this.apellidoM,
                this.edad,this.numAsiento,this.clienteClase(),this.comidaClase()
        );
        return s;
    }
}
