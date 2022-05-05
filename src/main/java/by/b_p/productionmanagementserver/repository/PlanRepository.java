package by.b_p.productionmanagementserver.repository;

import by.b_p.productionmanagementserver.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}