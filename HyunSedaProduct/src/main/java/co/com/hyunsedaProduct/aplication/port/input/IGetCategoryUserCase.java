package co.com.hyunsedaProduct.aplication.port.input;

import co.com.hyunsedaProduct.domain.model.Category;
import co.com.hyunsedaProduct.domain.exception.CategoryDomainException;
import co.com.hyunsedaProduct.domain.exception.ResourceNotFoundException;

import java.util.List;

public interface IGetCategoryUserCase {

    List<Category> findAll();
    Category findById(Long id) throws ResourceNotFoundException;
    Category create(Category category) throws CategoryDomainException;
    Category update(Long id, Category category) throws CategoryDomainException, ResourceNotFoundException;
}