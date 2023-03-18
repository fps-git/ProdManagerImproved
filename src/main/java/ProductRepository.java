public class ProductRepository {
    private Product[] productList = new Product[0];

    public void addNew(Product product) {
        Product[] tmp = new Product[productList.length + 1];
        for (int i = 0; i < productList.length; i++) {
            tmp[i] = productList[i];
        }
        tmp[tmp.length - 1] = product;
        productList = tmp;
    }

    public Product[] findAll() {
        return productList;
    }

    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getID() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[productList.length - 1];
        int copyToIndex = 0;
        for (Product product : productList) {
            if (product.getID() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        productList = tmp;
    }

}
