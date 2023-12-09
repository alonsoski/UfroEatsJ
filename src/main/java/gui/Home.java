package gui;
import modelo.SocketCliente;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Home extends JFrame {
    String nombreUsuario;
    PanelConImagen panelPrincipal;
    JButton botonNuevoPedido;
    JButton botonHistorial;
    JButton terminarSesion;
    public Home(){
        setupPrincipal("q@ufromail.cl");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Home(String correo) {
        setupPrincipal(correo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void setupPrincipal(String correo){
        this.setTitle("UfroEats");
        this.setSize(720, 480);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        panelPrincipal = new PanelConImagen();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground("./data/images/fondoHome.png");


        botonNuevoPedido=new JButton("Nuevo Pedido");
        botonNuevoPedido.setBounds(213,167,275,43);
        botonNuevoPedido.setBorder(new RoundBorder(25));
        botonNuevoPedido.setContentAreaFilled(false);
        botonNuevoPedido.setBorderPainted(false);
        botonNuevoPedido.setFocusPainted(false);


        botonHistorial=new JButton("Historial de pedidos");
        botonHistorial.setBounds(213,246,275,43);
        botonHistorial.setBorder(new RoundBorder(25));
        botonHistorial.setContentAreaFilled(false);
        botonHistorial.setBorderPainted(false);
        botonHistorial.setFocusPainted(false);


        terminarSesion= new JButton("Cerrar sesión");
        terminarSesion.setBounds(290,298,120,30);
        terminarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio i = new Inicio();
                i.setVisible(true);
                dispose();
            }
        });

        botonHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botonNuevoPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        panelPrincipal.add(botonHistorial);
        panelPrincipal.add(botonNuevoPedido);
        panelPrincipal.add(terminarSesion);

        this.add(panelPrincipal);

    }

    public static void main(String[] args) {
    Home h = new Home();
    h.setVisible(true);
    }

    class RoundBorder implements Border {

        private int radio;

        RoundBorder(int radius) {
            this.radio = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radio+1, this.radio+1, this.radio+2, this.radio);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radio, radio);
        }

}
}
