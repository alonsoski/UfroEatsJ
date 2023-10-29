import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Almuerzo {
    private String nombre;
    private int precio;
    private String descripcion;
    private List<String> ingredientes;

    public Almuerzo(String nombre, int precio, String descripcion, List<String> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.ingredientes = ingredientes;
    }
    public Almuerzo(){

    }
    public  ArrayList<Almuerzo> getAlmuerzos(String carpetaA){
        ArrayList<Almuerzo> retorno = new ArrayList<>();
        File carpeta = new File("./Pedidos/"+carpetaA+"/02-almuerzos");
        String[] lista = carpeta.list();
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
        List<String> ingredientes = obtenerIngredientes(carpetaB);
        return new Almuerzo(nombre,precio,descripcion,ingredientes);
    }

    private List<String> obtenerIngredientes(File carpetaB) {
        String ingredientes="";
        List<String> retorno = new ArrayList<String>();
        File aIngredientes=new File(carpetaB.getPath()+"/04-ingredientes.txt");
        try {
            FileReader fr = new FileReader (aIngredientes);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                ingredientes+=linea;
            }
        }catch (Exception e){
            System.out.println("ha habido un error en ingredientes:"+e);
        }
        String[] arrayIngre= ingredientes.split("/");
        retorno = Arrays.asList(arrayIngre);
        return retorno;
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
        this.descripcion = descripcion;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
