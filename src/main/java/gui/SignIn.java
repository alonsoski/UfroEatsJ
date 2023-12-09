package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.SocketCliente;

public class SignIn extends JFrame {

    public SignIn() {
        this.setVisible(true);
        this.setSize(720, 480);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("crear usuario");
        PanelConImagen panelPrincipal = new PanelConImagen();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground("./data/images/fondoCrearCuenta.png");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



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

        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contra.getText().equals(contra2.getText())){
                    if(!correoInstitucional(correo.getText())) {
                        JOptionPane.showMessageDialog(SignIn.this,"Este correo no es valido, debe ser institucional.","correo invalido",JOptionPane.ERROR_MESSAGE);
                    }else {
                        SocketCliente s = new SocketCliente(8888);
                        String peticion= s.enviarYRecibir("CU1/"+correo.getText()+"/"+contra.getText());
                        if (peticion.equals("true")){
                            s.enviar("CU2/"+correo.getText()+"/"+contra.getText());
                            JOptionPane.showMessageDialog(SignIn.this,"server.Cuenta creada.","coreo valido",JOptionPane.ERROR_MESSAGE);
                            Inicio i = new Inicio();
                            i.setVisible(true);
                            dispose();
                        } else if (contra.getText().length()<8) {
                            JOptionPane.showMessageDialog(SignIn.this,"la contraseña debe ser como minimo de 8 caracteres.","contraseña incorrecta",JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(SignIn.this,"Este correo ya fue ingresado.","correo invalido",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(SignIn.this,"Contraseñas no coinciden.","error contraseña",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton botonIngresar=new JButton("Ingresar");
        botonIngresar.setBounds(390,400,90,20);
        botonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
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
        panelPrincipal.add(botonRegistrar);
        panelPrincipal.add(botonIngresar);
        panelPrincipal.add(correo);
        panelPrincipal.add(contra);
        panelPrincipal.add(contra2);


        this.add(panelPrincipal);
    }
    private static Boolean correoInstitucional(String correo) {
        if (correo.length()<=12){
            System.out.println("el correo es invalido");
            return false;
        }else{
            if (!correo.substring(correo.length()-12).equals("@ufromail.cl")){
                System.out.println("el correo es invalido");
                return false;
            }else {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        SignIn l = new SignIn();
    }


}