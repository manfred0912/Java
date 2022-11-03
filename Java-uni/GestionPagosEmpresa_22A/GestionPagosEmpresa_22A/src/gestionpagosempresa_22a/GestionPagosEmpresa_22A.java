package gestionpagosempresa_22a;

import java.util.ArrayList;

/**
 * Una empresa necesita gestionar los pagos por realizar.
 * Es necesario pagar facturas y el sueldo o salario de los empleados.
 * Se requiere integrar los pagos de las facturas y de los empleados.
 * 
 *          Interfaz_Pagable
 *            |        |
 *         Factura   Empleado
 *                   |      |
 *     EmpleadoConfianza  Asalariado
 * 
 */


public class GestionPagosEmpresa_22A {
    // Campos
    
    // Arreglo dinámico de objetos de clases que implementan la interfaz Pagable
    private static ArrayList<Pagable> pagos = new ArrayList<>();

    public static void main(String[] args) {
        
        // Agregar objetos al arreglo
        pagos.add(new Factura("F001", "Pluma BIC punto mediano tinta azul", 100, 2.75));
        pagos.add(new EmpleadoConfianza("E001", "Juan", "Pérez", "Rodriguez", 15000.0, 2000.0));
        pagos.add(new Asalariado("E002", "María", "López", "Ramírez", 12000.0, 5, 200.0));
        
        
        // Desplegar contenido del arreglo
        for(Pagable p : pagos) {
            System.out.println("Tipo: " + tipoPago(p));
            System.out.print(p); // p.toString()
            System.out.printf("Pago: $%,.2f\n", p.calcularPago());
            System.out.println(); // Salto de línea
        }
        
        double total = 0.0;
        for(Pagable p : pagos){
            total += p.calcularPago();
        }
        
        System.out.printf("Pago total: $%,.2f\n", total);

    }
    
    public static String tipoPago(Pagable p){
        String tipo = p.getClass().getSimpleName();
        
        if(p instanceof Factura){
            tipo = "Factura";
        } else if(p instanceof EmpleadoConfianza){
            tipo = "Empleado de confianza";
        } else if(p instanceof Asalariado){
            tipo = "Asalariado";
        }
        return tipo;
    }
}
