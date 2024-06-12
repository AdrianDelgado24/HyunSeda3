package co.com.hyunsedaProduct.aplication.port.output;

import co.com.hyunsedaProduct.domain.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryOutputPort {
    Category save(Category category);
    List<Category> findAll();
    Optional<Category> findById(Long idCategory);
}
