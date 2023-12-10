package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistro extends JFrame implements ActionListener {

    JTextField nuevoUsuario, nuevaContrasenia;
    JLabel labelUsuario, labelContrasenia;
    JButton crearCuenta;

    VentanaRegistro(){

        labelUsuario = new JLabel("Ingrese su correo:");
        labelUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        labelUsuario.setBounds(50, 50, 200, 30);

        labelContrasenia = new JLabel("Establezca una contraseña:");
        labelContrasenia.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        labelContrasenia.setBounds(50, 120, 200, 30);

        crearCuenta = new JButton("Crear cuenta");
        crearCuenta.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        crearCuenta.setBounds(250, 200, 200, 50);
        crearCuenta.addActionListener(this);

        nuevoUsuario = new JTextField();
        nuevoUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 27));
        nuevoUsuario.setBounds(250, 50, 300, 50);

        nuevaContrasenia = new JTextField();
        nuevaContrasenia.setFont(new Font("Comic Sans MS", Font.PLAIN, 27));
        nuevaContrasenia.setBounds(250, 120, 300, 50);


        this.setTitle("Registro");
        this.add(labelContrasenia);
        this.add(labelUsuario);
        this.add(nuevoUsuario);
        this.add(nuevaContrasenia);
        this.add(crearCuenta);
        this.setLayout(null);
        this.setSize(600,350);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
