import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Almuerzo {
    private String nombre;
    private int precio;
    private String descripcion;

    public Almuerzo(String nombre, int precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    public Almuerzo(){

    }
    public Almuerzo rehacerAmuerzo(String archivo){
        Almuerzo retorno=new Almuerzo();
        String textoA="";
        try {
            File fichero= new File(archivo);
            FileReader fr = new FileReader (fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                textoA+=linea;
            }
            retorno.setNombre(textoA.split("/")[0]);
            retorno.setDescripcion(textoA.split("/")[1]);
            retorno.setPrecio(Integer.parseInt(textoA.split("/")[2]));
        }catch (Exception e){
            System.out.println("ha habido un error en leer la linea:"+e);
        }
        return retorno;
    }
    public  ArrayList<Almuerzo> getAlmuerzos(String carpetaA){
        ArrayList<Almuerzo> retorno = new ArrayList<>();
        String[] lista = new File("./Pedidos/"+carpetaA+"/02-almuerzos").list();
        for (int i = 0; i < lista.length ; i++) {
            File carpetaB = new File("./Pedidos/"+carpetaA+"/02-almuerzos/"+lista[i]);
            Almuerzo a = obtenerAlmuerzo(carpetaB);
            retorno.add(a);
        }
        return retorno;
    }

    private Almuerzo obtenerAlmuerzo(File carpetaB) {
        String[] lista = carpetaB.list();
        String nombre=lista[0].replace("01-","");
        int precio = Integer.parseInt(lista[1].replace("02-",""));
        String descripcion = obtenerDescripcion(carpetaB);
        return new Almuerzo(nombre,precio,descripcion);
    }

    private String obtenerDescripcion(File carpetaB) {
        String retorno= "";
        File aDescripcion = new File(carpetaB.getPath()+"/03-descripcion.txt");
        try {
            FileReader fr = new FileReader (aDescripcion);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                retorno+=linea;
            }
        }catch (Exception e){
            System.out.println("ha habido un error en descripcion:"+e);
        }
        return retorno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;}
    }


