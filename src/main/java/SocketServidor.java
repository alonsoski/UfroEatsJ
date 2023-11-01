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
            System.out.println("peticion"+peticion[0]);
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
            peticionIS(peticion,out);
        } else if (peticion[0].equals("CU1")) {
            peticionCU1(peticion,out);
        } else if (peticion[0].equals("CU2")) {
            peticionCU2(peticion,out);
        } else if (peticion[0].equals("NU")) {
            peticionNU(peticion,out);
        } else if (peticion[0].equals("RNU")){
            peticionRNU(peticion);
        } else if (peticion[0].equals("AL1")){
            peticionAL1(out);
        }
        out.close();
        outputStream.close();
    }

    private void peticionAL1( PrintWriter out) {
        System.out.println("peticion de actualizar menu");
        GestorS gS = new GestorS();
        out.println(gS.stringMenu());
    }

    private void peticionRNU(String[] peticion) {
        Cuenta c = new Cuenta(peticion[1],peticion[2]);
        c.setNombreUArchivo(peticion[3]);
    }

    private void peticionNU(String[] peticion, PrintWriter out) {
        Cuenta c = new Cuenta(peticion[1],peticion[2]);
        System.out.println("Peticion nombre usuario");
        out.println(c.getNombreUArchivo());
    }

    private void peticionCU2(String[] peticion, PrintWriter out) {
        Cuenta c = new Cuenta(peticion[1],peticion[2]);
        System.out.println("peticion crear Usuario");
        c.crearCuenta();
    }

    private void peticionCU1(String[] peticion, PrintWriter out) {
        Cuenta c = new Cuenta(peticion[1],peticion[2]);
        System.out.println("peticion es posible crear usuario");
        out.println(c.canCreateUser());
    }

    private void peticionIS(String[] peticion, PrintWriter out) {
        Cuenta c = new Cuenta(peticion[1],peticion[2]);
        System.out.println("peticion inicion de sesion");
        out.println(c.usuarioExiste());
    }

}
