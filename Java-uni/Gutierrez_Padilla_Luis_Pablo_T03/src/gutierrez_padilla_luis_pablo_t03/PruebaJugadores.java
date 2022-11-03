package gutierrez_padilla_luis_pablo_t03;

import java.util.ArrayList;
import java.util.Scanner;

public class PruebaJugadores {
    
    private static final ArrayList<Jugador> grupo = new ArrayList<>();
    
    // Constantes de opciones para el menú principal
    private static final int OPC_ALTA = 1;
    private static final int OPC_LIST = 2;
    private static final int OPC_SALI = 3;
    
    public static void main(String[] args) {
        int opc;
        
        do {
            opc = desplegarMenuPrincipal();
            
            System.out.println();
            switch(opc) {
                case OPC_ALTA:
                    System.out.println("ALTA DE JUGADORES\n");
                    altaDeJugadores();
                    break;
                case OPC_LIST:
                    System.out.println("LISTADO DE JUGADORES\n");
                    listarJugadores();
                    break;
                case OPC_SALI:
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }
            System.out.println();
        } while(opc != OPC_SALI);
    }

        
public static int desplegarMenuPrincipal() {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        System.out.println("MENÚ PRINCIPAL");
        System.out.println(OPC_ALTA + ") Alta de jugadores");
        System.out.println(OPC_LIST + ") Listado de jugadores");
        System.out.println(OPC_SALI + ") Salir");
        System.out.println();
        System.out.print("Opción: ");
        
        opcion = entrada.nextInt();
        
        // Validar que la opción capturada esté en el rango correcto
        // Pedir el valor hasta que esté correcto (mientras la opción sea
        // incorrecta, pedirla de nuevo)
        while(!(opcion >= 1 && opcion <= OPC_SALI)) {
            System.out.println("Opción incorrecta.");
            System.out.print("Opción: ");
            opcion = entrada.nextInt();
        }
        
        return opcion;
    }
        
private static int buscarJugador(String numero) {
        int idx = -1;
        
        // Recorrer el arreglo buscando el estudiante con el código dado
        for(int i=0; i<grupo.size(); ++i) {
            // Verificar si el código del estudiante i-ésimo es igual al
            // código buscado
            if(grupo.get(i).obtenerNumero().equalsIgnoreCase(numero)) {
                idx = i;
                break; // Salir del ciclo for
            }
        }
        
        return idx;
    }        

private static void altaDeJugadores() {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Introduzca los siguientes valores:");
        System.out.print("Numero: ");
        String num = entrada.nextLine().trim();
        
        // Verificar si ya existe un estudiante con ese código
        int idx = buscarJugador(num);
        
        // Mientras el código esté repetido, seguirlo pidiendo
        while(idx != -1) {
            System.out.println("Ya existe un jugador con el numero " + num);
            System.out.print("Introduzca un nuevo numero: ");
            num = entrada.nextLine().trim();
            idx = buscarJugador(num);
        }
        
        // Verificar que el código capturado no esté vacío
        if(num.isEmpty()) {
            System.out.println("Es necesario introducir un numero.");
            return; // Regresar al menú principal
        }
        
        // Capturar los valores del resto de los campos
        Jugador e = capturarDatos(num);
        
        // Agregar objeto al arreglo
        grupo.add(e);
        
        //grupo.add(capturarDatos(cod));
    }

public static Jugador capturarDatos(String num) {
        // Se utizará un objeto de tipo Scanner que permite leer datos del teclado
        Scanner entrada = new Scanner(System.in);
        Jugador e = new Jugador();
        
        // Pedir los valores de todos los campos
//        System.out.println("Código:");
//        String cod = entrada.nextLine();
        System.out.print("Nombre(s): ");
        String nom = entrada.nextLine();
        System.out.print("Nacionalidad: ");
        String nac = entrada.nextLine();
        System.out.print("Edad: ");
        int ed = entrada.nextInt();
        
        // Guardar los valores en los campos correspondientes
        e.establecerNumero(num);
        e.establecerNombre(nom);
        e.establecerNacionalidad(nac);
        e.establecerEdad(ed);
    
        // Regresar referencia del objeto con sus datos capturados
        return e;
    }


public static void listarJugadores() {
        if(grupo.isEmpty()) {
            System.out.println("No hay jugadores en el equipo.");
            return; 
        }
        
        int cont = 1;
        for(Jugador e : grupo) {
            System.out.println("ESTUDIANTE " + cont++);
            e.desplegarDatos();
            System.out.println();
        }
        
    }
}


    
