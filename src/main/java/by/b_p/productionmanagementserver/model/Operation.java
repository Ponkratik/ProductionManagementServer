package by.b_p.productionmanagementserver.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Operation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "operationId")
    private long operationId;
    @Basic
    @Column(name = "sequence_number")
    private long sequenceNumber;
    @Basic
    @Column(name = "operation_name")
    private String operationName;
    @Basic
    @Column(name = "runtime")
    private Date runtime;
    @ManyToOne
    @JoinColumn(name = "routeId", referencedColumnName = "routeId", nullable = false)
    private Route routeByRouteId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return operationId == operation.operationId && sequenceNumber == operation.sequenceNumber && Objects.equals(operationName, operation.operationName) && Objects.equals(runtime, operation.runtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationId, sequenceNumber, operationName, runtime);
    }
}
