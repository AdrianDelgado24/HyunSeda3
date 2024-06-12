package co.com.hyunsedaProduct.infrastructure.input.rest;

import co.com.hyunsedaProduct.aplication.port.input.ICreateProductUserCase;
import co.com.hyunsedaProduct.aplication.port.input.IGetProductUserCase;
import co.com.hyunsedaProduct.domain.model.Product;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.request.ProductCreateRequest;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.response.ProductCreateResponse;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.response.ProductQueryResponse;
import co.com.hyunsedaProduct.infrastructure.input.rest.mapper.IProductRestMapper;
import co.com.hyunsedaProduct.domain.exception.ProductDomainException;
import co.com.hyunsedaProduct.domain.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador REST para manejar las operaciones relacionadas con los productos.
 */
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductRestAdapter {

    private final ICreateProductUserCase createProductUseCase;
    private final IGetProductUserCase getProductUseCase;
    private final IProductRestMapper productRestMapper;

    /**
     * Crea un nuevo producto.
     *
     * @param productCreateRequest la solicitud de creación del producto.
     * @return la respuesta de la creación del producto.
     * @throws ProductDomainException si hay un problema con el dominio del producto.
     */
    @PostMapping
    public ResponseEntity<ProductCreateResponse> createProduct(@RequestBody @Valid ProductCreateRequest productCreateRequest) throws ProductDomainException {

        Product product = productRestMapper.toProduct(productCreateRequest);
        product = createProductUseCase.create(product);

        return new ResponseEntity<>(productRestMapper.toProductCreateResponse(product), HttpStatus.CREATED);
    }

    /**
     * Obtiene un producto por su identificador.
     *
     * @param id el identificador del producto.
     * @return la respuesta de la consulta del producto.
     * @throws ResourceNotFoundException si el producto no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductQueryResponse> getProductById(@PathVariable Long id) throws ResourceNotFoundException {
        Product product = getProductUseCase.findById(id);
        return new ResponseEntity<>(productRestMapper.toProductQueryResponse(product), HttpStatus.OK);
    }

    /**
     * Obtiene todos los productos.
     *
     * @return una lista de respuestas de consulta de los productos.
     */
    @GetMapping
    public ResponseEntity<List<ProductQueryResponse>> getAllProducts() {
        List<Product> products = getProductUseCase.findAll();
        List<ProductQueryResponse> response = products.stream()
                .map(productRestMapper::toProductQueryResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Obtiene un producto por su nombre.
     *
     * @param name el nombre del producto.
     * @return la respuesta de la consulta del producto.
     * @throws ResourceNotFoundException si el producto no se encuentra.
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<ProductQueryResponse> getProductByName(@PathVariable String name) throws ResourceNotFoundException {
        Product product = getProductUseCase.findByName(name);
        return new ResponseEntity<>(productRestMapper.toProductQueryResponse(product), HttpStatus.OK);
    }

}

