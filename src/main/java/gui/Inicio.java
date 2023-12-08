package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame {

    public Inicio() {

        this.setSize(720, 480);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        PanelConImagen panelPrincipal = new PanelConImagen();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground("./data/images/fondoInicio.png");


        JButton botonIngresar=new JButton("Ingresar");
        botonIngresar.setBounds(262,234,187,43);
        //botonIngresar.setVisible(false);
        JButton botonRegistrar=new JButton("Registrar");

        botonRegistrar.setBounds(276,303,151,27);
        //botonRegistrar.setVisible(false);



        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SignIn sign = new SignIn();
                dispose();

            }
        });
        botonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                dispose();
            }
        });


        panelPrincipal.add(botonRegistrar);
        panelPrincipal.add(botonIngresar);


        this.add(panelPrincipal);
    }

    public static void main(String[] args) {
        Inicio l = new Inicio();
        l.setVisible(true);
    }


}