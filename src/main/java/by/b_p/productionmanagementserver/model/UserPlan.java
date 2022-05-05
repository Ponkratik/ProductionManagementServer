package by.b_p.productionmanagementserver.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_plan", schema = "rppba2")
@IdClass(UserPlanPK.class)
@Getter
@Setter
public class UserPlan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "planId")
    private long planId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userId")
    private long userId;
    @ManyToOne
    @JoinColumn(name = "planId", referencedColumnName = "planId", updatable = false, insertable = false, nullable = false)
    private Plan planByPlanId;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId", updatable = false, insertable = false, nullable = false)
    private User userByUserId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPlan userPlan = (UserPlan) o;
        return planId == userPlan.planId && userId == userPlan.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, userId);
    }
}
