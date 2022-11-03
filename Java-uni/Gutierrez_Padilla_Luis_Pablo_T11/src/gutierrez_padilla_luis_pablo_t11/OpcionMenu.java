package gutierrez_padilla_luis_pablo_t11;

public enum OpcionMenu {
    // declara el contenido del tipo enum
        SALDO_GENERAL(1),
        SALDO_CERO(2),
        SALDO_CREDITO(3),
        SALDO_DEBITO(4),
        FIN(5);

        private final int valor; // opción actual del menú

        // constructor
        private OpcionMenu(int valor) {
            this.valor = valor;
        }
}
