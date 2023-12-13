package server;

import modelo.Producto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorS {
    public GestorS(){}

    public void verPedidos(){
       File carpeta = new File("./Pedidos");
       String[] lista = carpeta.list();
        for (int i = 0; i <lista.length ; i++) {

            String texto="-----------------------------------\n"
                    +lista[i].substring(0,lista[i].length()-4)+"\n"
                    +leerLinea(new File(carpeta+"/"+lista[i])).split(";")[0]+"\n"
                    +leerLinea(new File(carpeta+"/"+lista[i])).split(";")[1]+"\n"
                    +leerLinea(new File(carpeta+"/"+lista[i])).split(";")[2];
            System.out.println(texto);
        }

    }
    public String productos(){
        String retorno = "";
        File archivo= new File("./Almuerzos");
        String[] lista = archivo.list();
        for (int i = 0; i <lista.length ; i++) {
            File almuerzo=new File("./Almuerzos/"+lista[i]);
            retorno+=leerLinea(almuerzo)+";";
        }
        return retorno;
    }





    private String leerLinea(File almuerzo) {
        String retorno="";
        try {
            FileReader fr = new FileReader (almuerzo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                retorno+=linea;
            }
        }catch (Exception e){
            System.out.println("ha habido un error al leer el almuerzo:"+e);
        }
        return retorno;
    }



    public void crearArchivo(String path, String nombre){
        File carpeta = new File(path+"/"+nombre);
        try {
            carpeta.createNewFile();
        }catch (Exception e){
            System.out.println("no se pudo crear el archivo");
        }
    }public  void escribirArchivo(String path, String texto){
        File archivo = new File(path);
        try {
            FileWriter fw=new FileWriter(archivo);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write(texto);
            bw.flush();
        }catch (Exception e){
            System.out.println("no se ha podido escribir en el archivo");
        }


    }

    private static int obtenerPrecioP(String[] listaC, int i) {
        File carpeta = new File("./Pedidos/"+listaC[i]);
        String[] lista = carpeta.list();
        return Integer.parseInt(lista[2].substring(3));
    }

    private static String obtenerNombreP(String listaC) {
        File carpeta = new File("./Pedidos/"+listaC);
        String[] lista = carpeta.list();

        return lista[0];
    }

    public  void crearPedido(String[] peticion){
        int numero=0;
        File carpeta= new File("./Cuentas/"+peticion[1]+"/Historial");
        String[] lista = carpeta.list();
        numero=lista.length+1;
        File archivo= new File("./Cuentas/"+peticion[1]+"/Historial/"+"pedido"+numero+".txt");
        try {
            archivo.createNewFile();
        }catch (Exception e){
            System.out.println("no se ha podido crear el archivo");
        }
        String[]venta = peticion[2].split(";");
        String texto= "Pedido:"+venta[0]+"\n" +
                "Cantidad:"+venta[1]+"\n" +
                "Precio:"+venta[2];


        escribirArchivo("./Cuentas/"+peticion[1]+"/Historial/"+"pedido"+numero+".txt",texto);
        crearPedidoGeneral(peticion);
    }

    private void crearPedidoGeneral(String[] peticion) {
        String nombre =crearNombre(peticion);
        File archivo = new File(nombre);
        try {
            archivo.createNewFile();
        }catch (Exception e){
            System.out.println("no se ha podido crear el archivo general");
            System.out.println(nombre);
            e.printStackTrace();
        }
        String[]venta = peticion[2].split(";");
        String texto= "Pedido:"+venta[0]+";" +
                "Cantidad:"+venta[1]+";" +
                "Precio:"+venta[2];


        escribirArchivo(nombre,texto);
    }

    private String crearNombre(String[] peticion) {
        int numero=0;
        String nombre = peticion[1];//.substring(0,peticion[1].length()-3);
        File archivo = new File("./Pedidos/"+nombre+numero+".txt");

        do {
            if (archivo.exists()){
                numero++;
            }
            archivo=new File("./Pedidos/"+nombre+(numero)+".txt");
        }while (archivo.exists());
        System.out.println("./Pedidos/"+nombre+numero+".txt");
        return "./Pedidos/"+nombre+numero+".txt";
    }

    public static void main(String[] args) {

    }
}
