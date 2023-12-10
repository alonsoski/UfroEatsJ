package model;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Producto> inventory;

    Inventory(){

        this.inventory = new ArrayList<>();

    }

    public ArrayList<Producto> getInventory() {
        return inventory;
    }

    public void addItem(Producto producto) {
        inventory.add(producto);
    }

    public void removeItem(int item){
        inventory.remove(item);
    }

    public void receiveOrder(Order order){

        if (stockAvailability(order)==true){

            for(Producto i : getInventory()){
                for (Producto j : order.getOrder()){
                    if (i.getNombre().equals(j.getNombre())){
                        i.quitarStock(j.getStock());
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

        for(Producto i : getInventory()){
            for (Producto j : order.getOrder()){
                if (i.getStock()< j.getStock()){
                    availability = false;
                }
            }
        }

        return availability;
    }

    public void showInventory(){
            for (Producto i : getInventory()){
                System.out.println(i.getNombre()+" | "+i.getStock()+" | "+i.getPrecio());
            }
    }


}
