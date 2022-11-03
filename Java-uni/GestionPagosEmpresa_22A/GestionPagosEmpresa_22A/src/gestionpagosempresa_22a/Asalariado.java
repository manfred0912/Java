package gestionpagosempresa_22a;

public class Asalariado extends Empleado {
    // Campos
    private double salario;
    private int horasExtra; // Número de horas extra trabajadas
    private double pagoPorHoraExtra;
    
    // Constructor

    public Asalariado(String codEmpleado, String nomEmpleado, String apPatEmpleado, 
            String apMatEmpleado, double salario, int horasExtra, double pagoPorHoraExtra) {
        super(codEmpleado, nomEmpleado, apPatEmpleado, apMatEmpleado);
        this.salario = salario;
        this.horasExtra = horasExtra;
        this.pagoPorHoraExtra = pagoPorHoraExtra;
    }
    
    // Métodos de acceso

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public double getPagoPorHoraExtra() {
        return pagoPorHoraExtra;
    }

    public void setPagoPorHoraExtra(double pagoPorHoraExtra) {
        this.pagoPorHoraExtra = pagoPorHoraExtra;
    }
    

    @Override
    public double calcularPago() {
        return salario + (horasExtra * pagoPorHoraExtra);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Salario: " + String.format("$%,.2f\n", salario) + 
                "Horas extra: " + horasExtra + "\n" +
                "Pago por hora extra: " + String.format("$%,.2f\n", pagoPorHoraExtra);
    }
    
    
    
}
