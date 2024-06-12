package co.com.hyunsedaProduct.infrastructure.output.persistence.mapper;

import co.com.hyunsedaProduct.domain.model.Product;
import co.com.hyunsedaProduct.infrastructure.output.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductPersistenceMapper {

    ProductEntity toProductEntity(Product product);
    Product toProduct(ProductEntity productEntity);
    List<Product> toProducts(List<ProductEntity> productEntities);
}
