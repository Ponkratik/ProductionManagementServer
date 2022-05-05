package by.b_p.productionmanagementserver.repository;

import by.b_p.productionmanagementserver.model.UserPlan;
import by.b_p.productionmanagementserver.model.UserPlanPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPlanRepository extends JpaRepository<UserPlan, UserPlanPK> {
}