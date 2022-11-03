package listadinamica_22a;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VentanaListaDinamica extends JFrame {
    // Campos
    private DefaultListModel<String> dlmModelo;
    private JList<String> jlsLista;
    private JTextField jtfSeleccion;
    private JPanel jpnlBotones;
    private JButton jbtAgregar;
    private JButton jbtModificar;
    private JButton jbtEliminar;
    
    
    // Constructor
    public VentanaListaDinamica() {
        super("Lista dinámica");
        
        this.setBounds(1500, 300, 320, 200);
        
        // Establecer el administrador de esquemas ("layout manager")
        this.setLayout(new FlowLayout());
        
        // Crear el modelo contenedor de datos
        dlmModelo = new DefaultListModel<>();
        
        // Agregar algunos elementos al modelo
        dlmModelo.addElement("Enchiladas");
        dlmModelo.addElement("Pozole");
        dlmModelo.addElement("Tamales");
        dlmModelo.addElement("Mole poblano");
        dlmModelo.addElement("Chilaquiles");
        dlmModelo.addElement("Tacos de barbacoa");
        
        // Crear la lista con el modelo
        jlsLista = new JList(dlmModelo);
        
        // Establecer algunas propiedades de la lista
        jlsLista.setFixedCellWidth(200);
        jlsLista.setVisibleRowCount(5);
        jlsLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Agregar la lista a la ventana dentro de un panel de desplazamiento
        this.add(new JScrollPane(jlsLista));
        
        // Crear caja de texto
        jtfSeleccion = new JTextField(18);
        
        // Agregar caja de texto a la ventana (realmente, al panel de contenido)
        this.add(jtfSeleccion);
        
        //this.getContentPane().add(jtfSeleccion);
        
        // Cambiar el color del fondo de la ventana
        this.getContentPane().setBackground(Color.lightGray);
        
        // Crear panel para los botones
        jpnlBotones = new JPanel(new GridLayout(1, 3)); // Una fila y tres columnas
        
        // Cambiar fondo del panel de botones
        jpnlBotones.setBackground(Color.lightGray);
        
        // Crear los tres botones
        jbtAgregar = new JButton("Agregar...");
        jbtModificar = new JButton("Modificar");
        jbtEliminar = new JButton("Eliminar");
        
        // Agregar botones al panel de botones
        jpnlBotones.add(jbtAgregar);
        jpnlBotones.add(jbtModificar);
        jpnlBotones.add(jbtEliminar);
        
        // Agregar panel de botones a la ventana
        this.add(jpnlBotones);
        
        // Paso 1, 2 y 3 (gestión eventos lista) usando una clase interna
        // anónima que implementa la interfaz de escucha ListSelectiontListener
        jlsLista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Obtener elemento seleccionado
                String s = jlsLista.getSelectedValue();
                // Poner el valor del elemento seleccionado en la caja de texto
                jtfSeleccion.setText(s);
            }
        });
        
        // Gestión eventos botón Agregar
        jbtAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarElemento();
            }
        });
        
        // Gestión eventos botón Modificar
        jbtModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarElemento();
            }
        });
        
        // Gestión eventos botón Eliminar
        jbtEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarElemento();
            }
        });

        this.setVisible(true);
    } // Fin de constructor
    
    private void agregarElemento() {
        // Mostrar la ventana para capturar la nueva comida
        String elem = JOptionPane.showInputDialog(
                this, // Ventana padre
                "Introduzca una nueva comida:", // Mensaje
                "Nueva comida", // Título de la ventana
                JOptionPane.PLAIN_MESSAGE // Tipo de mensaje
        );
        
        // Verificar si se canceló la operación
        if(elem == null) {
            return; // Salir del método
        }
        
        // TODO Verificar si el usuario no escribió nada y le dio clic a "Aceptar",
        // o bien, escribió sólo espacios en blanco
        
    }

    private void modificarElemento() {
        
    }

    private void eliminarElemento() {
        
    }

    
} // Fin de clase 
