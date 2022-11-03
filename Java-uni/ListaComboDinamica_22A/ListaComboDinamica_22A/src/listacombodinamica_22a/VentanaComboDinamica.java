package listacombodinamica_22a;

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

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VentanaComboDinamica extends JFrame {
    // Campos
    private DefaultComboBoxModel<String> dcbmModelo;
    private JComboBox<String> jcbLista;
    private JTextField jtfSeleccion;
    private JPanel jpnlBotones;
    private JButton jbtAgregar;
    private JButton jbtModificar;
    private JButton jbtEliminar;
    
    
    // Constructor
    public VentanaComboDinamica() {
        super("Lista combo dinámica");
        
        this.setBounds(1500, 300, 320, 200);
        
        // Establecer el administrador de esquemas ("layout manager")
        this.setLayout(new FlowLayout());
        
        // Crear el modelo contenedor de datos
        dcbmModelo = new DefaultComboBoxModel<>();
        
        // Agregar algunos elementos al modelo
        dcbmModelo.addElement("Enchiladas");
        dcbmModelo.addElement("Pozole");
        dcbmModelo.addElement("Tamales");
        dcbmModelo.addElement("Mole poblano");
        dcbmModelo.addElement("Chilaquiles");
        dcbmModelo.addElement("Tacos de barbacoa");
        
        // Crear la lista con el modelo
        jcbLista = new JComboBox(dcbmModelo);
        
        // Establecer algunas propiedades de la lista
        //jcbLista.setFixedCellWidth(200);
        jcbLista.setMaximumRowCount(5);
        //jcbLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Agregar la lista a la ventana dentro de un panel de desplazamiento
        this.add(new JScrollPane(jcbLista));
        
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
        // anónima que implementa la interfaz de escucha ItemListener
        jcbLista.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Obtener elemento seleccionado
                String s = (String)jcbLista.getSelectedItem();
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
        
        // Verificar si el usuario no escribió nada y le dio clic a "Aceptar",
        // o bien, escribió sólo espacios en blanco
        elem = elem.trim();
        if(elem.length() == 0) { // Cadena vacía
            mostrarAdvertencia("Es necesario introducir una nueva comida.");
            return;
        }
        
        // Verificar que el nuevo elemento no exista previamente (hacer
        // búsqueda secuencial en la lista (en el modelo)
        for(int i=0; i<dcbmModelo.getSize(); ++i) {
            // Verificar si el nuevo elemento es igual al i-ésimo elemento de la lista
            if(elem.equalsIgnoreCase(dcbmModelo.getElementAt(i))) {
                String mensaje = "La comida \"" + elem + "\" ya fue dada de alta anteriormente.";
                mostrarAdvertencia(mensaje);
                return;
            }
        }
        
        // Agregar el elemento al final de la lista
        dcbmModelo.addElement(elem);
        
        // Seleccionar (por código) en la lista el elemento agregado
        jcbLista.setSelectedItem(elem);
        
    } // Fin de agregarElemento

    
    private void modificarElemento() {
        // Obtener índice del elemento seleccionado
        int idx = jcbLista.getSelectedIndex();
        
        // Verificar si no se seleccionó ningún elemento
        if(idx == -1) {
            mostrarAdvertencia("Es necesario seleccionar la comida por modificar.");
            return;
        }
        
        // Obtener el elemento por modificar de la caja de texto (sin espacios
        // en blanco antes y después)
        String elemMod = jtfSeleccion.getText().trim();
        
        // Verificar si la cadena está vacía
        if(elemMod.length() == 0) {
            mostrarAdvertencia("Es necesario escribir una modificación.");
            return;
        }
        
        // Verificar si el elemento modificado existe en el resto de la lista
        for(int i=0; i<dcbmModelo.getSize(); ++i) {
            // Verificar los elemento diferente del seleccionado
            if(i != idx) {
                // Verificar si el elemento modificado es igual al i-ésimo
                // elemento de la lista
                if(elemMod.equalsIgnoreCase(dcbmModelo.getElementAt(i))) {
                    String mensaje = "La comida \"" + elemMod + "\" ya fue dada de alta anteriormente.";
                    mostrarAdvertencia(mensaje);
                    return;              
                }
            }
        }
        
        // Pedir confirmación al usuario
        String mensaje = "¿Realmente desea reemplazar \"" + dcbmModelo.getElementAt(idx) + 
                "\" por \"" + elemMod + "\"?";
        
        int opcion = JOptionPane.showConfirmDialog(
                this, // Ventana madre
                mensaje, // Mensaje
                "Confirmación", // Título
                JOptionPane.YES_NO_OPTION, // Tipo de opción
                JOptionPane.QUESTION_MESSAGE // Tipo de mensaje
        );
        
        if(opcion == JOptionPane.YES_OPTION) {
            // Eliminar el elemento anterior
            dcbmModelo.removeElementAt(idx);
            // Insertar el nuevo elemento
            dcbmModelo.insertElementAt(elemMod, idx);
            // Seleccionar el elemento modificado
            jcbLista.setSelectedIndex(idx);
        } else { // JOptionPane.NO_OPTION
            return;
        }
        
    } // Fin de modificarElemento

    
    private void eliminarElemento() {
        // Obtener índice del elemento seleccionado
        int idx = jcbLista.getSelectedIndex();
        
        // Verificar si no se seleccionó ningún elemento
        if(idx == -1) {
            mostrarAdvertencia("Es necesario seleccionar la comida por eliminar.");
            return;
        }
        
        // Pedir confirmación al usuario
        String mensaje = "¿Realmente desea eliminar \"" + dcbmModelo.getElementAt(idx) + "\"?";
        
        int opcion = JOptionPane.showConfirmDialog(
                this, // Ventana madre
                mensaje, // Mensaje
                "Confirmación", // Título
                JOptionPane.YES_NO_OPTION, // Tipo de opción
                JOptionPane.QUESTION_MESSAGE // Tipo de mensaje
        );
        
        // Verificar si el usuario presionó el botón de "Sí"
        if(opcion == JOptionPane.YES_OPTION) {
            dcbmModelo.removeElementAt(idx);
        }
        
    } // Fin de eliminarElemento
    
    /**
     * Método que despliega una ventana de diálogo de advertencia tipo 
     * JOptionPane que muestra el mensaje recibido.
     */
    private void mostrarAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(
                this, // Ventana madre
                mensaje, // Mensaje
                "Advertencia", // Título de la ventana
                JOptionPane.WARNING_MESSAGE
        );
    }

    
} // Fin de clase 
