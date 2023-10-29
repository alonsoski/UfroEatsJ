import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {
    private String ip;
    private int puerto;
    private String ipLocal = obtenerIp();

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

    public SocketServidor(int puerto) {
        this.puerto = puerto;
    }

    public SocketServidor(String ip, int puerto) {
        this.puerto = puerto;
        this.ip = ip;
    }
    public String[] escuchar(){
        String[] retorno=new String[2];
        try {
            ServerSocket serverSocket = new ServerSocket(this.puerto);
            Socket clientSocket = serverSocket.accept();
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String mensajeCliente = in.readLine();
            String[] peticion=mensajeCliente.split("/");
            switchPeticiones(peticion,clientSocket);
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retorno;
    }

    private void switchPeticiones(String[] peticion, Socket clientSocket) throws IOException {
        OutputStream outputStream = clientSocket.getOutputStream();
        PrintWriter out = new PrintWriter(outputStream, true);
        if (peticion[0].equals("IS")){
            Cuenta c = new Cuenta(peticion[1],peticion[2]);
            System.out.println("peticion inicion de sesion");
            out.println(c.usuarioExiste());
        } else if (peticion[0].equals("CU1")) {
            Cuenta c = new Cuenta(peticion[1],peticion[2]);
            System.out.println("peticion es posible crear usuario");
            out.println(c.canCreateUser());

        } else if (peticion[0].equals("CU2")) {
            Cuenta c = new Cuenta(peticion[1],peticion[2]);
            System.out.println("peticion crear Usuario");
            System.out.println("el ip recibiente es:"+this.ip);
            c.crearCuenta();
        }
        out.close();
        outputStream.close();

    }

}
