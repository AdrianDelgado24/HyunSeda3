package co.com.hyunsedaProduct.aplication.port.input;

import co.com.hyunsedaProduct.domain.model.Product;
import co.com.hyunsedaProduct.domain.exception.ProductDomainException;
import co.com.hyunsedaProduct.domain.exception.ResourceNotFoundException;
import java.util.List;

public interface IGetProductUserCase {

    List<Product> findAll();
    Product findById(Long id) throws ResourceNotFoundException;
    Product findByName(String name) throws ResourceNotFoundException;
    Product create(Product product) throws ProductDomainException;
    //Product update(Long id, Product product) throws ProductDomainException, ResourceNotFoundException;
}