package model;

import java.util.ArrayList;

public class OrderHistory {

    private ArrayList<Order> orderHistory;

    OrderHistory(){

        this.orderHistory = new ArrayList<>();

    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
    }
}
