package Rodriguez_Arambula_Eveline_Angelina_PF;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Rodriguez_Arambula_Eveline_Angelina_PF extends JFrame implements ActionListener {

    private JTextField edt1, edt2;
    private JLabel lb11, lbl2, lbl4, imagenna1, imagenna2, imagenna3, imagenna4, imagenna5, imagenna6, imagenna7;
    private JLabel imagena1, imagena2, imagena3, imagena4, imagena5, imagena6, imagena7;
    private JButton btnBuscar, btnNuevo, btnSalir;
    private String palabra;
    private String[] Lineas = new String[10];
    public int contador = 0, correctas = 0, intentos = 0;

    public Rodriguez_Arambula_Eveline_Angelina_PF() {
        super("Juego del Ahorcado");
        lb11 = new JLabel("Palabra: ");
        lb11.setBounds(100, 20, 100, 20);
        lbl2 = new JLabel("Letra: ");
        lbl2.setBounds(100, 90, 100, 20);
        lbl4 = new JLabel(" ");
        lbl4.setBounds(140, 40, 200, 20);

        edt1 = new JTextField("");
        edt1.setEditable(false);
        edt1.setBounds(170, 20, 200, 20);
        edt2 = new JTextField("");
        edt2.setBounds(250, 90, 80, 20);

        btnBuscar = new JButton("Verificar");
        btnBuscar.setBounds(200, 120, 100, 20);
        btnNuevo = new JButton("Nueva Palabra");
        btnNuevo.setBounds(200, 120, 100, 20);
        btnSalir = new JButton("Finalizar");
        btnSalir.setBounds(200, 120, 100, 20);

        btnBuscar.addActionListener(this);
        btnNuevo.addActionListener(this);
        btnSalir.addActionListener(this);

        Icon imagena1 = new ImageIcon("a1.png");
        imagenna1 = new JLabel(imagena1);
        imagenna1.setBounds(30, 110, 160, 170);

        Icon imagena2 = new ImageIcon("a2.png");
        imagenna2 = new JLabel(imagena2);
        imagenna2.setBounds(30, 110, 160, 170);

        Icon imagena3 = new ImageIcon("a3.png");
        imagenna3 = new JLabel(imagena3);
        imagenna3.setBounds(30, 110, 160, 170);

        Icon imagena4 = new ImageIcon("a4.png");
        imagenna4.setBounds(30, 110, 160, 170);

        Icon imagena5 = new ImageIcon("a5.png");
        imagenna5 = new JLabel(imagena5);
        imagenna5.setBounds(30, 110, 160, 170);

        Icon imagena6 = new ImageIcon("a6.png");
        imagenna6 = new JLabel(imagena6);
        imagenna6.setBounds(30, 110, 160, 170);

        Icon imagena7 = new ImageIcon("a7.png");
        imagenna7 = new JLabel(imagena7);
        imagenna7.setBounds(30, 110, 160, 170);

        imagenes();
        crearPalabra();

        getContentPane().add(lb11);
        getContentPane().add(lbl2);
        getContentPane().add(lbl4);
        getContentPane().add(edt1);
        getContentPane().add(edt2);
        getContentPane().add(btnBuscar);
        getContentPane().add(btnNuevo);
        getContentPane().add(btnSalir);

        getContentPane().setLayout(null);
        setSize(400, 350);
        setVisible(true);
    }

    private void crearPalabra() {

        String[][] lista = {{"Tigre", "Panda", "Hipopotamo", "Cocodrilo", "Serpiente", "Murcielago", "Guacamaya", "Puma", "Jirafa", "Tarantula"},
        {"Manzana", "Coco", "Lima", "Sandia", "Melon", "Pepino", "Ciruela", "kiwi", "Jicama", "Durazno", "Uva"}};

        int categoria = (int) (Math.random() * 3);
        int pala = (int) (Math.random() * 7);
        palabra = lista[categoria][pala];
        if (categoria == 0);
        {
            lbl4.setText("Animales");
        }
        if (categoria == 0);
        {
            lbl4.setText("Frutas");
        }
        for (int j = 0; j < palabra.length(); j++) {
            contador++;
            Lineas[j] = "_";
            edt1.setText(edt1.getText() + Lineas[j] + " ");
        }
    }

    private void imagenes() {

        if (intentos == 1) {
            imagenna1.setVisible(true);
        }
        if (intentos == 2) {
            imagenna2.setVisible(true);
        }
        if (intentos == 3) {
            imagenna3.setVisible(true);
        }
        if (intentos == 4) {
            imagenna4.setVisible(true);
        }
        if (intentos == 5) {
            imagenna5.setVisible(true);
        }
        if (intentos == 6) {
            imagenna6.setVisible(true);
        }
        if (intentos == 7) {
            imagenna7.setVisible(true);
        }
        if (intentos == 1) {
            imagenna1.setVisible(false);
            getContentPane().add(imagenna1);
        }
        if (intentos == 2) {
            imagenna2.setVisible(false);
            getContentPane().add(imagenna2);
        }
        if (intentos == 3) {
            imagenna3.setVisible(false);
            getContentPane().add(imagenna3);
        }
        if (intentos == 4) {
            imagenna4.setVisible(false);
            getContentPane().add(imagenna4);
        }
        if (intentos == 5) {
            imagenna5.setVisible(false);
            getContentPane().add(imagenna5);
        }
        if (intentos == 6) {
            imagenna6.setVisible(false);
            getContentPane().add(imagenna6);
        }
        if (intentos == 7) {
            imagenna7.setVisible(false);
            getContentPane().add(imagenna7);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnSalir)) {
            System.exit(0);
        }
        if (e.getSource().equals(btnBuscar)) {
            char letra = caracter(edt2.getText());
            String letra2 = (edt2.getText());
            String temp = edt1.getText();
            intentos++;

            for (int i = 0; i < palabra.length(); i++) {

                if (letra == palabra.charAt(i)) {
                    Lineas[i] = letra2;
                    correctas++;
                    edt1.setText(null);
                    intentos = intentos - 1;

                    for (int j = 0; j < palabra.length(); j++) {

                        edt1.setText(edt1.getText() + Lineas[j] + " ");
                    }
                }
            }
        }

        imagenes();
        if (correctas == contador) {
            JOptionPane.showMessageDialog(null, "¡Bien Hecho! :D ");
            edt2.setEditable(false);
        }
        if (intentos == 6) {
            JOptionPane.showMessageDialog(null, "¡Perdiste Men! D: ");
            edt2.setEditable(false);
        }
        edt2.setText(null);

        if (e.getSource().equals(btnNuevo)) {
            edt1.setText(null);
            contador = 0;
            crearPalabra();
            intentos = 0;
            correctas = 0;
            edt2.setEditable(true);

            imagenna1.setVisible(true);
            imagenna2.setVisible(true);
            imagenna3.setVisible(true);
            imagenna4.setVisible(true);
            imagenna5.setVisible(true);
            imagenna6.setVisible(true);
            imagenna7.setVisible(true);
        }
    }

    public static void main(String[] args) {
        Rodriguez_Arambula_Eveline_Angelina_PF x = new Rodriguez_Arambula_Eveline_Angelina_PF();
    }

    private char caracter(String text) {
        return text.charAt(0);
    }
}
