import java.util.ArrayList;

public class Pedido {
    private String nombreU;
    private ArrayList<Almuerzo> almuerzos;
    private int precio;
    private boolean despachado;

    public Pedido(String nombreU, ArrayList<Almuerzo> almuerzos, int precio, boolean despachado) {
        this.nombreU = nombreU;
        this.almuerzos = almuerzos;
        this.precio = precio;
        this.despachado = despachado;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public void setAlmuerzos(ArrayList<Almuerzo> almuerzos) {
        this.almuerzos = almuerzos;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setDespachado(boolean despachado) {
        this.despachado = despachado;
    }

    public String getNombreU() {
        return nombreU;
    }

    public ArrayList<Almuerzo> getAlmuerzos() {
        return almuerzos;
    }

    public int getPrecio() {
        return precio;
    }

    public boolean isDespachado() {
        return despachado;
    }
}
