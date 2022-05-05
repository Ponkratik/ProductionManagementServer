package by.b_p.productionmanagementserver.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Machine {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "machineId")
    private long machineId;
    @Basic
    @Column(name = "capacity")
    private Timestamp capacity;
    @ManyToOne
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
    private Department departmentByDepartmentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Machine machine = (Machine) o;
        return machineId == machine.machineId && Objects.equals(capacity, machine.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(machineId, capacity);
    }
}
