package manejoexcepciones_22a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.WrongMethodTypeException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManejoExcepciones_22A {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1;
        int num2;
        int res;
        boolean continuar = true;
        String nombre = "";
        
        try {
            System.out.println("Introduzca su nombre:");
            nombre = leerLinea();
        } catch(IOException e) {
            System.out.println("Error al leer del teclado.");
        }

        do {
            try {
                
                System.out.println("Introduzca el primer número entero:");
                num1 = entrada.nextInt();
                //entrada.close();
                System.out.println("Introduzca el segundo número entero:");
                num2 = entrada.nextInt();

                res = dividir(num1, num2);

                System.out.println(num1 + "/" + num2 + "=" + res);
                continuar = false;
            } catch (ArithmeticException e) { // e = objeto de la excepción
                System.out.println("La división entre cero no está permitida.");
            } catch (InputMismatchException e) {
                System.out.println("Es necesario introducir un número entero.");
                entrada.nextLine(); // Consumir el "Introducir"
                //e.printStackTrace(); // Para propósitos de depuración de código
            } catch(NegativeOperandException e) {
                System.out.println("No se permite la división con número negativos.");
            } catch (RuntimeException e) {
                System.out.println("Error en tiempo de ejecución: " + e.getMessage());
            } catch (Exception e) { // Atrapa la excepción que no se hubiera capturado
                System.out.println("Ocurrió un error: " + e.getMessage());
            } finally {
                System.out.println("Se entró al finally.");
            }
        } while (continuar);
        
        System.out.println("Gracias, " + nombre + ".");
        
        // Lanzar una excepción
        // 1) Crear el objeto de la excepción
        //WrongMethodTypeException ex = new WrongMethodTypeException();
        // 2) Lanzar la excepción creada
        //throw ex;
        
        //throw new WrongMethodTypeException();
        
    } // Fin de main

    /**
     * Método que calcula y regresa la división de dos números enteros.
     */
    public static int dividir(int dividendo, int divisor) throws NegativeOperandException {
        if(dividendo < 0 || divisor < 0) {
            throw new NegativeOperandException();
        }
        return dividendo / divisor;
    }
    
    /**
     * Método que lee una línea de texto del teclado. Se usará un objeto
     * de tipo BufferedReader, mandando llamar su método readLine(), el
     * cual puede lanzar una excepción verificada del tipo IOException.
     * 
     * Existen dos maneras de manejar una excepción:
     * 1) Utilizar un bloque try/catch
     * 2) Relanzar la excepción: Indicar que el método que puede lanzar la
     *    excepción, lance la excepción al código que invoca al método, para
     *    que dicho código haga el manejo adecuado de la excepción. Esto se
     *    logra agregando la palabra reservada "throws" al encabezado del método,
     *    seguido de la o las excepciones que se pueden lanzar.
     */
    public static String leerLinea() throws IOException {
        String linea = "";
        BufferedReader br;
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        //try {
            linea = br.readLine();
        //} catch(IOException e) {
        //    System.out.println("Error al leer del teclado.");
        //}
        return linea;
    }

} // Fin de clase
