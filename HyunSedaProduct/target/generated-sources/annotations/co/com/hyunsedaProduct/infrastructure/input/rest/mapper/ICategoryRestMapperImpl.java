package co.com.hyunsedaProduct.infrastructure.input.rest.mapper;

import co.com.hyunsedaProduct.domain.model.Category;
import co.com.hyunsedaProduct.domain.model.Category.CategoryBuilder;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.request.CategoryCreateRequest;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.response.CategoryCreateResponse;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.response.CategoryCreateResponse.CategoryCreateResponseBuilder;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.response.CategoryQueryResponse;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.response.CategoryQueryResponse.CategoryQueryResponseBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class ICategoryRestMapperImpl implements ICategoryRestMapper {

    @Override
    public Category toCategory(CategoryCreateRequest categoryCreateRequest) {
        if ( categoryCreateRequest == null ) {
            return null;
        }

        CategoryBuilder category = Category.builder();

        return category.build();
    }

    @Override
    public CategoryCreateResponse toCategoryCreateResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryCreateResponseBuilder categoryCreateResponse = CategoryCreateResponse.builder();

        categoryCreateResponse.categoryId( category.getCategoryId() );
        categoryCreateResponse.categoryName( category.getCategoryName() );

        return categoryCreateResponse.build();
    }

    @Override
    public CategoryQueryResponse toCategoryQueryResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryQueryResponseBuilder categoryQueryResponse = CategoryQueryResponse.builder();

        categoryQueryResponse.categoryId( category.getCategoryId() );
        categoryQueryResponse.categoryName( category.getCategoryName() );

        return categoryQueryResponse.build();
    }
}
