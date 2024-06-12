package co.com.hyunsedaProduct.infrastructure.output.persistence.mapper;

import co.com.hyunsedaProduct.domain.model.Category;
import co.com.hyunsedaProduct.infrastructure.output.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryPersistenceMapper {

    CategoryEntity toCategoryEntity(Category category);
    Category toCategory(CategoryEntity categoryEntity);
    List<Category> toCategories(List<CategoryEntity> categoryEntities);
}
