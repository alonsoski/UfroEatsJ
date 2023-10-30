import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> inventory;

    Inventory(){

        this.inventory = new ArrayList<>();

    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(int item){
        inventory.remove(item);
    }

    public void receiveOrder(Order order){

        if (stockAvailability(order)==true){

            for(Item i : getInventory()){
                for (Item j : order.getOrder()){
                    if (i.getName().equals(j.getName())){
                        i.remove(j.getStock());
                    }
                }
            }

        }else {
            //aca se supone que deberia enviar por el socket un msj al cliente
            //diciendo que no hay suficiente stock para procesar el pedido
        }

    }

    public boolean stockAvailability(Order order){

        boolean availability = true;

        for(Item i : getInventory()){
            for (Item j : order.getOrder()){
                if (i.getStock()< j.getStock()){
                    availability = false;
                }
            }
        }

        return availability;
    }

    public void showInventory(){
            for (Item i : getInventory()){
                System.out.println(i.getName()+" | "+i.getStock()+" | "+i.getPrice());
            }
    }


}
