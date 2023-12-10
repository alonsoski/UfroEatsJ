package gui;

import model.Carrito;
import model.Producto;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCarrito extends JFrame implements ActionListener, ListSelectionListener {

    JList<Producto> productosCarrito;
    DefaultListModel<Producto> model;
    JButton botonPagar, botonEliminar;
    JPanel panelBotones;
    Carrito carrito;

    VentanaCarrito(Carrito carrito){

        this.carrito = carrito;

        model = new DefaultListModel<>();
        productosCarrito = new JList<>(model);

        for (Producto producto : carrito.getProductosCarrito()) {
            model.addElement(producto);
        }

        botonPagar = new JButton("Pagar");
        botonPagar.setFont(new Font("Comic Sans MS",Font.BOLD,10));
        botonPagar.setBounds(1010,10,120,50);
        botonPagar.addActionListener(this);

        botonEliminar = new JButton("Eliminar");
        botonEliminar.setFont(new Font("Comic Sans MS",Font.BOLD,10));
        botonEliminar.setBounds(1010,10,120,50);
        botonEliminar.addActionListener(this);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        container.add(new JScrollPane(productosCarrito), BorderLayout.CENTER);

        panelBotones = new JPanel();
        panelBotones.add(botonEliminar);
        panelBotones.add(botonPagar);
        container.add(panelBotones, BorderLayout.SOUTH);



        this.setTitle("Carrito de compras");
        //this.add();
        //this.add();
        //this.add();
        //this.setLayout(null);
        this.setSize(600,420);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==botonPagar){

            carrito.vaciarCarrito();
            model.clear();
            this.dispose();
            //aqui esto quedo asi nomas porque nunca decidimos en que forma se pagaba
            JOptionPane.showMessageDialog(null,"Gracias por su compra","Pago Realizado",JOptionPane.QUESTION_MESSAGE);
        }

        if (e.getSource()==botonEliminar){

            int indiceSeleccionado = productosCarrito.getSelectedIndex();

            if (indiceSeleccionado != -1) {
                carrito.quitarProducto(indiceSeleccionado);
                model.removeElementAt(indiceSeleccionado);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un producto para eliminar!", "ERROR CRITICO", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
