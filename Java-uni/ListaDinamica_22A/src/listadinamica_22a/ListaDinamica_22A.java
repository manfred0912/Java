package listadinamica_22a;

import javax.swing.JFrame;


public class ListaDinamica_22A {

    public static void main(String[] args) {
        VentanaListaDinamica vld = new VentanaListaDinamica();
        
        vld.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Establecer que la ventana no pueda cambiar de tamaño
        vld.setResizable(false);
        
    }
    
}
