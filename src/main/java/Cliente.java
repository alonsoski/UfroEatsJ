import java.util.ArrayList;
import java.util.Scanner;

//IS--Incio de Sesion
//CU1--Se puede crear un usario
public class Cliente {
    public static void main(String[] args) {
lobby();
    }
    private static void lobby() {
        System.out.println("Bienvenido a UfroEats");
        System.out.println("que quieres hacer");
        System.out.println("1.-Iniciar Sesion");
        System.out.println("2.-Crear Usuario");
        System.out.println("3.-Salir");
        int eleccion = eleccion(3);
        switcHLobby(eleccion);
    }

    private static void switcHLobby(int eleccion) {
        switch (eleccion){
            case 1:
                System.out.println("inicio sesion");
                inicioSesion();
                break;
            case 2:
                System.out.println("crear usuario");
                crearCuenta();
                break;
            case 3:
                System.out.println("ok adios");
                break;
            default:
                System.out.println("eso no se puede");
                lobby();
        }

    }

    private static void crearCuenta() {
        SocketCliente s = new SocketCliente(8888);
        String correo = crearCuentaCorreo();
        String contra = crearCuentaContra();
        String peticion= s.enviarYRecibir("CU1/"+correo+"/"+contra);

        if (peticion.equals("true")){
            s.enviar("CU2/"+correo+"/"+contra);
            System.out.println("usuario creado");
            lobby();
        }else {
            System.out.println("ese correo ya esta ingresado");
            lobby();
        }
    }

    private static String crearCuentaContra() {
        Scanner t = new Scanner(System.in);
        String contra1="";
        String contra2="";
        while (contra1.length()<5 || !contra1.equals(contra2)){
            System.out.println("ingrese la contraseña de minimo 5 caracteres de largo");
            contra1=t.nextLine();
            System.out.println("repita la contraseña");
            contra2=t.nextLine();
            if (contra1.equals(contra2)){
                if (contra1.length()<5){
                    System.out.println("la contraseña debe ser de largo minimo 5");
                }
            }else {
                System.out.println("las contraseñas deben coincidir");
            }
        }
        return contra1;
    }

    private static String crearCuentaCorreo() {
        Scanner t = new Scanner(System.in);
        String correo="";
        boolean paso = false;
        while (!paso){
            System.out.println("Ingrese su correo");
            System.out.println("Debe ser institucional: @ufromail.cl");
            correo = t.nextLine();
            if (correo.length()<=12){
                System.out.println("el correo es invalido");
            }else{
                if (!correo.substring(correo.length()-12).equals("@ufromail.cl")){
                    System.out.println("el correo es invalido");
                }else {
                    paso=true;
                }
            }
        }
        return correo;
    }

    private static void inicioSesion() {
        SocketCliente s = new SocketCliente(8888);
        ArrayList<String> datos = consultarDatos();
        String peticion = s.enviarYRecibir("IS/"+datos.get(0)+"/"+datos.get(1));
        if (peticion.equals("true")){
            //home();
            System.out.println("xd si existe");
        }else{
            System.out.println("Nombre o contraseña incorrectos");
            lobby();
        }
    }

    private static void home(Usuario u) {
    }

    private static ArrayList<String> consultarDatos() {
        ArrayList<String> datos = new ArrayList<String>();
        datos.add(consulta("el correo"));
        datos.add(consulta("la contraseña"));
        return datos;
    }
    private static String consulta(String d) {
        Scanner t = new Scanner(System.in);
        System.out.println("ingrese "+ d);
        return t.nextLine();
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
}
