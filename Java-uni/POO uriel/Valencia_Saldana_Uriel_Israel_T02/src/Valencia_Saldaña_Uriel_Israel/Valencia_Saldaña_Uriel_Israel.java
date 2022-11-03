
package Valencia_Saldaña_Uriel_Israel;

import java.util.Scanner;

public class Valencia_Saldaña_Uriel_Israel {
 
    public static void main(String[] args) {
        
        Cuenta cuenta1 = new Cuenta("Jane Green", 50.00, "3889 Geneva Street");
        
        Cuenta cuenta2 = new Cuenta("John Blue", -7.53, "834 Hayhurst Lane");
        
        System.out.printf("Saldo de %s: $%.2f%n",
            cuenta1.obtenerNombre(), cuenta1.obtenerSaldo(), cuenta1.getDireccion());
        
        System.out.printf("Dirección de %s: %s",
            cuenta1.obtenerNombre(), cuenta1.getDireccion());
        
        System.out.println();
        
        System.out.printf("Saldo de %s: $%.2f%n",
            cuenta2.obtenerNombre(), cuenta2.obtenerSaldo());
        
        System.out.printf("Dirección de %s: %s",
            cuenta2.obtenerNombre(), cuenta2.getDireccion());
        
        System.out.println();
        
    Scanner entrada = new Scanner(System.in);

        System.out.print("Escriba el monto a depositar para cuenta1:"); 
            double montoDeposito = entrada.nextDouble(); 
        System.out.printf("%nsumando %.2f al saldo de cuenta1%n%n", montoDeposito);
            cuenta1.depositar(montoDeposito); 

        System.out.printf("Saldo de %s: $%.2f%n",
            cuenta1.obtenerNombre(), cuenta1.obtenerSaldo()); 

        System.out.printf("Saldo de %s: $%.2f%n%n",
            cuenta2.obtenerNombre(), cuenta2.obtenerSaldo());

        System.out.print("Escriba el monto a depositar para cuenta2:"); // indicador (promt)
            montoDeposito = entrada.nextDouble(); // obtiene entrada del usuario
        System.out.printf("%nsumando %.2f al saldo de cuenta2%n%n", montoDeposito);
            cuenta2.depositar(montoDeposito);

        System.out.printf("Saldo de %s: $%.2f%n",
            cuenta1.obtenerNombre(), cuenta1.obtenerSaldo()); 

        System.out.printf("Saldo de %s: $%.2f%n%n",
            cuenta2.obtenerNombre(), cuenta2.obtenerSaldo());

        System.out.print("Escriba el monto a retirar para cuenta 1:"); 
            montoDeposito = entrada.nextDouble(); 
        System.out.printf("%nrestando %.2f al saldo de cuenta1%n%n", montoDeposito);
            cuenta1.retirar(montoDeposito); 

        System.out.printf("Saldo de %s: $%.2f%n",
            cuenta1.obtenerNombre(), cuenta1.obtenerSaldo()); 

        System.out.print("Escriba el monto a retirar para cuenta 2:"); 
            montoDeposito = entrada.nextDouble(); 
        System.out.printf("%nrestando %.2f al saldo de cuenta 2%n%n", montoDeposito);
            cuenta2.retirar(montoDeposito); 

        System.out.printf("Saldo de %s: $%.2f%n",
            cuenta2.obtenerNombre(), cuenta2.obtenerSaldo());
    }
}
