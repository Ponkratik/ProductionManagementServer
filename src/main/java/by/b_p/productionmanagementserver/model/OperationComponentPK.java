package by.b_p.productionmanagementserver.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class OperationComponentPK implements Serializable {
    @Column(name = "operationId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long operationId;
    @Column(name = "componentId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long componentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationComponentPK that = (OperationComponentPK) o;
        return operationId == that.operationId && componentId == that.componentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationId, componentId);
    }
}
