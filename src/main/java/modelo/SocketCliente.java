package modelo;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketCliente {
    private int puerto;
    private String ip = obtenerIp();//obtenerIp();

    private String obtenerIp() {
        String ip = "";
        try {
            InetAddress ipA = InetAddress.getLocalHost();
            ip = ipA.getHostAddress();
        } catch (Exception e) {
            System.out.println("ha habido un error");
        }
        return ip;

    }

    public SocketCliente(int puerto) {
        this.puerto = puerto;
    }

    public SocketCliente(String ip, int puerto) {
        this.puerto = puerto;
        this.ip = ip;
    }
    public String enviarYRecibir(String mensaje){
        String retorno= "";
        try {
            Socket socket = new Socket(this.ip, this.puerto);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            PrintWriter out = new PrintWriter(outputStream, true);
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            out.println(mensaje);
            retorno=""+in.readLine();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "errorServidor";
        }
        return retorno;
    }
    public void enviar(String mensaje){
        try {
            System.out.println("el ip enviante es:"+this.ip);
            Socket socket = new Socket(this.ip, this.puerto);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);
            out.println(mensaje);
            socket.close();
        }catch (Exception e){
            System.out.println("aqui esta el error");
            e.printStackTrace();
        }
    }

}