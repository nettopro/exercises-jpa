package test.basic;

import java.util.List;

import infra.ProductDAO;
import model.basic.Product;

public class GetProducts {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.getAll();

        for(Product product: products){
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName());
        }

        double totalPrice = products
            .stream()
            .map(p -> p.getPrice())
            .reduce(0.0, (t, p) -> t + p)
            .doubleValue();
        System.out.println("Total value is R$: " + totalPrice);
    }
}
