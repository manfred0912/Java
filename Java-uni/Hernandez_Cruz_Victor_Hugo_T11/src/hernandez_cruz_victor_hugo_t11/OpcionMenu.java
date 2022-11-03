
package hernandez_cruz_victor_hugo_t11;
//enumeracon para las opciones del programa del consulta de cridto
public enum OpcionMenu {
    
    //declara el contenido del tipo enum
    SALDO_CLIENTES(1),
    SALDO_CERO(2),
    SALDO_CREDITO(3),
    SALDO_DEBITO(4),
    FIN(5);
    
     private final int valor;//opcion actual del menu
   //constructor 
   private OpcionMenu(int valor){
       this.valor = valor;
}

}