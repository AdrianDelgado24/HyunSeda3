package co.com.hyunsedaProduct.infrastructure.output.persistence.repository;

import co.com.hyunsedaProduct.infrastructure.output.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
