package model;

import java.util.ArrayList;

public class historialPedidos {

    private ArrayList<Pedido> historialPedidos;

    historialPedidos(){

        this.historialPedidos = new ArrayList<>();

    }

    public ArrayList<Pedido> getHistorialPedidos() {
        return historialPedidos;
    }

    public void agregarPedido(Pedido pedido) {
        historialPedidos.add(pedido);
    }
}
