package co.com.hyunsedaProduct.infrastructure.output.persistence.mapper;

import co.com.hyunsedaProduct.domain.model.Category;
import co.com.hyunsedaProduct.domain.model.Category.CategoryBuilder;
import co.com.hyunsedaProduct.infrastructure.output.persistence.entity.CategoryEntity;
import co.com.hyunsedaProduct.infrastructure.output.persistence.entity.CategoryEntity.CategoryEntityBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class ICategoryPersistenceMapperImpl implements ICategoryPersistenceMapper {

    @Override
    public CategoryEntity toCategoryEntity(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryEntityBuilder categoryEntity = CategoryEntity.builder();

        categoryEntity.categoryId( category.getCategoryId() );
        categoryEntity.categoryName( category.getCategoryName() );

        return categoryEntity.build();
    }

    @Override
    public Category toCategory(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryBuilder category = Category.builder();

        category.categoryId( categoryEntity.getCategoryId() );
        category.categoryName( categoryEntity.getCategoryName() );

        return category.build();
    }

    @Override
    public List<Category> toCategories(List<CategoryEntity> categoryEntities) {
        if ( categoryEntities == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( categoryEntities.size() );
        for ( CategoryEntity categoryEntity : categoryEntities ) {
            list.add( toCategory( categoryEntity ) );
        }

        return list;
    }
}
