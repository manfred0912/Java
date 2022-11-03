package gestionfiguras_22a;

import java.util.ArrayList;
import java.util.Set;

public class GestionFiguras_22A {

    public static void main(String[] args) {
        Circulo c1 = new Circulo();
        System.out.println(c1); // c1.toString()
        c1.setRadio(2.0);
        System.out.println(c1); // c1.toString()
        double a1 = c1.calcularArea();
        System.out.printf("Área de c1: %.6f\n", a1);
        
        Circulo c2 = new Circulo(3.0);
        String s1 = c2.toString();
        System.out.println(s1);
        
        System.out.println("");
        
        Triangulo t1 = new Triangulo();
        System.out.println(t1); //t1.toString();
        t1.setBase(2.0);
        System.out.println("Nueva base de t1: " + t1.getBase());
        System.out.println(t1);
        
        Triangulo t2 = new Triangulo(3.0);
        System.out.println(t2.toString()); // Para entrar por el depurador
        
        Triangulo t3 = new Triangulo(4.0, 5.0);
        System.out.println(t3.toString());
        
        System.out.println("");
        
        TrianguloEquilatero te1 = new TrianguloEquilatero();
        System.out.println(te1);
        
        TrianguloEquilatero te2 = new TrianguloEquilatero(2.0);
        System.out.println(te2);
        te2.setAltura(3.0);
        System.out.println(te2);
        
        TrianguloEquilatero te3 = new TrianguloEquilatero(3.0, 4.0);
        System.out.println(te3.toString());
        
        Figura f1 = new Circulo(5.0);
        Figura f2 = new Triangulo(5.0, 6.0);
        Figura f3 = new TrianguloEquilatero(10.0);
        
        Triangulo t4 = new TrianguloEquilatero(20.0);
        // TrianguloEquilatero te4 = new Triangulo(7.0, 8.0);
        // no se puede tener un objeto de una subclase convertido a una superclase
        
        System.out.println();
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
    
        System.out.println();
        desplegarInfo(c1);
        desplegarInfo(c2);
        desplegarInfo(t1);
        desplegarInfo(t2);
        desplegarInfo(t3);
        desplegarInfo(te1);
        desplegarInfo(te2);
        desplegarInfo(te3);
        desplegarInfo(f1);
        desplegarInfo(f2);
        desplegarInfo(f3);
        
        // Arreglo dinamico para guardar las figuras
        ArrayList<Figura> figuras = new ArrayList<>(); 
        figuras.add(c1);
        figuras.add(c2);
        figuras.add(t1);
        figuras.add(t2);
        figuras.add(t3);
        figuras.add(te1);
        figuras.add(te2);
        figuras.add(te3);
        
        System.out.println();
        System.out.println("Figuras en el arreglo: ");
        for(Figura f : figuras){
            desplegarInfo(f);
        }
    } 
    
    // metodo polimorfico que despliegue informacion de las figuras
    public static void desplegarInfo(Figura f){
        String tipo = f.getClass().getSimpleName();
        String param = "";

        // referencia_objeto instanceof Nombre_Clase
        if(f instanceof Circulo){
            tipo = "Círculo";
            param = String.format("Radio: %.4f\n", ((Circulo) f).getRadio());
        } else if(f instanceof TrianguloEquilatero){
            tipo = "Triángulo Equilatero";
            param = String.format("Base: %.4f\nAltura: %.4f\n", ((TrianguloEquilatero) f).getBase(), ((TrianguloEquilatero) f).getAltura());
        } else if(f instanceof Triangulo){
            tipo = "Triángulo";
            param = String.format("Base: %.4f\nAltura: %.4f\n", ((Triangulo) f).getBase(), ((Triangulo) f).getAltura());
        }
        
        System.out.println("Tipo: " + tipo);
        System.out.printf("Area: %.4f\n", f.calcularArea());
        System.out.printf(param);
        System.out.println();
    }
}
