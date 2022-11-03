package gutierrez_padilla_luis_pablo_t05;

import java.util.Scanner;

public class GestionPais {

    public static void main(String[] args) {
        Pais p1 = new Pais();
        Estado e1 = new Estado();
        Municipio m1 = new Municipio();
        
        p1.setNombre("México");
        p1.setCapital("Ciudad de México");
        
        e1.setNombre("Jalisco");
        e1.setCapital("Guadalajara");
        
        m1.setNombre("Zapopan");
        m1.setAlcalde("Juan José Frangie");
        
        System.out.println(p1);
        System.out.println(e1);
        System.out.println(m1);
        
    }
    
}
