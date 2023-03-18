public class ProductManager {
    private ProductRepository repo;

    ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.addNew(product);
    }

    public Product[] findAll() {
        return repo.findAll();
    }

    public void removeById(int id) {
        if (repo.findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        repo.removeById(id);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

}
