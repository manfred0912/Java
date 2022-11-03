package gestionpagosempresa_22a;

public class EmpleadoConfianza extends Empleado {
    // Campos
    private double sueldo;
    private double bono;

//    public EmpleadoConfianza() {
//        super();
//    }
    
    // Constructor
    public EmpleadoConfianza(String codEmpleado, String nomEmpleado, String apPatEmpleado, 
            String apMatEmpleado,double sueldo, double bono) {
        super(codEmpleado, nomEmpleado, apPatEmpleado, apMatEmpleado);
        this.sueldo = sueldo;
        this.bono = bono;
    }
    
    // Métodos de acceso

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }
    
    
    // Sobrescritura del método de la interfaz
    @Override
    public double calcularPago() {
        return sueldo + bono;
    }
    
    // Sobrescritura del método toString

    @Override
    public String toString() {
        return super.toString() + 
                "Sueldo: " + String.format("$%,.2f\n", sueldo) + 
                "Bono: " + String.format("$%,.2f\n", bono);
    }
    
    
}
