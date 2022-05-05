package by.b_p.productionmanagementserver.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Plan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "planId")
    private long planId;
    @Basic
    @Column(name = "planned_date")
    private Date plannedDate;
    @Basic
    @Column(name = "completion_status")
    private String completionStatus;
    @ManyToOne
    @JoinColumn(name = "operationId", referencedColumnName = "operationId", nullable = false)
    private Operation operationByOperationId;
    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", nullable = false)
    private Order orderByOrderId;
    @ManyToOne
    @JoinColumn(name = "machineId", referencedColumnName = "machineId", nullable = false)
    private Machine machineByMachineId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return planId == plan.planId && Objects.equals(plannedDate, plan.plannedDate) && Objects.equals(completionStatus, plan.completionStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, plannedDate, completionStatus);
    }
}
