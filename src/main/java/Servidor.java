import java.util.Scanner;

public class Servidor extends Thread {
    public static void main(String[] args) {
        Servidor a = new Servidor();
        a.start();
        servidor();
    }

    private static void servidor() {
        int eleccion= 0;
        while (eleccion<1 || eleccion>3){
            System.out.println("1.-Ver Pedidos");
            System.out.println("2.-Despachar Pedido");
            System.out.println("3.-Cancelar Pedido");
            eleccion = eleccion(3);
        }
        switchServer(eleccion);
    }
    private static void switchServer(int eleccion){
        switch (eleccion){
            case 1:
                verPedidos();
                servidor();
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("eso no se puede");
                break;
        }
    }

    private static void verPedidos() {
        GestorS g = new GestorS();
        g.verPedidos();
    }

    private static int eleccion(int cantidadOpciones) {
        Scanner t = new Scanner(System.in);
        int eleccion=0;
        try {
            eleccion=t.nextInt();
        }catch (Exception e){
            t.nextLine();
        }
        return eleccion;
    }



    @Override
    public void run() {
        while (true){
            SocketServidor s =new SocketServidor(8888);
            s.escuchar();
        }
    }
}
