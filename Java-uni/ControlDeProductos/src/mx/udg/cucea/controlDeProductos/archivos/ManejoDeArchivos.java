package mx.udg.cucea.controlDeProductos.archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import mx.udg.cucea.controlDeProductos.modelo.Producto;

/**
 *
 * @author jjrob
 */
public class ManejoDeArchivos {
    public static final String CARPETA = "productos/";
    
    private static void crearCarpetaSiNoExiste(){
        File carpeta = new File(CARPETA);
        if(!carpeta.exists()){
            carpeta.mkdir();
        }
    }
    public static void crearProducto(Producto p){
        crearCarpetaSiNoExiste();
        try {
            FileWriter escritor = new FileWriter(CARPETA + p.getCodigoDeBarras());
            escritor.append(p.getNombre());
            escritor.append(System.lineSeparator());
            escritor.append(p.getMarca());
            escritor.append(System.lineSeparator());
            escritor.append(p.getDescripcion());
            escritor.append(System.lineSeparator());
            escritor.append(String.valueOf(p.getPrecio()));
            escritor.append(System.lineSeparator());
            escritor.append(String.valueOf(p.getCantidad()));
            escritor.close();
        } catch (IOException ex) {
            System.out.println("no pude crear el archivo:" + ex.getMessage());
        }
    }
    public static void editarProducto(Producto productoOriginal, 
            Producto productoModificado){
        crearCarpetaSiNoExiste();
        File archivoOriginal = new File(CARPETA + productoOriginal.getCodigoDeBarras());
        if (archivoOriginal.exists()){
            if (productoOriginal.getCodigoDeBarras() != 
                    productoModificado.getCodigoDeBarras()){
                borrarProducto(productoOriginal);
            }

            crearProducto(productoModificado);
        }
        else {
            System.out.println("no puedo editar el archivo porque no existe");
        }
    }
    public static void borrarProducto(Producto p){
        crearCarpetaSiNoExiste();
        File archivoABorrar = new File(CARPETA + p.getCodigoDeBarras());
        if(archivoABorrar.exists()){
            archivoABorrar.delete();
        }
    }
    private static Producto leerArchivo(String nombreDelArchivo){
        crearCarpetaSiNoExiste();
        Producto p = new Producto();
        try {
            List<String> lineas = Files.readAllLines(
                    Paths.get(CARPETA + nombreDelArchivo));
            p.setCodigoDeBarras(Long.parseLong(nombreDelArchivo));
            p.setNombre(lineas.get(0));
            p.setMarca(lineas.get(1));
            p.setDescripcion(lineas.get(2));
            p.setPrecio(Double.parseDouble(lineas.get(3)));
            p.setCantidad(Integer.parseInt(lineas.get(4)));
        } catch (IOException ex) {
            System.out.println("no pude leer el archivo porque:"+ex.getMessage());
        }
        return p;
    }
    
    public static ArrayList<Producto> leerProductos(){
        crearCarpetaSiNoExiste();
        ArrayList<Producto> productos = new ArrayList<>();
        File carpeta = new File(CARPETA);
        String[] nombresDeArchivos = carpeta.list();
        for(String nombreDeArchivo: nombresDeArchivos){
            Producto producto = leerArchivo(nombreDeArchivo);
            productos.add(producto);
        }
        return productos;
    }

}
