
public class Book extends Product {
    private String author;

    public Book(int ID, String name, int price, String author) {
        super(ID, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        } else {
            return getAuthor().contains(search);
        }
    }
}
