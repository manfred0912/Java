package gutierrez_padilla_luis_pablo_t10;

 import java.awt.GridLayout;
 import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class MarcoPanel extends JFrame {
private final JTextArea areaTexto;

private final Font tipoLetraSimple; // tipo de letra para texto simple
private final Font tipoLetraNegrita; // tipo de letra para texto en negrita
private final Font tipoLetraCursiva; // tipo de letra para texto en cursiva
private final Font tipoLetraNegritaCursiva; // tipo de letra para texto en negrita y cursiva

private final JRadioButton simpleJRadioButton; // selecciona texto simple
private final JRadioButton negritaJRadioButton; // selecciona texto en negrita
private final JRadioButton cursivaJRadioButton; // selecciona texto en cursiva
private final JRadioButton negritaCursivaJRadioButton; // negrita y cursiva
private final ButtonGroup grupoOpciones;
private final JPanel panelBotones; // panel que contiene los botones

// constructor sin argumentos
public MarcoPanel() {
    super("Editor de estilo de texto");

    panelBotones = new JPanel();
    panelBotones.setLayout(new GridLayout(1, 4));
    // crea los botones de opción
    simpleJRadioButton = new JRadioButton("Simple", true);
    negritaJRadioButton = new JRadioButton("Negrita", false);
    cursivaJRadioButton = new JRadioButton("Cursiva", false);
    negritaCursivaJRadioButton = new JRadioButton("Negrita/Cursiva", false);
    panelBotones.add(simpleJRadioButton); // agrega botón simple a JFrame
    panelBotones.add(negritaJRadioButton); // agrega botón negrita a JFrame
    panelBotones.add(cursivaJRadioButton); // agrega botón cursiva a JFrame
    panelBotones.add(negritaCursivaJRadioButton); // agrega botón negrita y cursiva
    
    grupoOpciones = new ButtonGroup(); // Crea el grupo del boton
    grupoOpciones.add(simpleJRadioButton); // Agrega simple al grupo
    grupoOpciones.add(negritaJRadioButton); // Agrega negrita al grupo
    grupoOpciones.add(cursivaJRadioButton); // Agrega cursiva al grupo
    grupoOpciones.add(negritaCursivaJRadioButton); // Agrega negrita y cursiva

    tipoLetraNegritaCursiva = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
    tipoLetraCursiva = new Font("Serif", Font.ITALIC, 14);
    tipoLetraNegrita = new Font("Serif", Font.BOLD, 14);
    tipoLetraSimple = new Font("Serif", Font.PLAIN, 14);

    // registra eventos para los objetos JRadioButton
    simpleJRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraSimple));
    negritaJRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraNegrita));
    cursivaJRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraCursiva));
    negritaCursivaJRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraNegritaCursiva));



    Box cuadro = Box.createHorizontalBox(); // crea un cuadro

    areaTexto = new JTextArea("Escriba aqui", 10, 15);
    areaTexto.setFont(tipoLetraSimple);
    cuadro.add(new JScrollPane(areaTexto)); // agrega panel de desplazamiento

    add(panelBotones, BorderLayout.SOUTH); // agrega el panel a JFrame
    add(cuadro, BorderLayout.CENTER);
}

// clase interna privada para manejar eventos de botones de opción
private class ManejadorBotonOpcion implements ItemListener {
    private Font tipoLetra; // tipo de letra asociado con este componente de escucha

    public ManejadorBotonOpcion(Font f){
        tipoLetra = f;
    }
    // maneja los eventos de botones de opción
    @Override
    public void itemStateChanged(ItemEvent evento) {
            areaTexto.setFont(tipoLetra);
        }
    }
} // fin de la clase MarcoPanel