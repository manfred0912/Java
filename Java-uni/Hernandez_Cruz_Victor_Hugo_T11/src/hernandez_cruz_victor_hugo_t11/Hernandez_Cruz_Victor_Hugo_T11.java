
package hernandez_cruz_victor_hugo_t11;

import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Hernandez_Cruz_Victor_Hugo_T11 {

    private final static OpcionMenu[]  opciones = OpcionMenu.values();
 //******************************************************************************************   
    public static void main(String[] args) {
       //obtiene la solictud del usuario(saldo de cero con credito o debito)
       OpcionMenu tipoCuenta = obtenerSolicitud();
       while(tipoCuenta != OpcionMenu.FIN){
           switch(tipoCuenta){
               case SALDO_CLIENTES:
                   System.out.printf("%nLista de todos los clientes:%n");
                   break;
               case SALDO_CERO:
                   System.out.printf("%nCuentas con saldos de cero:%n");
                   break;
               case SALDO_CREDITO:
                   System.out.printf("%nCuentas con saldos con credito:%n");
                   break;
               case SALDO_DEBITO:
                   System.out.printf("%nCuentas con saldos de debito:%n");
                   break;
       }
           leerRegistros(tipoCuenta);
           tipoCuenta = obtenerSolicitud();
       }
    }
//******************************************************************************************
    
//******************************************************************************************
    //obtiene la solicitud del usuario
    private static OpcionMenu obtenerSolicitud(){
        int solicitud = 5;
        
        //muestra opciones de solicitud
        System.out.printf("%nMenu de solictud%n%s%n%s%n%s%n%s%n%s",
                " 1 - Lista de todas las cuentas",
                " 2 - Lista de cuentas con saldos de cero",
                " 3 - Lista de cuentas con saldos con credito",
                " 4 - Lista de cuentas con saldos con debito",
                " 5 - Terminar programa");
        try{
            Scanner entrada = new Scanner(System.in);
            do//recibe solicitud del usuario
            {
                System.out.printf("%n ?");
                solicitud = entrada.nextInt();
            }while((solicitud<1)|| (solicitud >5));   
        }
        catch(NoSuchElementException noSuchElementException){
            System.err.println("Entrada invalida. Terminado");
        }
        return opciones[solicitud -1]; //devuelve valor de enum para la opcion
    }
//******************************************************************************************
//******************************************************************************************  
    //lee los registros del arvhivo y muestra solo los registros del tipo apropiado}
    private static void leerRegistros(OpcionMenu tipoCuenta){
        //abre el archivo y procesa el contenido
        try (Scanner entrada = new Scanner(Paths.get("clientes.txt"))){
            while (entrada.hasNext())//mas datos a leer
            {
                int numeroCuenta = entrada.nextByte();
                String primerNombre = entrada.next();
                String apellidoPaterno = entrada.next();
                double saldo = entrada.nextDouble();
                
                //ssi tipo de cuenta es apropiado muestra el registo
                if(debesMostrar(tipoCuenta, saldo))
                    System.out.printf("%-10d%-12s%-12s%10.2f%n", numeroCuenta,
                            primerNombre, apellidoPaterno, saldo);
                else
                    entrada.nextLine();//descatya el resto del registor Actual
            }
        }
        catch(NoSuchElementException | IllegalStateException | IOException e)
        {
            System.err.println("Error al procesar el archivo. Terminando.");
            System.exit(1);
        }
    }//fin del metodo leer registos
    //******************************************************************************************
    //******************************************************************************************
    //usal el tipo de registro para determinar si el grupo debe mostrarse
    private static boolean debesMostrar(OpcionMenu tipoCuenta, double saldo){
      
      if (tipoCuenta == OpcionMenu.SALDO_CLIENTES)
            return true;
      else if((tipoCuenta == OpcionMenu.SALDO_CREDITO) && (saldo <0))  
          return true;
      else if((tipoCuenta == OpcionMenu.SALDO_DEBITO) && (saldo >0))
          return true;
      else if ((tipoCuenta == OpcionMenu.SALDO_CERO) && (saldo == 0))
          return true;
      
      return false;
    }//fin de la clase consulta credito
    //******************************************************************************************
    }
    
