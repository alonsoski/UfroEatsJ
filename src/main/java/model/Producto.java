package model;

public class Producto {

    private String nombre, descripcion;
    private int stock, precio;

    public Producto(String nombre, String descripcion, int stock, int precio){

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    void agregarStock(int x){
        this.stock += x;
    }

    void quitarStock(int x){
        this.stock -= x;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
