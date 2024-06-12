package co.com.hyunsedaProduct.infrastructure.output.persistence.repository;

import co.com.hyunsedaProduct.infrastructure.output.persistence.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

/**Interfaces DAO de categorias*/
public interface ICategoryDao extends CrudRepository<CategoryEntity,Long> {
}
