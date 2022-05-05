package by.b_p.productionmanagementserver.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Department {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "departmentId")
    private long departmentId;
    @Basic
    @Column(name = "department_name")
    private String departmentName;
    @Basic
    @Column(name = "department_name_local")
    private String departmentNameLocal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentId == that.departmentId && Objects.equals(departmentName, that.departmentName) && Objects.equals(departmentNameLocal, that.departmentNameLocal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, departmentName, departmentNameLocal);
    }
}
