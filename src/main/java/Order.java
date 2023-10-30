import java.util.ArrayList;

public class Order {

    private ArrayList<Item> order;

    Order(ArrayList<Item> order){

        this.order = order;

    }

    public ArrayList<Item> getOrder() {
        return order;
    }
}
