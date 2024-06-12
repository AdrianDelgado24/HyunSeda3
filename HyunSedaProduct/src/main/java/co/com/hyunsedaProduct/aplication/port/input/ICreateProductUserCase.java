package co.com.hyunsedaProduct.aplication.port.input;

import co.com.hyunsedaProduct.domain.model.Product;
import co.com.hyunsedaProduct.domain.exception.ProductDomainException;

public interface ICreateProductUserCase {
    Product create(Product product) throws ProductDomainException;
}
