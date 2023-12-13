package gui;

import javax.swing.*;

public class Historial extends JFrame {
    private String correo;
    private DefaultListModel<String> listaPedidosModel;
    private JList<String> lista;
    public Historial(String correo){
        this.correo=correo;
        this.setSize(300,300);

        listaPedidosModel= new DefaultListModel<>();
        lista = new JList(listaPedidosModel);
        this.add(lista);

    }

    public static void main(String[] args) {
        Historial gh = new Historial("q@ufromail.cl");
        gh.setVisible(true);
    }
}
