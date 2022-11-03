package gestionmascotas_22a;

/**
 * Si una clase contiene al menos un método abstracto, la clase también
 * debe declararse como abstracta.
 * Sin embargo, una clase abstracta puede no tener ningún método abstracto.
 * 
 * No es posible crear (instanciar) objetos de una clase abstracta.
 * 
 */

public abstract class Mascota /* extends Object */ {
    // Campos
    private String nombre;
    
    // Constructores
    public Mascota() {
        //this.nombre = "Sin nombre";
        this("Sin nombre"); // Llamada al constructor que recibe un String en esta misma clase
    }

    public Mascota(String nombre) {
        this.nombre = nombre;
    }
    
    // Métodos de acceso
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    /**
     * Método que simula la emisión de sonido de parte de la mascota.
     * En una implementación más realista, este método reproduciría un
     * archivo de audio con el sonido que emite la mascota. Por simplicidad,
     * en la actual implementación se regresará un objeto de tipo String
     * con la representación textual del sonido de la mascota.
     * 
     * Si no tenemos en la clase una implementación para un método, éste
     * se debe declarar como abstracto, es decir, el método no tiene ningún
     * cuerpo (ni siquiera vacío), por lo que no tiene llaves, y además debe
     * terminar en punto y coma.
     */
    public abstract String emitirSonido();
    
    /**
     * Sobrescritura del método toString (heredado de Object) que da información
     * sobre la mascota.
     */
    @Override
    public String toString() {
        return String.format("La mascota es un %s que se llama %s y que hace %s", 
            this.getClass().getSimpleName(),// Tipo de mascota (nombre de la clase)
            this.getNombre(), // Nombre de la mascota
            this.emitirSonido() // Sonido emitido por la mascota
                                // Llamada a un método polimórfico
        );
    }
    
} // Fin de Figura
