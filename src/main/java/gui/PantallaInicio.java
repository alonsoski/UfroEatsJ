package gui;

import model.Carrito;
import model.Producto;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PantallaInicio extends JFrame implements ActionListener, FocusListener, ListSelectionListener {

    ImageIcon fondo, iconoUE, iconoCarrito;
    JLabel label1, label2, labelProducto;
    JLayeredPane layeredPane;
    JTextField idUsuario;
    JPasswordField contrasenia;
    JButton botonIngresar, botonRegistrarse, botonCarrito, botonHistorial, botonAgregar;
    JPanel panel1, panel2, panel3;
    JComboBox cantidad;
    JList<Producto> listaProductos;
    DefaultListModel<Producto> model;
    JSplitPane splitPane;
    Carrito carrito;
    VentanaCarrito ventanaCarrito;
    VentanaRegistro ventanaRegistro;
    VentanaHistorial ventanaHistorial;

    public PantallaInicio(){

        carrito = new Carrito();

        fondo = new ImageIcon("bg.png");
        iconoUE = new ImageIcon("u.png");
        iconoCarrito = new ImageIcon("carrito.png");

        Integer[] cantidades = {1,2,3,4,5,6,7,8,9,10};
        cantidad = new JComboBox<>(cantidades);
        cantidad.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        cantidad.setBounds(310,420,100,50);

        botonIngresar = new JButton("Ingresar");
        botonIngresar.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        botonIngresar.setBounds(290,500,120,50);
        botonIngresar.addActionListener(this);

        botonRegistrarse = new JButton("Registrarse");
        botonRegistrarse.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        botonRegistrarse.setBounds(560,610,120,50);
        botonRegistrarse.addActionListener(this);

        botonCarrito = new JButton("Carrito");
        //botonCarrito.setIcon(iconoCarrito);
        botonCarrito.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        botonCarrito.setBounds(1140,10,120,50);
        botonCarrito.addActionListener(this);

        botonHistorial = new JButton("Historial de Pedidos");
        botonHistorial.setFont(new Font("Comic Sans MS",Font.BOLD,10));
        botonHistorial.setBounds(1010,10,120,50);
        botonHistorial.addActionListener(this);

        botonAgregar = new JButton("Agregar al carro");
        botonAgregar.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        botonAgregar.setBounds(130,420,170,50);
        botonAgregar.setEnabled(false);
        botonAgregar.addActionListener(this);


        label1 = new JLabel("", fondo,JLabel.CENTER);
        label1.setBounds(0,0,1280,720);
        //label1.setIcon(background);

        label2 = new JLabel("", iconoUE,JLabel.CENTER);
        label2.setBounds(200,30,300,300);

        labelProducto = new JLabel("hertsthrew");
        labelProducto.setFont(new Font("Comic Sans MS",Font.PLAIN,30));
        //labelProducto.setBackground(Color.BLUE);
        //labelProducto.setOpaque(true);
        labelProducto.setBounds(100,10,900,390);

        idUsuario = new JTextField("usuario");
        idUsuario.setFont(new Font("Comic Sans MS",Font.PLAIN,27));
        idUsuario.addFocusListener(this);
        idUsuario.setBounds(160,370,390,50);


        contrasenia = new JPasswordField("contrasenia");
        contrasenia.addFocusListener(this);
        contrasenia.setBounds(160,430,390,50);

        panel1 = new JPanel();
        panel1.setBounds(0,0,1280,720);
        panel1.setLayout(null);
        panel1.add(botonCarrito);
        panel1.add(botonHistorial);


        panel2 = new JPanel();
        panel2.setBackground(new Color(230,250,255));
        panel2.setBounds(290,0,700,720);
        panel2.setLayout(null);
        panel2.add(label2);
        panel2.add(botonIngresar);
        panel2.add(idUsuario);
        panel2.add(contrasenia);
        panel2.add(botonRegistrarse);

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.add(labelProducto);
        panel3.add(botonAgregar);
        panel3.add(cantidad);
        //panel3.setBackground(Color.BLACK);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,1280,720);
        layeredPane.add(label1, Integer.valueOf(0));
        layeredPane.add(panel2, Integer.valueOf(1));

        this.setTitle("UFRO Eats");
        this.add(layeredPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(iconoUE.getImage());
        this.setSize(1280,720);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()== botonRegistrarse){
            if (ventanaRegistro == null || !ventanaRegistro.isVisible()){
                ventanaRegistro = new VentanaRegistro();
            }
        }

        if (e.getSource()== botonIngresar) {

            listaProductos = new JList<>();
            listaProductos.addListSelectionListener(this);
            model = new DefaultListModel<>();
            listaProductos.setModel(model);
            listaProductos.setFont(new Font("Comic Sans MS",Font.PLAIN,20));

            // aqui se supone que deberia ir un for para ir llenando la lista, por mientras puse dos productos para probar
            model.addElement(new Producto("Manzana", "una manzana roja", 55, 300));
            model.addElement(new Producto("Naranja", "jugosa", 57, 200));


            splitPane = new JSplitPane();
            splitPane.setBounds(0,70,1280,650);
            splitPane.setLeftComponent(new JScrollPane(listaProductos));
            splitPane.setRightComponent(panel3);


            panel1.add(splitPane);
            layeredPane.add(panel1, Integer.valueOf(2));
            panel2.setVisible(false);

        }

        if (e.getSource()==botonCarrito){
            if (ventanaCarrito == null || !ventanaCarrito.isVisible()){
                ventanaCarrito = new VentanaCarrito(carrito);
            }
        }

        if (e.getSource()==botonAgregar){

            carrito.agregarProducto(new Producto(listaProductos.getSelectedValue(), cantidad.getSelectedIndex()+1));

        }

    }

    @Override
    public void focusGained(FocusEvent e) {
        if(idUsuario.getText().equals("usuario")){
            idUsuario.setText("");
        }else if(contrasenia.getText().equals("contrasenia")){
            contrasenia.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(idUsuario.getText().isEmpty()){
            idUsuario.setText("usuario");
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

        Producto seleccionado = listaProductos.getSelectedValue();

        if (seleccionado != null){
            String infoProducto = "<html><b>Nombre:</b>" + seleccionado.getNombre() + "<br><b>Descripción:</b> " + seleccionado.getDescripcion()
                    + "<br><b>Precio:</b> $" + seleccionado.getPrecio() + "<br><b>Stock:</b>  " + seleccionado.getCantidad()+ "</html>";
            labelProducto.setText(infoProducto);

            botonAgregar.setEnabled(true);
        } else {
            botonAgregar.setEnabled(false);
        }


    }
}
