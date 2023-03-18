public class Product {

    protected int ID;
    protected String name;
    protected int price;


    public Product(int ID, String name, int price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean matches(String search) {
        return getName().contains(search);
    }

}
