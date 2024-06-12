package co.com.hyunsedaProduct.infrastructure.input.rest.data.request;

import jakarta.validation.constraints.NotEmpty;

public class CategoryCreateRequest {

    @NotEmpty(message = "Name may not be empty")
    private String categoryName;
}
