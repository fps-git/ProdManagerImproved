public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int ID, String name, int price, String manufacturer) {
        super(ID, name, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        } else {
            return getManufacturer().contains(search);
        }
    }
}
