package by.b_p.productionmanagementserver.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "orderId")
    private long orderId;
    @Basic
    @Column(name = "quantity")
    private Long quantity;
    @Basic
    @Column(name = "order_date")
    private Date orderDate;
    @Basic
    @Column(name = "batchId")
    private Long batchId;
    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId", nullable = false)
    private Product productByProductId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && Objects.equals(quantity, order.quantity) && Objects.equals(orderDate, order.orderDate) && Objects.equals(batchId, order.batchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, quantity, orderDate, batchId);
    }
}
