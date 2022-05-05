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
public class UserPlanPK implements Serializable {
    @Column(name = "planId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long planId;
    @Column(name = "userId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPlanPK that = (UserPlanPK) o;
        return planId == that.planId && userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, userId);
    }
}
