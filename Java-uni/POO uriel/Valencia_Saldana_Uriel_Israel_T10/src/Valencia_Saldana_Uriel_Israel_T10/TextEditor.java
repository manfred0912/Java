package Valencia_Saldana_Uriel_Israel_T10;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextEditor extends JFrame {
    
    private final JPanel panelBotones;
    private final JTextArea campoTexto; 
    private final Font letraSimple;
    private final Font letraNegrita;
    private final Font letraCursiva;
    private final Font letraNegritaCursiva;
    private final JRadioButton simpleJRadioButton;
    private final JRadioButton negritaJRadioButton;
    private final JRadioButton cursivaJRadioButton; 
    private final JRadioButton negritaCursivaJRadioButton;
    private final ButtonGroup grupoOpciones;
    
    public TextEditor(){
        super("Panel de Demostracion");
        
        Box cuadro = Box.createHorizontalBox(); // Crea la caja
        String demo = "Este es un texto de prueba para observar el cambio de texto a \n"
            + "cursiva, negrita o texto simple\n";
        campoTexto = new JTextArea(demo, 25, 20);
       
        cuadro.add(new JScrollPane(campoTexto)); // Agrega el panel                    
        add(cuadro, BorderLayout.CENTER);
        
        simpleJRadioButton = new JRadioButton("Simple", true);
        negritaJRadioButton = new JRadioButton("Negrita", false);
        cursivaJRadioButton = new JRadioButton("Cursiva", false);
        negritaCursivaJRadioButton = new JRadioButton("Negrita/Cursiva", false);
        
        add(simpleJRadioButton, BorderLayout.SOUTH);
        add(negritaJRadioButton, BorderLayout.SOUTH);
        add(cursivaJRadioButton, BorderLayout.SOUTH);
        add(negritaCursivaJRadioButton, BorderLayout.SOUTH);
        
        panelBotones = new JPanel(new GridLayout(1,1));
        panelBotones.add(simpleJRadioButton);
        panelBotones.add(negritaJRadioButton);
        panelBotones.add(cursivaJRadioButton);
        panelBotones.add(negritaCursivaJRadioButton);
        
        grupoOpciones = new ButtonGroup(); // Crea el grupo del boton
        grupoOpciones.add(simpleJRadioButton); // Agrega simple al grupo
        grupoOpciones.add(negritaJRadioButton); // Agrega negrita al grupo
        grupoOpciones.add(cursivaJRadioButton); // Agrega cursiva al grupo
        grupoOpciones.add(negritaCursivaJRadioButton); // Agrega negrita y cursiva
        
        letraSimple = new Font("Arial", Font.PLAIN, 12); //Establecemos la fuente y tamaño
        letraNegrita = new Font("Arial", Font.BOLD, 12);
        letraCursiva = new Font("Arial", Font.ITALIC, 12);
        letraNegritaCursiva = new Font("Arial", Font.BOLD + Font.ITALIC, 12);
        campoTexto.setFont(letraSimple);
        
        simpleJRadioButton.addItemListener(new OpcionesBotones(letraSimple));
        negritaJRadioButton.addItemListener(new OpcionesBotones(letraNegrita));
        cursivaJRadioButton.addItemListener(new OpcionesBotones(letraCursiva));
        negritaCursivaJRadioButton.addItemListener(new OpcionesBotones(letraNegritaCursiva));       
        
        this.add(panelBotones, BorderLayout.NORTH);
    }   
    private class OpcionesBotones implements ItemListener{
               private final Font tipoLetra;
               
               public OpcionesBotones (Font f){
                tipoLetra = f;
            }
        @Override
        public void itemStateChanged(ItemEvent e) {
         
            campoTexto.setFont(tipoLetra);
        }   
    }
}
