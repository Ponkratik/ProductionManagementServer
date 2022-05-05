package by.b_p.productionmanagementserver.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "operation_component", schema = "rppba2")
@IdClass(OperationComponentPK.class)
public class OperationComponent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "operationId")
    private long operationId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "componentId")
    private long componentId;
    @Basic
    @Column(name = "quantity")
    private Long quantity;
    @ManyToOne
    @JoinColumn(name = "operationId", referencedColumnName = "operationId", updatable = false, insertable = false, nullable = false)
    private Operation operationByOperationId;
    @ManyToOne
    @JoinColumn(name = "componentId", referencedColumnName = "componentId", updatable = false, insertable = false, nullable = false)
    private Component componentByComponentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationComponent that = (OperationComponent) o;
        return operationId == that.operationId && componentId == that.componentId && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationId, componentId, quantity);
    }
}
