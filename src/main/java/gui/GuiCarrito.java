package gui;
import modelo.Carrito;
import modelo.Producto;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiCarrito extends JFrame {
    int cantidad;
    double precio;
    ArrayList<Producto> productos;
    PanelConImagen panelPrincipal;
    JLabel producto;
    JLabel labelPrecio;
    JLabel cPrecio;
    JLabel lblCantidad;
    JButton agregarAlCarrito;
    JSpinner contador;
    JComboBox listaItems;
    DefaultTableModel modeloTabla;

    JTable tabla;


        public GuiCarrito(String correo){
            productos=llenadoProductos();
            this.setTitle("GuiCarrito");
            this.setSize(new Dimension(500,300));
            this.setLocationRelativeTo(null);
            panelPrincipal= new PanelConImagen();
            panelPrincipal.setBackground("./data/images/carrito.png");
            panelPrincipal.setLayout(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);




            producto = new JLabel("producto:");
            producto.setBounds(30,20,60,20);

            listaItems = new JComboBox();
            listaItems.setBounds(90,20,250,20);
            listaItems.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cambiarPrecio();
                }
            });

            lblCantidad = new JLabel("cantidad:");
            lblCantidad.setBounds(30,50,60,10);

            contador = new JSpinner();
            contador.setBounds(87,50,60,25);
            contador.setModel(new SpinnerNumberModel(1,0,10,1));
            contador.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    cambiarPrecio();
                }
            });

            labelPrecio = new JLabel("precio:");
            labelPrecio.setBounds(350,20,60,20);

            cPrecio = new JLabel("$");
            cPrecio.setBounds(390,20,60,20);
            tabla = new JTable();





            agregarAlCarrito = new JButton("Agregar al carrito");
            agregarAlCarrito.setBounds(300,78,150,30);

            String[]nombres=nombres();
            DefaultComboBoxModel comboM= new DefaultComboBoxModel<>(nombres);
            listaItems.setModel(comboM);
            agregarAlCarrito= new JButton();
            agregarAlCarrito.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            panelPrincipal.add(agregarAlCarrito);
            panelPrincipal.add(producto);
            panelPrincipal.add(listaItems);
            panelPrincipal.add(lblCantidad);
            panelPrincipal.add(contador);
            panelPrincipal.add(labelPrecio);
            panelPrincipal.add(cPrecio);
            this.add(panelPrincipal);


        }
    private String[] nombres() {
            String[] nombres= new String[this.productos.size()];
        for (int i = 0; i <this.productos.size() ; i++) {
            nombres[i]=this.productos.get(i).getNombre();
        }
        return nombres;
    }

    private ArrayList<Producto> llenadoProductos() {
        Carrito c = new Carrito();
        ArrayList<Producto>productosA =c.consultarProductos();
        return  productosA;
    }
    public void cambiarPrecio(){
        this.precio=(productos.get(listaItems.getSelectedIndex()).getPrecio());
        this.cantidad=Integer.parseInt(contador.getValue()+"");
        cPrecio.setText(""+(this.precio*this.cantidad));
    }

    public static void main(String[] args) {
        GuiCarrito c = new GuiCarrito();
        c.setVisible(true);
    }
}
