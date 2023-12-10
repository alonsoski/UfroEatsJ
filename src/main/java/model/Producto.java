package model;

public class Producto {

    private String nombre, descripcion;
    private int cantidad, precio;

    public Producto(String nombre, String descripcion, int cantidad, int precio){

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Producto(Producto x, int cantidad){
        this.setNombre(x.getNombre());
        this.setDescripcion(x.getDescripcion());
        this.setCantidad(cantidad);
        this.setPrecio(x.getPrecio()*cantidad);
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    void agregarStock(int x){
        this.cantidad += x;
    }

    void quitarStock(int x){
        this.cantidad -= x;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
