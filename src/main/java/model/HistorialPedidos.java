package model;

import java.util.ArrayList;

public class HistorialPedidos {

    private ArrayList<Pedido> historialPedidos;

    HistorialPedidos(){

        this.historialPedidos = new ArrayList<>();

    }

    public ArrayList<Pedido> getHistorialPedidos() {
        return historialPedidos;
    }

    public void agregarPedido(Pedido pedido) {
        historialPedidos.add(pedido);
    }
}
