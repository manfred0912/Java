package mx.udg.cucea.controlDeProductos.controlador;

import java.util.ArrayList;
import mx.udg.cucea.controlDeProductos.archivos.ManejoDeArchivos;
import mx.udg.cucea.controlDeProductos.modelo.Producto;
import mx.udg.cucea.controlDeProductos.vistas.VentanaPrincipal;

public class ControlDeProductos {

    public static ArrayList<Producto> leerProductos() {
        return ManejoDeArchivos.leerProductos();
    }

    public static void crearProducto(Producto p) {
        ManejoDeArchivos.crearProducto(p);
    }

    public static void borrarProducto(Producto p) {
        ManejoDeArchivos.borrarProducto(p);
    }

    public static void editarProducto(Producto productoOriginal, Producto productoNuevo) {
        ManejoDeArchivos.editarProducto(productoOriginal, productoNuevo);
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }

}
