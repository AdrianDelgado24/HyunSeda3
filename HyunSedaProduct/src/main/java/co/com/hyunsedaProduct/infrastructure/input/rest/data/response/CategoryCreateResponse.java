package co.com.hyunsedaProduct.infrastructure.input.rest.data.response;

import co.com.hyunsedaProduct.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryCreateResponse {

    private long categoryId;
    private String categoryName;
    private List<Product> products;
}
