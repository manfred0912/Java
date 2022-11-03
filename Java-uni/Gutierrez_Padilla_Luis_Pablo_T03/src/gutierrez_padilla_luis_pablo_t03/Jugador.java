package gutierrez_padilla_luis_pablo_t03;

public class Jugador {
    String numero;
    String nombre;
    String nacionalidad;
    int edad;
    
public Jugador(){
    numero = "0";
    nombre = null;
    nacionalidad = null;
    edad = 0;
}

public Jugador(String numero, String nombre, String nacionalidad, int edad){
    this.numero = numero;
    this.nombre = nombre;
    this.nacionalidad = nacionalidad;
    this.edad = edad;
}
    
public void establecerNumero(String numero) {
    this.numero = numero;
}

public String obtenerNumero(){
    return numero;
}
    
public void establecerNombre(String nombre) {
    this.nombre = nombre;
}

public String obtenerNombre(){
    return nombre;
}

public void establecerNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
}

public String obtenerNacionalidad(){
    return nacionalidad;
}

public void establecerEdad(int edad) {
    this.edad = edad;
}

public int obtenerEdad(){
    return edad;
}

 public void desplegarDatos() {
        auxiliar();
    }
    
 private void auxiliar() {
    System.out.println("Numero: " + numero);
    System.out.println("Nombre(s): " + nombre);
    System.out.println("Nacionalidad: " + nacionalidad);  
    }
}
