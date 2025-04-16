package test.one2many;

import infra.DAO;
import model.basic.Product;
import model.one2many.ItemOrdered;
import model.one2many.PurchaseOrder;

public class NewOrder {
    public static void main(String[] args) {
        DAO<Object> dao = new DAO<>();

        PurchaseOrder order = new PurchaseOrder();
        Product product = new Product("Fridge",2789.99);
        ItemOrdered item = new ItemOrdered(order, product, 10);

        dao.beginTransaction()
            .insert(product)
            .insert(order)
            .insert(item)
            .commitTransaction()
            .close();
    }
}
