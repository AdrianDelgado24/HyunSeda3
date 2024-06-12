package co.com.hyunsedaProduct.infrastructure.input.rest.data.request;

import jakarta.validation.constraints.NotEmpty;

public class ProductCreateRequest {
    @NotEmpty(message = "Name may not be empty")
    private String productName;

    @NotEmpty(message = "Description may not be empty")
    private String productDescripcion;

    @NotEmpty(message = "Description may not be empty")
    private String productCaracteristc;
    @NotEmpty(message = "Description may not be empty")

    private String productPhoto;
    @NotEmpty(message = "Description may not be empty")
    private String keywords;

}
