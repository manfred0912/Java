package escribirarchivotexto_22a;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class EscribirArchivoTexto_22A {
    // Campos
    private static String nombreArch;
    private static Formatter salidaArch;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Introduzca el nombre del archivo de texto:");
        nombreArch = entrada.nextLine().trim();
        
        abrirArchivo();
        guardarDatos();
        cerrarArchivo();

    }
    
    public static void abrirArchivo() {
        try {
            salidaArch = new Formatter(nombreArch);
        } catch(SecurityException e) {
            System.err.println("No se tiene permiso de escritura.");
            System.exit(101);
        } catch(FileNotFoundException e) {
            System.err.println("Archivo no encontrado.");
            System.exit(102);
        }
        
    }
    
    public static void guardarDatos() {
        Scanner entrada = new Scanner(System.in);
        
        try {
            System.out.println("Introduzca líneas de texto (Ctrl-z o Ctrl-d para terminar):");
            while(entrada.hasNext()) {
                salidaArch.format("%s%n", entrada.nextLine());
            }
            
        } catch(Exception e) {
            System.err.println("Error al escribir en archivo.");
        }
    }
  
    public static void cerrarArchivo() {
        if(salidaArch != null) {
            salidaArch.close();
        }
    }
}
