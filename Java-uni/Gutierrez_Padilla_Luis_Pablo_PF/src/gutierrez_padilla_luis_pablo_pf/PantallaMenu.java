package gutierrez_padilla_luis_pablo_pf;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PantallaMenu extends JFrame {

    private JButton botonInicio;
    private JButton botonMarcador;
    private JButton botonSalir;
    static Formatter salidaArch;
    ImageIcon logo = new ImageIcon(getClass().getResource("logo.png"));
    static int vidas;
    static int puntaje;

    public PantallaMenu() {
        setLayout(null);
        setTitle("Whack-A-Mole!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicializarComponentes();
        setSize(1200, 800);
        setVisible(true);
        this.getContentPane().setBackground(Color.black);
    }

    private void inicializarComponentes() {
        JLabel imagen = new JLabel();
        imagen.setBounds(100,100,550,550);
        imagen.setIcon(logo);
        add(imagen);

        botonInicio = new JButton("Nueva Partida");
        botonInicio.setBounds(700, 150, 300, 100);
        add(botonInicio);
        recuperarParametros();
        botonInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (puntaje != 0) {
                    int respuesta = JOptionPane.showConfirmDialog(null, "Se ha detectado una partida inconclusa, para continuarla presione si, para iniciar una nueva presione no.", "Partida inconclusa!", JOptionPane.YES_NO_OPTION);
                    if (respuesta == 0) {
                        new PantallaJuego(vidas, puntaje);
                    } else {
                        new PantallaJuego();
                    }
                } else {
                    new PantallaJuego();
                }

                setVisible(false);
            }
        });

        botonMarcador = new JButton("Puntuaciones");
        botonMarcador.setBounds(700, 300, 300, 100);
        add(botonMarcador);
        botonMarcador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PantallaMarcador();
                setVisible(false);
            }
        });
        botonSalir = new JButton("Salir");
        botonSalir.setBounds(700, 450, 300, 100);
        add(botonSalir);
        botonSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });

    }

    private static void recuperarParametros() {
        Scanner entradaArch;
        
        try {
            entradaArch = new Scanner(Paths.get("partida.txt"));
        } catch (Exception e) {
            System.err.println("Error al abrir archivo.");
            return;
        }

        try {
            while (entradaArch.hasNext()) {
                vidas = Integer.parseInt(entradaArch.nextLine());
                puntaje = Integer.parseInt(entradaArch.nextLine());
            }
            
        } catch (Exception e) {
            System.err.println("Error al leer archivo.");
            return;
        }

        if (entradaArch != null) {
            entradaArch.close();
        }
    }
}
