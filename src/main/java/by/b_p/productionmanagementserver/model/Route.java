package by.b_p.productionmanagementserver.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Route {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "routeId")
    private long routeId;
    @Basic
    @Column(name = "route_name")
    private String routeName;
    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId", nullable = false)
    private Product productByProductId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return routeId == route.routeId && Objects.equals(routeName, route.routeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, routeName);
    }
}
