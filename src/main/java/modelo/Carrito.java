package modelo;

import java.util.ArrayList;

public class Carrito {
    ArrayList<Producto>productosDisponibles;

    public Carrito(ArrayList<Producto> productosDisponibles) {
        this.productosDisponibles = productosDisponibles;
    }

    public Carrito() {
    }

    public void agregarPedido(String correo,Venta venta){
        SocketCliente s = new SocketCliente(8888);
        s.enviar("V1/"+correo+"/"+venta);
    }
    public ArrayList<Producto> consultarProductos(){
        ArrayList<Producto>productos = new ArrayList<>();
        SocketCliente s = new SocketCliente(8888);
        String[] respuesta = s.enviarYRecibir("PD").split(";");

        for (int i = 0; i < respuesta.length ; i++) {
            String[] respuestaA=respuesta[i].split("/");
            Producto p = new Producto(respuestaA[0],Double.parseDouble(respuestaA[2]),respuestaA[1]);
            productos.add(p);
        }
        return productos;
    }




}
