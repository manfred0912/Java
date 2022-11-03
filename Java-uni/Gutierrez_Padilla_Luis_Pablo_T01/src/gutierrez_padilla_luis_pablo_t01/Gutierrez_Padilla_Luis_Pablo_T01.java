package gutierrez_padilla_luis_pablo_t01;

import java.util.Scanner;

public class Gutierrez_Padilla_Luis_Pablo_T01 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        float centigrados;
        float fahrenheit;
        
        System.out.println("Por favor introduzca los grados centigrados a convertir: ");
        centigrados = entrada.nextFloat();
        
        fahrenheit = (float) ((centigrados * 1.8) + 32);
        
        System.out.println("La temperatura en grados fahrenheit es: " + fahrenheit);
    }
}
