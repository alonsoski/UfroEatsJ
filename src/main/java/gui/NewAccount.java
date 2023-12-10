package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewAccount extends JFrame implements ActionListener {

    JTextField textField1, textField2;
    JButton button1;

    NewAccount(){

        button1 = new JButton("Crear cuenta");
        button1.setBounds(50,50,200,40);
        button1.addActionListener(this);

        textField1 = new JTextField();
        textField1.setFont(new Font("Comic Sans MS",Font.PLAIN,27));
        textField1.setPreferredSize(new Dimension(350,40));

        textField2 = new JTextField();
        textField2.setFont(new Font("Comic Sans MS",Font.PLAIN,27));
        textField2.setPreferredSize(new Dimension(350,40));

        this.setTitle("Registro");
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(textField1);
        this.add(textField2);
        this.add(button1);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setSize(600,420);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
