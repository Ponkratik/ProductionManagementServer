package by.b_p.productionmanagementserver.repository;

import by.b_p.productionmanagementserver.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component, Long> {
}