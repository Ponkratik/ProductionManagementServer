package by.b_p.productionmanagementserver.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Component {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "componentId")
    private long componentId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "unit")
    private String unit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return componentId == component.componentId && Objects.equals(name, component.name) && Objects.equals(unit, component.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentId, name, unit);
    }
}
