
package solis_zavala_cassandra_geraldine_t08;

import javax.swing.JOptionPane;

public class Solis_Zavala_Cassandra_Geraldine_T08 {

    public static void main(String[] args) {
        
        String numeroConv = JOptionPane.showInputDialog("Convertidor de °C a °F. Ingrese el valor de °C:");

        int celsius = Integer.parseInt(numeroConv);
        int fahrenheit;
        
            fahrenheit=(int) ((celsius*1.8)+32);
    
        JOptionPane.showMessageDialog(null, "El resultado de la conversion es de: " + fahrenheit + "°F", "Convertidor °C a °F", JOptionPane.PLAIN_MESSAGE);
    }
}