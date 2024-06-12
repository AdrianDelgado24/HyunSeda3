package co.com.hyunsedaProduct.infrastructure.input.rest.data.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductQueryResponse {

    private Long productId;
    private String productName;
    private String productDescripcion;
    private Double productPrice;
    private Double productStock;
    private String keywords;
    private String productCaracteristc;
    private String productPhoto;
    private List<String> categories;
}
