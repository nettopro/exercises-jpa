package test.one2many;

import infra.DAO;
import model.one2many.ItemOrdered;
import model.one2many.PurchaseOrder;

public class GetOrder {
    public static void main(String[] args) {
        DAO<PurchaseOrder> dao = new DAO<>(PurchaseOrder.class);

        PurchaseOrder order = dao.getById(1);

        for(ItemOrdered item: order.getItems()){
            System.out.println(item.getQuantity());
            System.out.println(item.getProduct().getName());
        }

        dao.close();
    }
}
