import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    public void shouldFindNothing() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product good1 = new Smartphone(1, "iPhone 11", 24400, "Apple");
        Product good2 = new Smartphone(2, "iPhone 12 PRO", 46400, "Apple");
        Product good3 = new Smartphone(3, "iPhone 13", 65300, "Apple");
        Product good4 = new Smartphone(4, "iPhone 14 PRO Max", 83400, "Apple");

        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindOne() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product good1 = new Smartphone(1, "iPhone 11", 24400, "Apple");
        Product good2 = new Smartphone(2, "iPhone 12 PRO", 46400, "Apple");
        Product good3 = new Book(3, "iPhone 13 Manual", 65300, "Apple");
        Product good4 = new Smartphone(4, "iPhone 14 PRO Max", 83400, "Apple");

        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);

        Product[] expected = {good3};
        Product[] actual = manager.searchBy("13");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTwo() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product good1 = new Smartphone(1, "iPhone 11", 24400, "Apple");
        Product good2 = new Smartphone(2, "iPhone 12 PRO", 46400, "Apple");
        Product good3 = new Smartphone(3, "iPhone 13", 65300, "Apple");
        Product good4 = new Smartphone(4, "iPhone 14 PRO Max", 83400, "Apple");

        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);

        Product[] expected = {good2, good4};
        Product[] actual = manager.searchBy("PRO");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByManufacturer() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product good1 = new Smartphone(1, "iPhone 11", 24400, "Apple");
        Product good2 = new Book(2, "1984", 1400, "George Orwell");
        Product good3 = new Smartphone(3, "iPhone 13", 65300, "Apple");
        Product good4 = new Book(4, "The Great Gatsby", 2100, "F. Scott Fitzgerald");

        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);

        Product[] expected = {good1, good3};
        Product[] actual = manager.searchBy("Apple");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByAuthor() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product good1 = new Smartphone(1, "iPhone 11", 24400, "Apple");
        Product good2 = new Book(2, "1984", 1400, "George Orwell");
        Product good3 = new Smartphone(3, "iPhone 13", 65300, "Apple");
        Product good4 = new Book(4, "The Great Gatsby", 2100, "F. Scott Fitzgerald");

        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);

        Product[] expected = {good4};
        Product[] actual = manager.searchBy("Fitzgerald");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product good1 = new Smartphone(1, "iPhone 11", 24400, "Apple");
        Product good2 = new Smartphone(2, "iPhone 12 PRO", 46400, "Apple");
        Product good3 = new Smartphone(3, "iPhone 13", 65300, "Apple");
        Product good4 = new Smartphone(4, "iPhone 14 PRO Max", 83400, "Apple");

        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);

        Product expected = null;
        Product actual = repo.findById(5);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionIfRemoveByBadID() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product good1 = new Smartphone(1, "iPhone 11", 24400, "Apple");
        Product good2 = new Smartphone(2, "iPhone 12 PRO", 46400, "Apple");
        Product good3 = new Smartphone(3, "iPhone 13", 65300, "Apple");
        Product good4 = new Smartphone(4, "iPhone 14 PRO Max", 83400, "Apple");

        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);

        assertThrows(NotFoundException.class, () -> manager.removeById(5));
    }

    @Test
    public void shouldRemoveByID() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product good1 = new Smartphone(1, "iPhone 11", 24400, "Apple");
        Product good2 = new Smartphone(2, "iPhone 12 PRO", 46400, "Apple");
        Product good3 = new Smartphone(3, "iPhone 13", 65300, "Apple");
        Product good4 = new Smartphone(4, "iPhone 14 PRO Max", 83400, "Apple");

        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);

        manager.removeById(2);
        manager.removeById(4);

        Product[] expected = {good1, good3};
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNew() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product good1 = new Smartphone(1, "iPhone 11", 24400, "Apple");
        Product good2 = new Smartphone(2, "iPhone 12 PRO", 46400, "Apple");
        Product good3 = new Smartphone(3, "iPhone 13", 65300, "Apple");
        Product good4 = new Smartphone(4, "iPhone 14 PRO Max", 83400, "Apple");

        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);

        Product[] expected = {good1, good2, good3, good4};
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionIfIdAlreadyExists() {
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

        assertThrows(AlreadyExistsException.class, () -> manager.add(good5));
    }
}