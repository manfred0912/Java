package gestionfiguras_22a;

public class Triangulo extends Figura{
    // campos
    private double base;
    private double altura;
    
    // Cpnstructores

    public Triangulo() {
        this(1.0, 1.0);
    }
    
    public Triangulo(double base) {
        this(base, 1.0);
    }
    
//    public Triangulo (double altura){
//        this(1.0, altura);
//    }
    

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    
    
    // Metodos de acceso
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    
    // Implementaacion del metodo abstracto heredado de figura
    @Override
    public double calcularArea() {
        return(base * altura) / 2;
    }
    
    @Override 
    public String toString(){
        return super.toString() + String.format(", base %.4f y altura %.4f", 
                this.getBase(), this.getAltura());
    }
    
}
