package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class Login extends JFrame {

    public Login() {
        this.setVisible(true);
        this.setSize(720, 480);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        PanelConImagen panelPrincipal = new PanelConImagen();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground("./data/images/fondoIngresar.png");
        JTextField correo= new JTextField(15);
        correo.setText("Correo");
        correo.setBounds(200,320,300,20);
        JTextField contra= new JTextField(15);
        contra.setText("Contraseña");
        contra.setBounds(200,350,300,20);


        JButton botonIngresar=new JButton("Ingresar");
        botonIngresar.setBounds(305,376,90,20);

        panelPrincipal.add(botonIngresar);
        panelPrincipal.add(correo);
        panelPrincipal.add(contra);


        this.add(panelPrincipal);
    }

    public static void main(String[] args) {
        Login l = new Login();
    }


}