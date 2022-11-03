package Valencia_Saldana_Uriel_Israel_PF;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NivelMedioEstados2 extends JFrame{
    
    private JPanel PanelBotones;
    private JPanel panelTexto;
    private JPanel PanelImagen;
    private JButton boton1, boton2, boton3, regresar;
    private JButton[] botones;
    private JLabel pregunta;
    
        public NivelMedioEstados2(){
        super("Nivel Medio Pregunta 2");
        JLabel qroo_jpg = new JLabel(new ImageIcon("qroo.jpg")); //Imagen
        PanelBotones = new JPanel();
        botones = new JButton[4];
        PanelBotones.setLayout(new GridLayout(2, botones.length));
        PanelImagen = new JPanel();
        PanelImagen.add(qroo_jpg); //Modificar en todo lo demas
        
        //Pregunta       
        pregunta = new JLabel("¿Cuál la capital del estado de Quintana Roo");
        
        //Diseño de letra
        pregunta.setFont(new Font("Arial", Font.BOLD,20));
        panelTexto = new JPanel();
        panelTexto.add(pregunta);
        
        //Crear Botones
        boton1 = new JButton("Cancun");
        boton2 = new JButton("Chetumal");
        boton3 = new JButton("Tulum");
        regresar = new JButton("Regresar");
        
        //Agregar botones JPanel
        PanelBotones.add(boton1);
        PanelBotones.add(boton2);
        PanelBotones.add(boton3);
        PanelBotones.add(regresar);
        
        add(PanelBotones, BorderLayout.SOUTH);
        add(panelTexto, BorderLayout.NORTH);
        add(PanelImagen, BorderLayout.CENTER);
        
        ActionListener accion1 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent AE) {
            JOptionPane.showMessageDialog(null,"Respuesta Incorrecta, Intentalo de Nuevo");
            MenuEstados accion1  = new MenuEstados();
            accion1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            accion1.setBounds(380, 150, 600, 500);
            accion1.setVisible(true);
            dispose();
            }
        }; boton1.addActionListener(accion1);
        
        ActionListener accion2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent AE) {
                JOptionPane.showMessageDialog(null,"Respuesta Correcta, Ganaste el Nivel Medio!");
                MenuEstados accion2 = new MenuEstados();
                accion2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                accion2.setBounds(380, 150, 600, 500);
                accion2.setVisible(true);
                dispose();
            }
        }; boton2.addActionListener(accion2);
        
        ActionListener accion3 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent AE) {
              JOptionPane.showMessageDialog(null,"Respuesta Incorrecta, Intentalo de nuevo");
              MenuEstados accion3  = new MenuEstados();
              accion3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              accion3.setBounds(380, 150, 600, 500);
              accion3.setVisible(true);
              dispose();
            }
        }; boton3.addActionListener(accion3);
        
        ActionListener accion4 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent AE) {
               int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de regresar al menu de estados?","Atencion!", JOptionPane.YES_NO_OPTION);
               if(resp == 0){
                   MenuEstados accion4  = new MenuEstados();
                   accion4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   accion4.setBounds(380, 150, 600, 500);
                   accion4.setVisible(true);
                   dispose();
               }
            }    
        }; regresar.addActionListener(accion4);
    }
}