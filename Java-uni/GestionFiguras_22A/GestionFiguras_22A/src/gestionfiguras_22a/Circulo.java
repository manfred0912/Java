package gestionfiguras_22a;

public class Circulo extends Figura {
    // Campos
    private double radio;

    // Constructores
    public Circulo() {
        this(1.0); // Valor arbitrario por omisión
    }

    public Circulo(double radio) {
        this.radio = radio;
    }

    // Métodos de acceso
    public double getRadio() {
        return radio;
    }

     public void setRadio(double radio) {
        this.radio = radio;
    }

    // Sobrescritura del método calcularArea
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
    
    //  Sobreescritura del metodo toString heredado de figura para agregar 
    // la informacion referente al radio del circulo
    
    @Override
    public String toString(){
        // super.metodo() es una lamada al metodo de la super clase
        return super.toString() + String.format(" y de radio %.4f", this.getRadio());
    }
    
}
