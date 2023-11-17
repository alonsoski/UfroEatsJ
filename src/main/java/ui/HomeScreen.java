package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JFrame implements ActionListener {

    ImageIcon background, icon;
    JLabel label1, label2;
    JLayeredPane layeredPane;
    JTextField textField;
    JPasswordField passwordField;
    JButton button1, button2;
    JPanel panel1, panel2;
    HomeScreen(){

        background = new ImageIcon("bg.png");
        icon = new ImageIcon("u.png");

        button1 = new JButton("Ingresar");
        button1.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        button1.setBounds(290,500,120,50);
        button1.addActionListener(this);

        button2 = new JButton("Registrarse");
        button2.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        button2.setBounds(560,610,120,50);
        button2.addActionListener(this);


        label1 = new JLabel("",background,JLabel.CENTER);
        label1.setBounds(0,0,1280,720);
        //label1.setIcon(background);

        label2 = new JLabel("",icon,JLabel.CENTER);
        label2.setBounds(200,30,300,300);

        textField = new JTextField();
        textField.setFont(new Font("Comic Sans MS",Font.PLAIN,27));
        //textField.setPreferredSize(new Dimension(250,40));
        textField.setBounds(160,370,390,50);


        passwordField= new JPasswordField();
        //passwordField.setPreferredSize(new Dimension(250,40));
        passwordField.setBounds(160,430,390,50);

        //panel1 = new JPanel();
        //panel1.setBackground(new Color(25,25,46));
        //panel1.setBounds(0,0,1280,720);


        panel2 = new JPanel();
        panel2.setBackground(new Color(230,250,255));
        panel2.setBounds(290,0,700,720);
        panel2.setLayout(null);
        panel2.add(label2);
        panel2.add(button1);
        panel2.add(textField);
        panel2.add(passwordField);
        panel2.add(button2);


        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,1280,720);
        layeredPane.add(label1, Integer.valueOf(0));
        layeredPane.add(panel2, Integer.valueOf(1));

        this.setTitle("UFRO Eats");
        this.add(layeredPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(icon.getImage());
        this.setSize(1280,720);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==button2){
            NewAccount newAccount = new NewAccount();
        } else if (e.getSource()==button1) {

            panel1 = new JPanel();
            panel1.setBounds(0,0,1280,720);

            layeredPane.add(panel1, Integer.valueOf(2));
            panel2.setVisible(false);

            //layeredPane.remove(panel2);
        }

    }
}
