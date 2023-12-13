package gui;
import modelo.SocketCliente;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class RegistroNombreUsuario extends JFrame {
    private String correoU;
    private  void nombreDeUsuario() {
        SocketCliente s = new SocketCliente(8888);
        String peticion = s.enviarYRecibir("NU/"+correoU+"/"+"asd");
        if (peticion.equals("n/r")){
            ejecucion();
        }else{
            Home h = new Home(correoU);
            h.setVisible(true);
        }

    }
    private void ejecucion(){
        this.setSize(720, 480);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("RegistroUsuario");
        PanelConImagen panelPrincipal = new PanelConImagen();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground("./data/images/crearu.png");


        JLabel texto=new JLabel("Debes crear tu nombre de usuario");
        texto.setBounds(255,167,275,43);

        JTextField cTexto= new JTextField("nombre de usuario");
        cTexto.setBounds(243,236,195,25);


        JButton CrearUsuario= new JButton("Crear nombre");
        CrearUsuario.setBounds(285,298,130,30);
        CrearUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SocketCliente s = new SocketCliente(8888);
                s.enviar("RNU/"+correoU+"/asdsad/"+cTexto.getText());
                Home h =new Home(correoU);
                h.setVisible(true);
                dispose();
            }
        });

        panelPrincipal.add(cTexto);
        panelPrincipal.add(texto);
        panelPrincipal.add(CrearUsuario);

        this.add(panelPrincipal);
    }
    public RegistroNombreUsuario(String correoU){

        this.correoU=correoU;
        nombreDeUsuario();


    }


}
//SocketCliente s = new SocketCliente(8888);
//s.enviar("RNU/"+datos.get(0)+"/"+datos.get(1)+"/"+nombre);
//