package gutierrez_padilla_luis_pablo_t02;

import java.util.Scanner;

public class PruebaCuenta {
    public static void main(String[] args) {
        Cuenta cuenta1 = new Cuenta("Jane Green", 50.00, "La providencia 604");
        Cuenta cuenta2 = new Cuenta("John Blue", -7.53, "Juan del carmen 596");

        // muestra el saldo inicial de cada objeto
        
        System.out.println("Saldo de " + cuenta1.obtenerNombre() + ": " + cuenta1.obtenerSaldo());
        System.out.println("Saldo de " + cuenta2.obtenerNombre() + ": " + cuenta2.obtenerSaldo());
            
        // crea un objeto Scanner para obtener la entrada de la ventana de comandos
        Scanner entrada = new Scanner(System.in);

        System.out.println("Escriba el monto a depositar para cuenta1: "); // indicador (promt)
        double montoDeposito = entrada.nextDouble(); // obtiene entrada del usuario
        cuenta1.depositar(montoDeposito); // suma al saldo de cuenta1
        System.out.println("Su nuevo saldo es de: " + cuenta1.obtenerSaldo());
        
        System.out.println("Escriba el monto a depositar para cuenta2: "); // indicador (promt)
        montoDeposito = entrada.nextDouble(); // obtiene entrada del usuario
        cuenta2.depositar(montoDeposito); // suma al saldo de cuenta1
        System.out.println("Su nuevo saldo es de: " + cuenta2.obtenerSaldo());

        System.out.println("Escriba el monto a retirar para cuenta1: "); // indicador (promt)
        double montoRetiro = entrada.nextDouble(); // obtiene entrada del usuario
        cuenta1.retirar(montoRetiro); // suma al saldo de cuenta1
        System.out.println("Su nuevo saldo es de: " + cuenta1.obtenerSaldo());
        
        System.out.println("Escriba el monto a retirar para cuenta2: "); // indicador (promt)
        montoRetiro = entrada.nextDouble(); // obtiene entrada del usuario
        cuenta2.retirar(montoRetiro); // suma al saldo de cuenta1
        System.out.println("Su nuevo saldo es de: " + cuenta2.obtenerSaldo());
} // fin de main
} // fin de la clase PruebaCuenta
    
