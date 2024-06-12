package co.com.hyunsedaProduct.infrastructure.output.persistence.repository;

import co.com.hyunsedaProduct.infrastructure.output.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<ProductEntity,Long> {
    @Query("SELECT p FROM ProductEntity p WHERE p.productName LIKE %:productName%")
    ProductEntity findByName(@Param("productName") String productName);
}

