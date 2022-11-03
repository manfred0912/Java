package gestionpagosempresa_22a;

/**
 * Factura simplificada que sólo contiene un artículo.
 * 
 */
public class Factura implements Pagable {
    // Campos
    private String numFactura; // Número de factura
    private String descArticulo; // Descripción del artículo
    private int numArticulos; // Número de artículos
    private double precioUnitario; // Precio unitario del artículo
    
    // Constructor
    public Factura(String numFactura, String descArticulo, int numArticulos, 
            double precioUnitario) {
        this.numFactura = numFactura;
        this.descArticulo = descArticulo;
        this.numArticulos = numArticulos;
        this.precioUnitario = precioUnitario;
    }
    
    // Métodos de acceso

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public String getDescArticulo() {
        return descArticulo;
    }

    public void setDescArticulo(String descArticulo) {
        this.descArticulo = descArticulo;
    }

    public int getNumArticulos() {
        return numArticulos;
    }

    public void setNumArticulos(int numArticulos) {
        this.numArticulos = numArticulos;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    // Implementación del método abstracto de la interfaz Pagable
    @Override
    public double calcularPago() {
        return numArticulos * precioUnitario;
    }
    
    // Sobrescritura del método toString()

    @Override
    public String toString() {
        return "Número de factura: " + numFactura + 
                "\nDescripción del artículo: " + descArticulo + 
                "\nNúmero de artículos: " + numArticulos + 
                "\nPrecio unitario: " + String.format("$%.2f" ,precioUnitario) + "\n";
    }
    
    
}
