package co.com.hyunsedaProduct.infrastructure.output.persistence.mapper;

import co.com.hyunsedaProduct.domain.model.Product;
import co.com.hyunsedaProduct.domain.model.Product.ProductBuilder;
import co.com.hyunsedaProduct.infrastructure.output.persistence.entity.ProductEntity;
import co.com.hyunsedaProduct.infrastructure.output.persistence.entity.ProductEntity.ProductEntityBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class IProductPersistenceMapperImpl implements IProductPersistenceMapper {

    @Override
    public ProductEntity toProductEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntityBuilder productEntity = ProductEntity.builder();

        productEntity.productId( product.getProductId() );
        productEntity.productName( product.getProductName() );
        productEntity.productDescripcion( product.getProductDescripcion() );
        productEntity.productPrice( product.getProductPrice() );
        productEntity.productStock( product.getProductStock() );
        productEntity.keywords( product.getKeywords() );
        productEntity.productCaracteristc( product.getProductCaracteristc() );
        productEntity.productPhoto( product.getProductPhoto() );

        return productEntity.build();
    }

    @Override
    public Product toProduct(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductBuilder product = Product.builder();

        product.productId( productEntity.getProductId() );
        product.productName( productEntity.getProductName() );
        product.productDescripcion( productEntity.getProductDescripcion() );
        product.productPrice( productEntity.getProductPrice() );
        product.productStock( productEntity.getProductStock() );
        product.keywords( productEntity.getKeywords() );
        product.productCaracteristc( productEntity.getProductCaracteristc() );
        product.productPhoto( productEntity.getProductPhoto() );

        return product.build();
    }

    @Override
    public List<Product> toProducts(List<ProductEntity> productEntities) {
        if ( productEntities == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productEntities.size() );
        for ( ProductEntity productEntity : productEntities ) {
            list.add( toProduct( productEntity ) );
        }

        return list;
    }
}
