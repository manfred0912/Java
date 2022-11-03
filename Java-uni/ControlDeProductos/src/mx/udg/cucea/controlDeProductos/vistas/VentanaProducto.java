
package mx.udg.cucea.controlDeProductos.vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import mx.udg.cucea.controlDeProductos.controlador.ControlDeProductos;
import mx.udg.cucea.controlDeProductos.modelo.Producto;


public class VentanaProducto extends JFrame {
    private JLabel etiquetaCodigo;
    private JTextField textFieldCodigo;
    
    private JLabel etiquetaNombre;
    private JTextField textFieldNombre;

    private JLabel etiquetaMarca;
    private JTextField textFieldMarca;

    private JLabel etiquetaDescripcion;
    private JTextField textFieldDescripcion;

    private JLabel etiquetaPrecio;
    private JTextField textFieldPrecio;

    private JLabel etiquetaCantidad;
    private JTextField textFieldCantidad;

    private JButton botonAceptar;
    private JButton botonCancelar;
    
    private VentanaPrincipal ventanaOrigen;
    private Producto productoAEditar;

    public VentanaProducto(VentanaPrincipal ventanaPrincipal, Producto productoSeleccionado){
        this(ventanaPrincipal);
        productoAEditar = productoSeleccionado;
        textFieldCodigo.setText(String.valueOf(productoAEditar.getCodigoDeBarras()));
        textFieldNombre.setText(productoAEditar.getNombre());
        textFieldMarca.setText(productoAEditar.getMarca());
        textFieldDescripcion.setText(productoAEditar.getDescripcion());
        textFieldPrecio.setText(String.valueOf(productoAEditar.getPrecio()));
        textFieldCantidad.setText(String.valueOf(productoAEditar.getCantidad()));
        
    }
    
    public VentanaProducto(VentanaPrincipal ventanaPrincipal) {
        ventanaOrigen = ventanaPrincipal;
        setLayout(null);
        inicializarComponentes();
        setSize(1200, 800);
        setVisible(true);
    }

    private void inicializarComponentes() {
        etiquetaCodigo = new JLabel("Codigo de Barras:");
        etiquetaCodigo.setBounds(50, 30, 550, 50);
        add(etiquetaCodigo);
 
        textFieldCodigo = new JTextField();
        textFieldCodigo.setBounds(450, 30, 650, 50);
        add(textFieldCodigo);
        
        etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setBounds(50, 100, 550, 50);
        add(etiquetaNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(450, 100, 650, 50);
        add(textFieldNombre);

        etiquetaMarca = new JLabel("Marca:");
        etiquetaMarca.setBounds(50, 170, 550, 50);
        add(etiquetaMarca);

        textFieldMarca = new JTextField();
        textFieldMarca.setBounds(450, 170, 650, 50);
        add(textFieldMarca);

        etiquetaDescripcion = new JLabel("Descripcion:");
        etiquetaDescripcion.setBounds(50, 240, 550, 50);
        add(etiquetaDescripcion);

        textFieldDescripcion = new JTextField();
        textFieldDescripcion.setBounds(450, 240, 650, 50);
        add(textFieldDescripcion);

        etiquetaPrecio = new JLabel("Precio:");
        etiquetaPrecio.setBounds(50, 310, 550, 50);
        add(etiquetaPrecio);

        textFieldPrecio = new JTextField();
        textFieldPrecio.setBounds(450, 310, 650, 50);
        add(textFieldPrecio);

        etiquetaCantidad = new JLabel("Cantidad:");
        etiquetaCantidad.setBounds(50, 380, 550, 50);
        add(etiquetaCantidad);

        textFieldCantidad = new JTextField();
        textFieldCantidad.setBounds(450, 380, 650, 50);
        add(textFieldCantidad);

        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(400, 600, 200, 100);
        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ventanaOrigen.setVisible(true);
                Producto productoNuevo = new Producto();
                String codigo = textFieldCodigo.getText();
                productoNuevo.setCodigoDeBarras(Long.parseLong(codigo));
                String nombre = textFieldNombre.getText();
                productoNuevo.setNombre(nombre);
                String marca = textFieldMarca.getText();
                productoNuevo.setMarca(marca);
                String descripcion = textFieldDescripcion.getText();
                productoNuevo.setDescripcion(descripcion);
                String precio = textFieldPrecio.getText();
                productoNuevo.setPrecio(Double.parseDouble(precio));
                String cantidad = textFieldCantidad.getText();
                productoNuevo.setCantidad(Integer.parseInt(cantidad));
                if(productoAEditar != null){
                    ControlDeProductos.editarProducto(productoAEditar, productoNuevo);
                }
                else{
                ControlDeProductos.crearProducto(productoNuevo);    
                }
                
                ventanaOrigen.refrescarLista();
            }
        });
        add(botonAceptar);

        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(650, 600, 200, 100);
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ventanaOrigen.setVisible(true);
            }
        });
        add(botonCancelar);
    }

}