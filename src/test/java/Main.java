public class Main {
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product good1 = new Smartphone(1, "iPhone 11", 24400, "Apple");
        Product good2 = new Smartphone(2, "iPhone 12 PRO", 46400, "Apple");
        Product good3 = new Smartphone(3, "iPhone 13", 65300, "Apple");
        Product good4 = new Smartphone(4, "iPhone 14 PRO Max", 83400, "Apple");
        Product good5 = new Book(4, "iPhone user manual", 1400, "Apple");

        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);
        System.out.println("Goods with IDs " + good1.getID() + ", " + good2.getID() + ", " + good3.getID() + ", " + good4.getID() + " added");
        System.out.println("Trying to add good with existing ID: " + good5.getID());
        manager.add(good5);
    }
}
