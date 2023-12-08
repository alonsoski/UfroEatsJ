package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.*;

import modelo.SocketCliente;
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
        botonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SocketCliente s = new SocketCliente(8888);
                if (correo.getText().equals("")|| contra.getText().equals("")){
                    JOptionPane.showMessageDialog(Login.this,"Escriba su correo y contraseña.","error de autenticacion",JOptionPane.ERROR_MESSAGE);
                }else {
                    String peticion = s.enviarYRecibir("IS/"+correo.getText()+"/"+contra.getText());
                    if (peticion.equals("true")){
                        //home(correo);
                        System.out.println("has ingresado");
                    } else if (peticion.equals("errorServidor")) {
                        JOptionPane.showMessageDialog(Login.this,"Hay problemas con el servidor.","error de conexion",JOptionPane.ERROR_MESSAGE);
                    } else {
                        System.out.println("Nombre o contraseña incorrectos");
                        JOptionPane.showMessageDialog(Login.this,"nombre o contraseña incorrectos.","error de autenticacion",JOptionPane.ERROR_MESSAGE);
                        correo.setText("");
                        contra.setText("");
                    }
                }
            }
        });

        JButton botonRegistrar=new JButton("Registrar");
        botonRegistrar.setBounds(390,400,90,20);
        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignIn sign = new SignIn();
                dispose();
            }
        });


        JButton botonVolver=new JButton("Volver");
        botonVolver.setBounds(30,20,90,20);
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio i = new Inicio();
                i.setVisible(true);
                dispose();

            }
        });

        panelPrincipal.add(botonVolver);
        panelPrincipal.add(botonIngresar);
        panelPrincipal.add(botonRegistrar);
        panelPrincipal.add(correo);
        panelPrincipal.add(contra);

        this.add(panelPrincipal);
    }

    public static void main(String[] args) {
        Login l = new Login();
    }


}