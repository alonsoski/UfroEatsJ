package model;

import java.util.ArrayList;

public class Carrito {

    private static ArrayList<Producto> productosCarrito;

    public Carrito(){
        productosCarrito = new ArrayList<>();
    }

    public ArrayList<Producto> getProductosCarrito() {
        return productosCarrito;
    }

    public void setProductosCarrito(ArrayList<Producto> productosCarrito) {
        Carrito.productosCarrito = productosCarrito;
    }

    public void agregarProducto(Producto producto){
        productosCarrito.add(producto);
    }

    public void quitarProducto(int i){
        productosCarrito.remove(i);
    }

    public void vaciarCarrito(){

    }
}
