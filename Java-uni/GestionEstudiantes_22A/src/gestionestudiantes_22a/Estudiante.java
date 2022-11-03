package gestionestudiantes_22a;

import java.io.Serializable;
import java.util.Scanner;

public class Estudiante implements Serializable {
    // Campos (modificador_de_acceso tipo_de_dato nombre_del_campo)
    private String codigo;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private int edad;
    private double promedio;
    //private transient Scanner ent;
    
    // ESTE NO ES UN CONTRUCTOR (TIENE TIPO DE RETORNO)
    public void Estudiante() {
        
    }
    
    // Constructor por omisión
    public Estudiante() {
        super(); // Llamada al constructor de la superclase
        this.codigo = "Sin definir";
        
        this.apMaterno = "";
    }

    public Estudiante(String codigo) {
        this.codigo = codigo;
    }
    
    public Estudiante(String codigo, String nombre, String apPaterno,
            String apMaterno, int edad, double promedio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.edad = edad;
        this.promedio = promedio;
    }
    
    
    // Métodos de acceso
    
    // Método de lectura del campo "codigo"
    // (modificador_de_acceso tipo_de_dato_de_retorno nombre_del_método(lista_de_parámetro) {}
    public String getCodigo() {
        return codigo;
    }
    
    // Método de escritura del campo "codigo"
    public void setCodigo(String nuevoCodigo) {
        codigo = nuevoCodigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        // "this" es una referencia al objeto en ejecución
        this.nombre = nombre;
    }
    
    public String getApPaterno() {
        return apPaterno;
    }
    
    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }
    
    public String getApMaterno() {
        return apMaterno;
    }
    
    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public double getPromedio() {
        return promedio;
    }
    
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    /**
     * Método para desplegar los valores de los campos de un objeto de tipo
     * Estudiante.
     */
    public void desplegarDatos() {
        auxiliar();
    }
    
    private void auxiliar() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre(s): " + nombre);
        System.out.println("Apellido paterno: " + apPaterno);
        System.out.println("Apellido materno: " + apMaterno);
        System.out.println("Edad: " + edad);
        System.out.println("Promedio: " + promedio);        
    }
    
}
