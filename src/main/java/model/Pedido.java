package model;

import java.util.ArrayList;

public class Pedido {

    private ArrayList<Producto> pedido;

    Pedido(ArrayList<Producto> pedido){

        this.pedido = pedido;

    }

    public ArrayList<Producto> getPedido() {
        return pedido;
    }
}
