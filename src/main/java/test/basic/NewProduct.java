package test.basic;

import infra.DAO;
import model.basic.Product;

public class NewProduct {
    public static void main(String[] args) {
        
        Product product = new Product("Monitor", 543.98);
        
        DAO<Product> dao = new DAO<>(Product.class);
        dao.insertAtomic(product).close();

        System.out.println("Product ID: " + product.getId());
    }
}
