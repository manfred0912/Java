package gutierrez_padilla_luis_pablo_pf;

import static gutierrez_padilla_luis_pablo_pf.Gutierrez_Padilla_Luis_Pablo_PF.puntajes;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class PantallaMarcador extends JFrame {

    private DefaultListModel<Jugadores> modelo;
    JList marcadores;
    private JButton botonMenu;
    private JButton botonSalir;

    public PantallaMarcador() {
        recuperarObjetos();
        setTitle("Puntuaciones");
        this.setLayout(null);
        inicializarComponentes();
        lista();
        setSize(1100, 800);
        this.getContentPane().setBackground(Color.black);
        setVisible(true);
        guardarObjetos();
    }

    private void inicializarComponentes() {
        marcadores = new JList();
        modelo = new DefaultListModel<>();
        marcadores.setModel(modelo);

        marcadores.setBounds(100, 100, 500, 550);
        add(marcadores);

        botonMenu = new JButton("Menu principal ...");
        botonMenu.setBounds(700, 150, 300, 100);
        botonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PantallaMenu();
                setVisible(false);
            }
        });
        add(botonMenu);

        botonSalir = new JButton("Salir");
        botonSalir.setBounds(700, 450, 300, 100);
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(botonSalir);
    }

    private static void guardarObjetos() {
        Formatter salidaArch;

        // Crear y abrir archivo
        try {
            salidaArch = new Formatter("puntajes.txt");
        } catch (Exception e) {
            System.err.println("Error al crear archivo.");
            return;
        }

        // Escribir en el archivo
        try {
            // Recorrer todo el arreglo
            for (int i = 0; i < puntajes.size(); ++i) {
                // Obtener referencia al objeto i-ésimo en el arreglo
                Jugadores j = puntajes.get(i);
                // Guardar el valor de cada campo en el archivo
                salidaArch.format("%s%n", j.getPuntaje());
                salidaArch.format("%s%n", j.getNombre());
            }
        } catch (Exception e) {
            System.err.println("Error al escribir en el archivo.");
            return;
        }

        // Cerrar el archivo
        if (salidaArch != null) {
            salidaArch.close();
        }

    }

    private static void recuperarObjetos() {
        Scanner entradaArch;
        int puntos = 0;

        try {
            entradaArch = new Scanner(Paths.get("puntajes.txt"));
        } catch (Exception e) {
            System.err.println("Error al abrir archivo.");
            return;
        }

        try {
            while (entradaArch.hasNext()) {
                Jugadores j = new Jugadores();
                j.setPuntaje(Integer.parseInt(entradaArch.nextLine()));
                j.setNombre(entradaArch.nextLine());

                puntajes.add(j);
            }
        } catch (Exception e) {
            System.err.println("Error al leer archivo.");
            return;
        }

        if (entradaArch != null) {
            entradaArch.close();
        }

    }

    private void lista(){
        modelo.clear();
        for(Jugadores jugador : puntajes){
            modelo.addElement(jugador);
        }
}
}
