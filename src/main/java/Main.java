import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.*;
public class Main {
    public static void main(String[] args) throws UnknownHostException {
        JFrame cuadro = new JFrame("UfroEats");
        cuadro.setSize(500,600);
        cuadro.setVisible(true);
        JTextField texto = new JTextField("ingresar");
        texto.setVisible(true);
        cuadro.add(texto);
    }
}
