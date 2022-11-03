package gutierrez_padilla_luis_pablo_t08;

import javax.swing.JOptionPane;

public class Gutierrez_Padilla_Luis_Pablo_T08 {

    public static void main(String[] args) {
        String centigrados = JOptionPane.showInputDialog(null, "Ingrese los grados centigrados a convertir: ", "Calculadora de grados", JOptionPane.PLAIN_MESSAGE);

        float c = Float.parseFloat(centigrados);
        float fahrenheit = (float) ((c * 1.8) + 32);
    
        JOptionPane.showMessageDialog(null, "El resultado de la conversion es de: " + fahrenheit + "°F", "Calculadora de grados", JOptionPane.INFORMATION_MESSAGE);
    }
}