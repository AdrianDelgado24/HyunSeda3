package co.com.hyunsedaProduct.aplication.port.input;

import co.com.hyunsedaProduct.domain.model.Category;
import co.com.hyunsedaProduct.domain.exception.CategoryDomainException;

public interface ICreateCategoryUserCase {
    Category create(Category category) throws CategoryDomainException;
}
