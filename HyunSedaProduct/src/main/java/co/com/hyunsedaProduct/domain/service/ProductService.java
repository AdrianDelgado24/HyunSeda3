package co.com.hyunsedaProduct.domain.service;

import co.com.hyunsedaProduct.aplication.port.input.ICreateProductUserCase;
import co.com.hyunsedaProduct.aplication.port.input.IGetProductUserCase;
import co.com.hyunsedaProduct.aplication.port.output.IProductEventPublisher;
import co.com.hyunsedaProduct.aplication.port.output.IProductOutputport;
import co.com.hyunsedaProduct.domain.event.ProductCreatedEvent;
import co.com.hyunsedaProduct.domain.model.Product;
import co.com.hyunsedaProduct.domain.exception.ProductDomainException;
import co.com.hyunsedaProduct.domain.exception.ProductError;
import co.com.hyunsedaProduct.domain.exception.ProductNotFound;
import co.com.hyunsedaProduct.domain.exception.ResourceNotFoundException;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductService implements ICreateProductUserCase, IGetProductUserCase {

    /**
     *  Creación de una variable de tipo IProductOutputAdapter para poder realizar el CRUD de productos
     */
    @Autowired
    private IProductOutputport portOutput;

    @Autowired
    private IProductEventPublisher eventPubl;

    /**
     * Servicio para buscar todos los productos
     * @return Listado de productos
     */
    @Override
    @Transactional(readOnly = true) // Para que esté sincronizada con la bd
    public List<Product> findAll() {
        return portOutput.findAll();
    }

    /**
     * Busca un producto por su Id
     * @param id codigo del producto
     * @return objeto de tipo producto
     */
    //@Override
    //@Transactional
    public Product findById(Long id) throws ResourceNotFoundException {
        Product prod = portOutput.findById(id).orElseThrow(() -> new ProductNotFound("No se encontro el producto con el ID"+ id));
        if (prod == null) {
            throw new ResourceNotFoundException();
        }
        return prod;
    }
   // @Override
    //@Transactional
    public Product findByName(String productName) throws ResourceNotFoundException  {
        Product prod = portOutput.findByName(productName).orElseThrow(() -> new ProductNotFound("No se encontro el producto con el nombrre"+productName));
        if(prod == null){throw new ResourceNotFoundException();}
        return prod;
    }

    /**
     * Crea un nuevo producto
     *
     * @param product producto a crear en la bd
     * @return Producto creado
     */
    @Override
    @Transactional
    public Product create(Product product) throws ProductDomainException {
        List<ProductError> errors = validateDomain(product);

        product = portOutput.saveProduct(product);
        eventPubl.publishProductCreatedEvent(new ProductCreatedEvent(product.getProductId()));

        if (!errors.isEmpty()) {
            throw new ProductDomainException(errors);
        }
        /*if (product.getCreateAt() == null) {
            product.setCreateAt(new Date());}*/
        return product;
    }

    /**
     * Modifica o edita un producto
     *
     * @param id,     codigo del producto a modificar
     * @param product producto con los datos a editar
     * @return Producto modificado
     */
    /*@Override
    @Transactional
    public Product update(Long id, Product product) throws ProductDomainException, ResourceNotFoundException {
        Product prod = this.findById(id);
        if (prod == null) {
            throw new ResourceNotFoundException();
        }

        List<ProductError> errors = validateDomain(product);

        if (!errors.isEmpty()) {
            throw new ProductDomainException(errors);
        }

        prod.setProductName(product.getProductName());
        prod.setProductPrice(product.getProductPrice());

        return productDao.save(prod);
    }*/

    /**
     * Aplica validaciones o reglas del dominio para un producto. Antes de ser
     * agregado o modificado.
     *
     * @param product producto a validad
     * @return lista de errores de validación
     */

    private List<ProductError> validateDomain(Product product) {
        List<ProductError> errors = new ArrayList<>();

        if (product.getProductId() <= 0) {
            errors.add(new ProductError(ErrorCodes.INVALID_NUMBER, "codigo",
                    "El codigo del producto es obligatorio y mayor a cero"));
        }
        if (product.getProductName() == null || product.getProductName().isBlank()) {
            errors.add(new ProductError(ErrorCodes.EMPTY_FIELD, "name", "El nombre del producto es obligatorio"));
        }

        if (product.getProductPrice() <= 0) {
            errors.add(new ProductError(ErrorCodes.INVALID_NUMBER, "price",
                    "El precio del producto es obligatorio y mayor a cero"));
        }
        if (product.getProductStock() < 0 || product.getProductStock() > 1) {
            errors.add(new ProductError(ErrorCodes.INVALID_NUMBER, "cantidad",
                    "La cantidad del producto es obligatorio y debe estar entre 0 - 1"));
        }
        return errors;
    }
}
