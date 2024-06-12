package co.com.hyunsedaProduct.infrastructure.output;

import co.com.hyunsedaProduct.aplication.port.output.IProductOutputport;
import co.com.hyunsedaProduct.domain.model.Product;
import co.com.hyunsedaProduct.infrastructure.output.persistence.entity.ProductEntity;
import co.com.hyunsedaProduct.infrastructure.output.persistence.mapper.IProductPersistenceMapper;
import co.com.hyunsedaProduct.infrastructure.output.persistence.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de persistencia para las operaciones relacionadas con los productos.
 */
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements IProductOutputport {
    /**
     * Repositorio para las operaciones de persistencia de productos.
     */
    @Autowired
    private final IProductRepository productRepository;
    /**
     * Mapper para convertir entre entidades de persistencia y objetos de dominio de productos.
     */
    @Autowired
    private final IProductPersistenceMapper productPersistenceMapper;

    /**
     * Guarda un producto en la base de datos.
     *
     * @param product el producto a guardar.
     * @return el producto guardado.
     */
    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = productPersistenceMapper.toProductEntity(product);
        productEntity = productRepository.save(productEntity);
        return productPersistenceMapper.toProduct(productEntity);
    }

    /**
     * Obtiene todos los productos de la base de datos.
     *
     * @return una lista de todos los productos.
     */
    @Override
    public List<Product> findAll() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productPersistenceMapper.toProducts(productEntities);
    }

    /**
     * Encuentra un producto por su identificador en la base de datos.
     *
     * @param productId el identificador del producto.
     * @return un producto opcional que coincide con el identificador.
     */
    @Override
    public Optional<Product> findById(Long productId) {
        Optional<ProductEntity> productEntity = productRepository.findById(productId);

        if(productEntity.isEmpty()) {
            return Optional.empty();
        }

        Product product = productPersistenceMapper.toProduct(productEntity.get());
        return Optional.of(product);
    }

    /**
     * Encuentra un producto por su nombre en la base de datos.
     *
     * @param productName el nombre del producto.
     * @return un producto opcional que coincide con el nombre.
     */
    @Override
    public Optional<Product> findByName(String productName) {
        ProductEntity productEntity = productRepository.findByName(productName);
        if (productEntity == null) {
            return Optional.empty();
        }
        return Optional.of(productPersistenceMapper.toProduct(productEntity));
    }
}
