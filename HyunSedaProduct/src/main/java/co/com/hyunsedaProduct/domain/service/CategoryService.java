package co.com.hyunsedaProduct.domain.service;

import co.com.hyunsedaProduct.aplication.port.input.ICreateCategoryUserCase;
import co.com.hyunsedaProduct.aplication.port.input.IGetCategoryUserCase;
import co.com.hyunsedaProduct.aplication.port.output.ICategoryOutputPort;
import co.com.hyunsedaProduct.aplication.port.output.ICategoryEventPublisher;
import co.com.hyunsedaProduct.domain.event.CategoryCreatedEvent;
import co.com.hyunsedaProduct.domain.exception.CategoryDomainException;
import co.com.hyunsedaProduct.domain.exception.CategoryError;
import co.com.hyunsedaProduct.domain.exception.ResourceNotFoundException;
import co.com.hyunsedaProduct.domain.model.Category;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService implements ICreateCategoryUserCase, IGetCategoryUserCase {
     /**
     *  Creación de una variable de tipo ICategoryOutputAdapter para poder realizar el CRUD de categorias
     */
    @Autowired
    private ICategoryOutputPort portOutput;
    @Autowired
    private ICategoryEventPublisher eventPubl;

    /**
     * Servicio para buscar todas las categorias
     * @return Listado de categorias
     */
   @Override
    @Transactional(readOnly = true) // Para que esté sincronizada con la bd
    public List<Category> findAll() {
        //return (List<Category>) categoryDao.findAll();
        return portOutput.findAll();
    }

    /**
     * Busca una categoria por su Id
     * @param id codigo de la categoria
     * @return objeto de tipo categoria
     */
    @Override // Para que esté sincronizada con la bd
    public Category findById(Long id) throws ResourceNotFoundException {
        Category cate = portOutput.findById(id).orElse(null);
        if (cate == null) {
            throw new ResourceNotFoundException();
        }
        return cate ;
    }

    /**
     * Crea una nueva categoria
     * @param category categoria a crear en la bd
     * @return Categoria creada
     */
    @Override
    public Category create(Category category) throws CategoryDomainException {
        List<CategoryError> errors = validateDomain(category);
        category = portOutput.save(category);
        eventPubl.publishCategoryCreatedEvent(new CategoryCreatedEvent(category.getCategoryId()));

        if (!errors.isEmpty()) {
            throw new CategoryDomainException(errors);
        }
        //return categoryDao.save(category);
        return category;
    }

     /**
     * Modifica o edita una categoria
     * @param id, codigo de la categoria a modificar
     * @param category categoria con los datos a editar
     * @return Categoria modificado
     */
    @Override
    public Category update(Long id, Category category) throws CategoryDomainException, ResourceNotFoundException {
        Category cate = this.findById(id);
        if (cate == null) {
            throw new ResourceNotFoundException();
        }

        List<CategoryError> errors = validateDomain(category);

        if (!errors.isEmpty()) {
            throw new CategoryDomainException(errors);
        }
        cate.setCategoryName(category.getCategoryName());
        //return categoryDao.save(cate);
        return cate;
    }

    /**
     * Aplica validaciones o reglas del dominio para una Categoria. Antes de ser
     * agregado o modificado.
     *
     * @param category categoria a validar
     * @return lista de errores de validación
     */

    private List<CategoryError> validateDomain(Category category) {
        List<CategoryError> errors = new ArrayList<>();
        if(category.getCategoryId() <= 0){
            errors.add(new CategoryError(ErrorCodes.INVALID_NUMBER, "codigo",
                    "El codigo de la categoria es obligatorio y mayor a cero"));
        }
        if (category.getCategoryName() == null || category.getCategoryName().isBlank()) {
            errors.add(new CategoryError(ErrorCodes.EMPTY_FIELD, "name", "El nombre de la categoria es obligatoria"));
        }
        return errors;
    }
}


