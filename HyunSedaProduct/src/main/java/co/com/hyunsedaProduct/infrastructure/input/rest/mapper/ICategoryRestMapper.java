package co.com.hyunsedaProduct.infrastructure.input.rest.mapper;

import co.com.hyunsedaProduct.domain.model.Category;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.request.CategoryCreateRequest;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.response.CategoryCreateResponse;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.response.CategoryQueryResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ICategoryRestMapper {

    Category toCategory(CategoryCreateRequest categoryCreateRequest);
    CategoryCreateResponse toCategoryCreateResponse(Category category);
    CategoryQueryResponse toCategoryQueryResponse(Category category);
}
