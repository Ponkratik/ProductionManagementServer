package by.b_p.productionmanagementserver.repository;

import by.b_p.productionmanagementserver.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}