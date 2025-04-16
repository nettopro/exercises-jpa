package model.one2many;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    public PurchaseOrder(){
        this(new Date());
    }

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY) //Default fetch value (toMany -> LAZY)
    private List<ItemOrdered> items;

    public PurchaseOrder(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ItemOrdered> getItems() {
        return items;
    }

    public void setItems(List<ItemOrdered> items) {
        this.items = items;
    }
}
