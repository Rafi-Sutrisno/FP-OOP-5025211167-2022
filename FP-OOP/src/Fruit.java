
public class Fruit {
    private String name;
    private int weight;
    private int price = 1;
    private int total;
    
    public Fruit(){
        this.name = "";
        this.price = 1;
        this.weight = 1;
        this.total = 1;
    }
    
    public Fruit(String name, int price, int weight){
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.total = price*weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}


