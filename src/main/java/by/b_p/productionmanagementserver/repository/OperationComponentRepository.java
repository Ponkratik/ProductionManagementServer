package by.b_p.productionmanagementserver.repository;

import by.b_p.productionmanagementserver.model.OperationComponent;
import by.b_p.productionmanagementserver.model.OperationComponentPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationComponentRepository extends JpaRepository<OperationComponent, OperationComponentPK> {
}