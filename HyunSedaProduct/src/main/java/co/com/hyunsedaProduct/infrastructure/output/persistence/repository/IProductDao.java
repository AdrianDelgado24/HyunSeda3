package co.com.hyunsedaProduct.infrastructure.output.persistence.repository;

import co.com.hyunsedaProduct.infrastructure.output.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

/**Interfaces DAO de productos*/
public interface IProductDao extends CrudRepository<ProductEntity,Long> {
}
