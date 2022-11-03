package ventanacopiartexto_22a;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaCopiar extends JFrame {
    // Campos
    private JTextField jtfTexto;
    private JButton jbtCopiar;
    private JLabel jlblTextoCopiado;
    
    public VentanaCopiar() {
        super("Ventana Copiar Texto");
        
        this.setBounds(300, 300, 300, 200);
        
        // Establecer un administrador de esquemas ("layout manager")
        this.setLayout(new FlowLayout());
        
        jtfTexto = new JTextField(15);
        
        this.add(jtfTexto);
        
        jbtCopiar = new JButton("Copiar");
        
        this.add(jbtCopiar);
        
        jlblTextoCopiado = new JLabel("............");
        
        this.add(jlblTextoCopiado);
        
        // Paso 2 (gestión eventos del botón)
        GestionEventosBoton geb = new GestionEventosBoton();
        
        // Paso 3 (gestión eventos del botón)
        jbtCopiar.addActionListener(geb);
        
        this.setVisible(true);
    }
    
    // Paso 1 (gestión eventos del botón)
    private class GestionEventosBoton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener el texto de la caja de texto
            String s = jtfTexto.getText();
            
            // Copiar texto en la etiqueta
            jlblTextoCopiado.setText(s);
        }
        
    }
    
}
