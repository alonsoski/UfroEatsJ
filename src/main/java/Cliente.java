import modelo.SocketCliente;
import server.Almuerzo;

import java.util.ArrayList;
import java.util.Scanner;
//-------Codigos de peticiones---------
//IS --Incio de Sesion
//CU1--Se puede crear un usario
//CU2--Crear usuario
//NU --Nombre de usuario
//RNU--Registrar nombre de usuario
//AL1--almuerzos del dia
//AL2--almuerzoz
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
            home(datos);
        }else{
            System.out.println("Nombre o contraseña incorrectos");
            lobby();
        }
    }

    private static void home(ArrayList<String> datos) {
        nombreDeUsuario(datos);
        int eleccion=0;
        while (eleccion<1 || eleccion>5){
            System.out.println("que quieres hacer???");
            System.out.println("1.-Hacer un pedido");
            System.out.println("2.-Ver pedidos pendientes");
            System.out.println("3.-Ver pedidos despachados");
            System.out.println("4.-Configuraciones de cuenta");
            System.out.println("5.-Cerrar sesion");
            eleccion = eleccion(5);
        }
        switchHome(eleccion,datos);
    }

    private static ArrayList<ArrayList<Almuerzo>> actualizacionComidas() {
        SocketCliente s = new SocketCliente(8888);
        ArrayList<ArrayList<Almuerzo>> menuRetorno=new ArrayList<ArrayList<Almuerzo>>();
        ArrayList<Almuerzo> menuGeneral = new ArrayList<>();
        ArrayList<Almuerzo> menuDelDia = new ArrayList<>();
        String stringMenu = s.enviarYRecibir("AL1");
        String[] str1 = stringMenu.split("_");
        String[] strDia = str1[0].split("-");
        for (int i = 0; i <strDia.length ; i++) {
            Almuerzo a = new Almuerzo(strDia[i].split("/")[0],2500,strDia[i].split("/")[1]);
            menuDelDia.add(a);
        }
        menuRetorno.add(menuDelDia);
        String[] strGral = str1[1].split("-");
        for (int i = 0; i <strGral.length ; i++) {
            Almuerzo a = new Almuerzo(strGral[i].split("/")[0],Integer.parseInt(strGral[i].split("/")[2]),strGral[i].split("/")[1]);
            menuGeneral.add(a);
        }
        menuRetorno.add(menuGeneral);
        return menuRetorno;
    }

    private static void switchHome(int eleccion,ArrayList<String> datos ) {
        switch (eleccion){
            case 1:
                mostrarComidasDisponibles();
                home(datos);
                break;
            case 2:
                //pedidosPendientes();
                home(datos);
                break;
            case 3:
                //mostrarComidasDisponibles();
                home(datos);
                break;
            case 4:
                //opcionesCuenta(datos);
                home(datos);
                break;
            case 5:
                System.out.println("ok, adios");
                lobby();
                break;
        }
    }

    private static void mostrarComidasDisponibles() {
        ArrayList<ArrayList<Almuerzo>> menu = actualizacionComidas();
        for (int i = 0; i < menu.get(0).size() ; i++) {
            System.out.println(i+1+".-");
            System.out.println("Comida del dia: "+menu.get(0).get(i).getNombre());
            System.out.println("Descripcion: "+menu.get(0).get(i).getDescripcion());
        }
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < menu.get(1).size() ; i++) {
            System.out.println(i+1+".-");
            System.out.println("Comida General: "+menu.get(1).get(i).getNombre());
            System.out.println("Descripcion: "+menu.get(1).get(i).getDescripcion());
        }
    }

    private static void nombreDeUsuario(ArrayList<String> datos) {
        SocketCliente s = new SocketCliente(8888);
        String peticion = s.enviarYRecibir("NU/"+datos.get(0)+"/"+datos.get(1));
        if (peticion.equals("n/r")){
            System.out.println("Bienvenido "+registrarNombreDeUsuario(datos));
        }else{
            System.out.println("Bienvenido "+peticion) ;
        }
    }

    private static String registrarNombreDeUsuario(ArrayList<String> datos) {
        Scanner t = new Scanner(System.in);
        SocketCliente s = new SocketCliente(8888);
        System.out.println("No has registrado tu nombre de usuario");
        System.out.println("Ingresa tu nombre de usuario");
        String nombre ="";
        do {
            nombre = t.nextLine();
            if (nombre.equals("n/r") || nombre.length()<1){
                System.out.println("ese nombre no esta disponible");
            }
        }while (nombre.equals("n/r") || nombre.length()<1);

        s.enviar("RNU/"+datos.get(0)+"/"+datos.get(1)+"/"+nombre);
        return nombre;
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
