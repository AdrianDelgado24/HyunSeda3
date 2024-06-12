package co.com.hyunsedaProduct.infrastructure.input.rest.mapper;

import co.com.hyunsedaProduct.domain.model.Category;
import co.com.hyunsedaProduct.domain.model.Product;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.request.ProductCreateRequest;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.response.ProductCreateResponse;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.response.ProductQueryResponse;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface IProductRestMapper {

    Product toProduct(ProductCreateRequest productCreateRequest);
    ProductCreateResponse toProductCreateResponse(Product product);
    ProductQueryResponse toProductQueryResponse(Product product);

    default List<String> mapCategoriesToNames(List<Category> categories) {
        return categories.stream()
                .map(Category::getCategoryName)
                .collect(Collectors.toList());
    }

}
