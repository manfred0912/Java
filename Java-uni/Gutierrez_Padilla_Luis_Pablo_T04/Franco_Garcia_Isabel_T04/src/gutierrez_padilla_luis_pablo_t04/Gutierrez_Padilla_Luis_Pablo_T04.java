package gutierrez_padilla_luis_pablo_t04;

import java.security.SecureRandom;

public class Gutierrez_Padilla_Luis_Pablo_T04 {

    public static void main(String[] args) { 

        SecureRandom numerosAleatorios = new SecureRandom();

        int frecuencia2 = 0;
        int frecuencia3 = 0;
        int frecuencia4 = 0;
        int frecuencia5 = 0;
        int frecuencia6 = 0;
        int frecuencia7 = 0;
        int frecuencia8 = 0;
        int frecuencia9 = 0;
        int frecuencia10 = 0;
        int frecuencia11 = 0;
        int frecuencia12 = 0;

        int numTiros = 3600000;

        for (int tiro = 1; tiro <= numTiros; tiro++) {
            int cara1 = 1 + numerosAleatorios.nextInt(6);

            int cara2 = 1 + numerosAleatorios.nextInt(6);

            int resultado = cara1 + cara2;

            switch (resultado) {
                case 2:
                    ++frecuencia2;
                    break;
                case 3:
                    ++frecuencia3;
                    break;
                case 4:
                    ++frecuencia4;
                    break;
                case 5:
                    ++frecuencia5;
                    break;
                case 6:
                    ++frecuencia6;
                    break;
                case 7:
                    ++frecuencia7;
                    break;
                case 8:
                    ++frecuencia8;
                    break;
                case 9:
                    ++frecuencia9;
                    break;
                case 10:
                    ++frecuencia10;
                    break;
                case 11:
                    ++frecuencia11;
                    break;
                case 12:
                    ++frecuencia12;
                    break;
            }
        }

        System.out.println("Cara\tFrec.\tFrec. relativa");
        System.out.printf("2 \t%d\t%.4f%n3\t%d\t%.4f%n4\t%d\t%.4f%n5\t%d\t%.4f%n6\t%d\t%.4f%n7\t%d\t%.4f%n8\t%d\t%.4f%n9\t%d\t%.4f%n10\t%d\t%.4f%n11\t%d\t%.4f%n12\t%d\t%.4f%n",
                frecuencia2, (float) frecuencia2 / numTiros,
                frecuencia3, (float) frecuencia3 / numTiros,
                frecuencia4, (float) frecuencia4 / numTiros,
                frecuencia5, (float) frecuencia5 / numTiros,
                frecuencia6, (float) frecuencia6 / numTiros,
                frecuencia7, (float) frecuencia7 / numTiros,
                frecuencia8, (float) frecuencia8 / numTiros,
                frecuencia9, (float) frecuencia9 / numTiros,
                frecuencia10, (float) frecuencia10 / numTiros,
                frecuencia11, (float) frecuencia11 / numTiros,
                frecuencia12, (float) frecuencia12 / numTiros
        );

    }

}
