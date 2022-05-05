package by.b_p.productionmanagementserver.repository;

import by.b_p.productionmanagementserver.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepository extends JpaRepository<Machine, Long> {
}