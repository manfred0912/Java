package ventanaawtconboton;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class VentanaBoton extends Frame {
    // Campos
    private Button bt;
    
    public VentanaBoton(String titulo) {
        super(titulo);
        
        this.setBounds(300, 300, 400, 300);
        
        // Desactivar el administrador de esquemas para poder establecer por codigo 
        // la posicion y tamaño de los componentes dentro de la ventana
        this.setLayout(null);
        
        // Paso 1: Crear el objeto visual
        bt = new Button("Presione aquí");
        
        // Paso 2: Establecer posicion y tamaño (con respecto a la ventana)
        bt.setBounds(50, 50, 150, 50);
        
        // Paso 3: Agregar objeto al contenedor (ventana)
        this.add(bt);
        
        // Paso 2 (Gestión de eventos ventana): Crear el objeto de escucha (del Paso 1)
        GestionEventosVentana gev = new GestionEventosVentana();
        
        // Paso 3 (Gestión de eventos ventana): asociar el objeto que genera los eventos con el objeto de escucha
        this.addWindowListener(gev);
        
        // Paso 2 (gestión eventos botón)
        GestionEventosBoton geb = new GestionEventosBoton();
        
        // Paso 3 (gestión de eventos botón)
        bt.addActionListener(geb);
        
        this.setVisible(true);
        
    }
     /**
     * Clase privada interna para la gestion de eventos de la ventana\
     * Paso 1 (Gestion de eventos de la ventana): Crear la clase que implementa la interfaz de escucha
     */
    private class GestionEventosVentana implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {
            System.out.println("windowOpened");
        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("windowClosing");
            // Terminar la aplicación
            System.exit(0); // 0 = Terminó aplicación sin errores
        }

        @Override
        public void windowClosed(WindowEvent e) {
            System.out.println("windowClosed");
        }

        @Override
        public void windowIconified(WindowEvent e) {
            System.out.println("windowIconified");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            System.out.println("windowDeiconified");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println("windowActivated");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            System.out.println("windowDeactivated");
        }
        
    }
   
     // Paso 1 (Gestión de eventos del botón)
    private class GestionEventosBoton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Boton presionado");
        }
        
    }
}
