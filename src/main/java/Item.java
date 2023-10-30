public class Item {

    private String name, description;
    private int stock, price, type;

    Item(String name, int stock, int price, int type){

        setName(name);
        setStock(stock);
        setPrice(price);
        setType(type);

        //this.name = name;
        //this.stock = stock;
        //this.price = price;
        //this.type = type;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    void add(int x){
        this.stock += x;
    }

    void remove(int x){
        this.stock -= x;
    }
}
