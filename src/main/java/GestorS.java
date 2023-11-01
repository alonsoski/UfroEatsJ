import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GestorS {
    public GestorS(){}

    public void verPedidos(){
        ArrayList<Pedido>pedidos=listarPedidos();
        for (int i = 0; i <pedidos.size() ; i++) {
            System.out.println("Nombre Usuario:"+pedidos.get(i).getNombreU().substring(3));
            System.out.println("Precio:"+pedidos.get(i).getPrecio());
        }
    }

    public String stringMenu(){
        String retorno ="";
        File almuerzoDia = new File("./Almuerzos/AlmuerzosDelDia");
        String[] lista = almuerzoDia.list();
        for (int i = 0; i < lista.length ; i++) {
            File almuerzo = new File("./Almuerzos/AlmuerzosDelDia/"+lista[i]);
            retorno+=leerLinea(almuerzo);
            retorno+="-";
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

    private static ArrayList<Pedido> listarPedidos() {
        ArrayList<Pedido> retorno = new ArrayList<Pedido>();
        File carpeta = new File("./Pedidos");
        String[] listaC = carpeta.list();
        if (listaC.length==0){
            System.out.println("no hay pedidos");
        }else {
            for (int i = 0; i < listaC.length ; i++) {
                String nombre =obtenerNombreP(listaC[i]);
                int precio =obtenerPrecioP(listaC,i);
                ArrayList<Almuerzo> comidas = obtenerComidas(listaC,i);
                Pedido p = new Pedido(nombre,comidas,precio,false);
                retorno.add(p);
            }
        }
        return  retorno;
    }

    private static ArrayList<Almuerzo> obtenerComidas(String[] listaC, int i) {
        Almuerzo a = new Almuerzo();
        return a.getAlmuerzos(listaC[i]);
    }
    public void crearArchivo(String path, String nombre){
        File carpeta = new File(path+"/"+nombre);
        try {
            carpeta.createNewFile();
        }catch (Exception e){
            System.out.println("no se pudo crear el archivo");
        }
    }public void escribirArchivo(String path, String texto){
        File archivo = new File(path);
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


}
