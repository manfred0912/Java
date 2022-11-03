package mx.udg.cucea.controlDeProductos.modelo;

/**
 *
 * @author jjrob
 */
public class Producto {
    private long codigoDeBarras;
    private String nombre;
    private String marca;
    private String descripcion;
    private double precio;
    private int cantidad;

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(long codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }
    
    @Override
    public String toString(){
        return codigoDeBarras + ": " + nombre + " - "+ descripcion;
    }
    
}