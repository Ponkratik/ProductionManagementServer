package by.b_p.productionmanagementserver.repository;

import by.b_p.productionmanagementserver.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}