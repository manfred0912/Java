package creararchivotexto;

// Fig. 15.3: CrearArchivoTexto.java
// Escribir datos en un archivo de texto secuencial mediante la clase Formatter.
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CrearArchivoTexto {

    private static Formatter salida; // envía texto a un archivo

    public static void main(String[] args) {
        abrirArchivo();
        agregarRegistros();
        cerrarArchivo();
    }

    // abre el archivo clientes.txt
    public static void abrirArchivo() {
        try {
            salida = new Formatter("clientes.txt"); // abre el archivo
        } catch (SecurityException securityException) {
            System.err.println("Permiso de escritura denegado. Terminando.");
            System.exit(1); // termina el programa
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo. Terminando.");
            System.exit(1); // termina el programa
        }
    }

    // agrega registros al archivo
    public static void agregarRegistros() {
        Scanner entrada = new Scanner(System.in);
        System.out.printf("%s%n%s%n? ",
                "Escriba numero de cuenta, nombre, apellido y saldo.",
                "Para terminar la entrada, escriba el indicador de fin de archivo.");

        while (entrada.hasNext()) { // itera hasta encontrar el indicador de fin de archivo
            try {
                // escribe el nuevo registro en el archivo; asume una entrada válida
                salida.format("%d%s%s%.2f%n", entrada.nextInt(), entrada.next(), entrada.next(), entrada.nextDouble());
 }
 catch (FormatterClosedException formatterClosedException) {
                System.err.println(
                "Error al escribir en el archivo. Terminando.");
                break;
            } catch (NoSuchElementException elementException) {
                System.err.println("Entrada invalida. Intente de nuevo.");
                entrada.nextLine(); // descarta la entrada para que el usuariointente de nuevo
            }

            System.out.print("? ");
 } // fin de while
} // fin del método agregarRegistros

 // cierra el archivo
 public static void cerrarArchivo() {
        if (salida != null) {
            salida.close();
        }
    }

}
