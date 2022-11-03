public class Main {
    public static void main(String[] args) {
        int valor = 1;
        valor++; // = 2
        ++valor; // = 3
// en este ejemplo funcionan igual, la cosa cambia en expresiones:
        int otroValor = 50;
        int otroNumero;
        otroNumero = otroValor + valor++;
        System.out.println(otroNumero);
        System.out.println(valor);
        otroNumero = otroValor + ++valor;
        System.out.println(otroNumero);

    }
}