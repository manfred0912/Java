package gestionpagosempresa_22a;

/**
 * Se declara abstracta la clase porque no es posible implementar el método
 * calcularPago() de la interfaz Pagable, ya que el cálculo depende del
 * tipo de empleado (implementado en las subclases).
 */

public abstract class Empleado implements Pagable {
    // Campos
    private String codEmpleado; // Código del empleado
    private String nomEmpleado; // Nombre del empleado
    private String apPatEmpleado; // Apellido paterno
    private String apMatEmpleado; // Apellido materno
    
    // Constructor
    public Empleado(String codEmpleado, String nomEmpleado, String apPatEmpleado, 
            String apMatEmpleado) {
        this.codEmpleado = codEmpleado;
        this.nomEmpleado = nomEmpleado;
        this.apPatEmpleado = apPatEmpleado;
        this.apMatEmpleado = apMatEmpleado;
    }
    
    // Métodos de acceso

    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getNomEmpleado() {
        return nomEmpleado;
    }

    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }

    public String getApPatEmpleado() {
        return apPatEmpleado;
    }

    public void setApPatEmpleado(String apPatEmpleado) {
        this.apPatEmpleado = apPatEmpleado;
    }

    public String getApMatEmpleado() {
        return apMatEmpleado;
    }

    public void setApMatEmpleado(String apMatEmpleado) {
        this.apMatEmpleado = apMatEmpleado;
    }
    
    // Sobrescritura de toString
    @Override
    public String toString() {
        return "Código del empleado: " + codEmpleado + 
                "\nNombre(s): " + nomEmpleado + 
                "\nApellido paterno: " + apPatEmpleado + 
                "\nApellido materno: " + apMatEmpleado + "\n";
    }
    
    
}
