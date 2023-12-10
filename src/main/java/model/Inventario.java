package model;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> listaInventario;

    Inventario(){

        this.listaInventario = new ArrayList<>();

    }

    public ArrayList<Producto> getListaInventario() {
        return listaInventario;
    }

    public void agregarProducto(Producto producto) {
        listaInventario.add(producto);
    }

    public void quitarProducto(int i){
        listaInventario.remove(i);
    }

    public void receiveOrder(Pedido pedido){

        if (disponibilidadStock(pedido)==true){

            for(Producto i : getListaInventario()){
                for (Producto j : pedido.getPedido()){
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

    public boolean disponibilidadStock(Pedido pedido){

        boolean disponibilidad = true;

        for(Producto i : getListaInventario()){
            for (Producto j : pedido.getPedido()){
                if (i.getStock()< j.getStock()){
                    disponibilidad = false;
                }
            }
        }

        return disponibilidad;
    }

    public void mostarInventario(){
            for (Producto i : getListaInventario()){
                System.out.println(i.getNombre()+" | "+i.getStock()+" | "+i.getPrecio());
            }
    }


}
