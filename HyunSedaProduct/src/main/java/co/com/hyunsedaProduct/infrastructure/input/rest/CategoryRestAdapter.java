package co.com.hyunsedaProduct.infrastructure.input.rest;

import co.com.hyunsedaProduct.aplication.port.input.ICreateCategoryUserCase;
import co.com.hyunsedaProduct.aplication.port.input.IGetCategoryUserCase;
import co.com.hyunsedaProduct.domain.model.Category;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.request.CategoryCreateRequest;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.response.CategoryCreateResponse;
import co.com.hyunsedaProduct.infrastructure.input.rest.data.response.CategoryQueryResponse;
import co.com.hyunsedaProduct.infrastructure.input.rest.mapper.ICategoryRestMapper;
import co.com.hyunsedaProduct.domain.exception.CategoryDomainException;
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
 * Controlador REST para manejar las operaciones relacionadas con las categorías.
 */

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryRestAdapter {

    private final ICreateCategoryUserCase createCategoryUseCase;
    private final IGetCategoryUserCase getCategoryUseCase;
    private final ICategoryRestMapper categoryRestMapper;

    /**
     * Crea una nueva categoría.
     *
     * @param categoryCreateRequest la solicitud de creación de la categoría.
     * @return una respuesta con la categoría creada.
     * @throws CategoryDomainException si ocurre un error en el dominio al crear la categoría.
     */
    @PostMapping
    public ResponseEntity<CategoryCreateResponse> createCategory(@RequestBody @Valid CategoryCreateRequest categoryCreateRequest) throws CategoryDomainException {
        Category category = categoryRestMapper.toCategory(categoryCreateRequest);
        category = createCategoryUseCase.create(category);
        return new ResponseEntity<>(categoryRestMapper.toCategoryCreateResponse(category), HttpStatus.CREATED);
    }

    /**
     * Obtiene una categoría por su identificador.
     *
     * @param id el identificador de la categoría.
     * @return una respuesta con la categoría encontrada.
     * @throws ResourceNotFoundException si la categoría no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoryQueryResponse> getCategoryById(@PathVariable Long id) throws ResourceNotFoundException {
        Category category = getCategoryUseCase.findById(id);
        return new ResponseEntity<>(categoryRestMapper.toCategoryQueryResponse(category), HttpStatus.OK);
    }

    /**
     * Obtiene todas las categorías.
     *
     * @return una respuesta con la lista de todas las categorías.
     */
    @GetMapping
    public ResponseEntity<List<CategoryQueryResponse>> getAllCategories() {
        List<Category> categories = getCategoryUseCase.findAll();
        List<CategoryQueryResponse> response = categories.stream()
                .map(categoryRestMapper::toCategoryQueryResponse)
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
