package botonesconestado_22a;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class VentanaBotonesEstado extends JFrame {
    // Campos
    private JLabel jlblTexto;
    private JRadioButton jrbSerif;
    private JRadioButton jrbSansSerif;
    private ButtonGroup grupoBotones;
    private JCheckBox jcxNegrita;
    private JCheckBox jcxCursiva;
    private JPanel jpnlNombreFuente; // Para los JRadioButton
    private JPanel jpnlEstiloFuente; // Para los JCheckBox
    private JPanel jpnlPaneles;
    // Para los parámetros de la fuente
    private String nombreFuente;
    private int estiloFuente;
    private int tamFuente;
    
    // Constructor
    public VentanaBotonesEstado() {
        super("Botones con estado");
        
        this.setBounds(1500, 400, 400, 400);
        
        // Establecer BorderLayout como administrador de esquemas ("layout manager")
        // Este administrador de esquemas es el que se usa por omisión en Swing
        this.setLayout(new BorderLayout());
        
        // Establecer valores de los parámetros de la fuente de la etiqueta
        nombreFuente = "Serif";
        estiloFuente = Font.PLAIN;
        tamFuente = 70;
        
        // Crear etiqueta
        jlblTexto = new JLabel("CUCEA", SwingConstants.CENTER);
        // Establecer fuente de la etiqueta
        jlblTexto.setFont(new Font(nombreFuente, estiloFuente, tamFuente));
        // Agregar etiqueta a la región central del BorderLayout
        this.add(jlblTexto, BorderLayout.CENTER);
        
        // Crear panel para los botones de radio
        jpnlNombreFuente = new JPanel(new GridLayout(2,1)); // 2 filas, 1 columna
        jpnlNombreFuente.setBorder(BorderFactory.createTitledBorder("Fuente")); //
        // Crear los botones de radio
        jrbSerif = new JRadioButton("Serif", true); // Botón seleccionado
        jrbSansSerif = new JRadioButton("Sans Serif");
        // Crear objeto de grupo botones
        grupoBotones = new ButtonGroup(); // No es control visual
        // Agregar botones de radio al grupo
        grupoBotones.add(jrbSerif);
        grupoBotones.add(jrbSansSerif);
        // Agregar botones al panel
        jpnlNombreFuente.add(jrbSerif);
        jpnlNombreFuente.add(jrbSansSerif);
        
        // Crear panel para las cajas de selección
        jpnlEstiloFuente = new JPanel(new GridLayout(2,1));
        jpnlEstiloFuente.setBorder(BorderFactory.createTitledBorder("Estilo")); //
        // Crear las cajas de seleccion
        jcxNegrita = new JCheckBox("Negrita");
        jcxCursiva = new JCheckBox("Cursiva");
        // Agregar cajas al panel
        jpnlEstiloFuente.add(jcxNegrita);
        jpnlEstiloFuente.add(jcxCursiva);
        
        // Crear el panel de paneles
        jpnlPaneles = new JPanel(new GridLayout(1,2));
        // Agregar los paneles
        jpnlPaneles.add(jpnlNombreFuente);
        jpnlPaneles.add(jpnlEstiloFuente);
        
        // Agregar el panel de paneles a la región sur del BorderLayout
        this.add(jpnlPaneles, BorderLayout.SOUTH);
        
        this.setVisible(true);
        
    } // Fin de constructor
    
    
    
} // Fin de clase externa
