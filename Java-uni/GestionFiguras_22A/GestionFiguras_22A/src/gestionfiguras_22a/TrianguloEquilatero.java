package gestionfiguras_22a;

public class TrianguloEquilatero extends Triangulo{
    
    private final static double SQRT3DIV2 = Math.sqrt(3.0)/2;
    
    

    public TrianguloEquilatero() {
        this(1.0, 1.0); // La altura es ignorada en el tercer constructor
    }

    public TrianguloEquilatero(double base) {
        this(base, 1.0); // La altura es ignorada en el tercer constructor
    }

    // La altur pasada comoargumento es ignorada y la altura se calcula 
    // en terminos de la basa pera que el triangulo sea equilatero
    public TrianguloEquilatero(double base, double altura) {
        super(base, base * SQRT3DIV2);
    }
    
    
    // sobreescritura del metodo set base para calcular el valor de la altura 
    // en terminos de la base para que el triangulo siga siendo equilatero
    @Override
    public void setBase(double base){
        super.setBase(base);
        super.setAltura(base * SQRT3DIV2);
    }
    
    @Override
    public void setAltura(double altura){
        super.setAltura(altura);
        super.setBase(altura / SQRT3DIV2);
    }
    
    
}
