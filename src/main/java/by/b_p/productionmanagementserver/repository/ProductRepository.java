package by.b_p.productionmanagementserver.repository;

import by.b_p.productionmanagementserver.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}