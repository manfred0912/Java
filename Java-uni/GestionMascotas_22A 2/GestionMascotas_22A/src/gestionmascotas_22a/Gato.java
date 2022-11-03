package gestionmascotas_22a;

public class Gato extends Mascota {
    
    /*
    Todo constructor debe tener como primera instrucción una llamada (implícita
    o explícita) a otro constructor (en esta clase o en la superclase).
    Si no escribe ninguna llamada a otro constructor, el compilador agrega
    al momento de compilar una llamada al constructor por omisión de la
    superclase (super();)
    */
    
    // Constructores
    public Gato() {
        //super(); 
    }
    
    public Gato(String nombre) {
        //this.nombre = nombre;
        //System.out.println("");
        super(nombre); // Llamada al constructor de Mascota que recibe el nombre
    }

    // Sobrescritura del método emitir sonido heredado de la clase Mascota
    @Override // Anotación (opcional) para garantizar que se está sobrescribiendo el método
    public String emitirSonido() {
        return "Miau";
    }
    
    public void x() {
        System.out.println("Método x");
    }    
}
