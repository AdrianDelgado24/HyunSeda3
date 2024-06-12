package co.com.hyunsedaProduct.infrastructure.input.rest.mapper;

import co.com.hyunsedaProduct.domain.model.Product;
import co.com.hyunsedaProduct.domain.model.Product.ProductBuilder;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.request.ProductCreateRequest;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.response.ProductCreateResponse;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.response.ProductCreateResponse.ProductCreateResponseBuilder;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.response.ProductQueryResponse;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.response.ProductQueryResponse.ProductQueryResponseBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class IProductRestMapperImpl implements IProductRestMapper {

    @Override
    public Product toProduct(ProductCreateRequest productCreateRequest) {
        if ( productCreateRequest == null ) {
            return null;
        }

        ProductBuilder product = Product.builder();

        return product.build();
    }

    @Override
    public ProductCreateResponse toProductCreateResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductCreateResponseBuilder productCreateResponse = ProductCreateResponse.builder();

        productCreateResponse.productId( product.getProductId() );
        productCreateResponse.productName( product.getProductName() );
        productCreateResponse.productDescripcion( product.getProductDescripcion() );
        productCreateResponse.productPrice( product.getProductPrice() );
        productCreateResponse.productStock( (double) product.getProductStock() );
        productCreateResponse.keywords( product.getKeywords() );
        productCreateResponse.productCaracteristc( product.getProductCaracteristc() );
        productCreateResponse.productPhoto( product.getProductPhoto() );

        return productCreateResponse.build();
    }

    @Override
    public ProductQueryResponse toProductQueryResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductQueryResponseBuilder productQueryResponse = ProductQueryResponse.builder();

        productQueryResponse.productId( product.getProductId() );
        productQueryResponse.productName( product.getProductName() );
        productQueryResponse.productDescripcion( product.getProductDescripcion() );
        productQueryResponse.productPrice( product.getProductPrice() );
        productQueryResponse.productStock( (double) product.getProductStock() );
        productQueryResponse.keywords( product.getKeywords() );
        productQueryResponse.productCaracteristc( product.getProductCaracteristc() );
        productQueryResponse.productPhoto( product.getProductPhoto() );

        return productQueryResponse.build();
    }
}
