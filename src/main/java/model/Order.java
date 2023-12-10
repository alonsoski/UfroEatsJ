package model;

import model.Producto;

import java.util.ArrayList;

public class Order {

    private ArrayList<Producto> order;

    Order(ArrayList<Producto> order){

        this.order = order;

    }

    public ArrayList<Producto> getOrder() {
        return order;
    }
}
