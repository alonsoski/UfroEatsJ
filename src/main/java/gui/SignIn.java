package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class SignIn extends JFrame {

    public SignIn() {
        this.setVisible(true);
        this.setSize(720, 480);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        PanelConImagen panelPrincipal = new PanelConImagen();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground("./data/images/fondoCrearCuenta.png");
        JTextField correo= new JTextField(15);
        correo.setText("Correo");
        correo.setBounds(200,300,300,20);
        JTextField contra= new JTextField(15);
        contra.setText("Contraseña ");
        contra.setBounds(200,325,300,20);
        JTextField contra2= new JTextField(15);
        contra2.setText("Repetir Contraseña");
        contra2.setBounds(200,350,300,20);

        JButton botonRegistrar=new JButton("Registrar");
        botonRegistrar.setBounds(305,376,90,20);

        JButton botonIngresar=new JButton("Ingresar");
        botonIngresar.setBounds(390,400,90,20);

        panelPrincipal.add(botonRegistrar);
        panelPrincipal.add(botonIngresar);
        panelPrincipal.add(correo);
        panelPrincipal.add(contra);
        panelPrincipal.add(contra2);


        this.add(panelPrincipal);
    }

    public static void main(String[] args) {
        SignIn l = new SignIn();
    }


}