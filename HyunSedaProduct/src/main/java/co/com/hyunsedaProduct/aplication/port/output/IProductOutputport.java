package co.com.hyunsedaProduct.aplication.port.output;

import co.com.hyunsedaProduct.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductOutputport {

    Product saveProduct(Product product);
    List<Product> findAll();
    Optional <Product> findById(Long productId);
    Optional<Product> findByName(String productName);

}
