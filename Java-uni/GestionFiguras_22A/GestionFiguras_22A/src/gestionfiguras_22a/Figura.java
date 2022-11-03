package gestionfiguras_22a;

public abstract class Figura /* extends Object */ {
    
    // Si no se escribe explícitamente un constructor, el compilador agrega
    // un constructor por omisión (sin parámetros) con una sola instrucción
    // invocando al constructor por omisión de la superclase.
    //
    //  public Figura() {
    //      super();
    //  }
    
    /**
     * Método abstracto para calcular y devolver el área de la figura.
     */
    public abstract double calcularArea();

    /**
     * Sobrescritura del método toString (heredado de Object).
     */
    @Override
    public String toString() {
        String tipo = "un " + this.getClass().getSimpleName();
        
        if(this instanceof Circulo){
            tipo = "un círculo";
        } else if(this instanceof TrianguloEquilatero){
            tipo = "un triángulo equilatero";
        } else if(this instanceof Triangulo){
            tipo = "un triángulo";
        }
        
        return String.format("La figura es %s de área %.4f", 
                tipo,
                this.calcularArea()
        );
    }
    
}
