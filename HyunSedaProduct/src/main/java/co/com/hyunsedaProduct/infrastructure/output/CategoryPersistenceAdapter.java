package co.com.hyunsedaProduct.infrastructure.output;

import co.com.hyunsedaProduct.aplication.port.output.ICategoryOutputPort;
import co.com.hyunsedaProduct.domain.model.Category;
import co.com.hyunsedaProduct.infrastructure.output.persistence.entity.CategoryEntity;
import co.com.hyunsedaProduct.infrastructure.output.persistence.mapper.ICategoryPersistenceMapper;
import co.com.hyunsedaProduct.infrastructure.output.persistence.repository.ICategoryDao;
import co.com.hyunsedaProduct.infrastructure.output.persistence.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de persistencia para las operaciones relacionadas con las categorías.
 */
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements ICategoryOutputPort {

    private final ICategoryDao categoryDao;
    private final ICategoryRepository categoryRepository;
    private final ICategoryPersistenceMapper categoryPersistenceMapper;

    /**
     * Guarda una categoría en la base de datos.
     *
     * @param category la categoría a guardar.
     * @return la categoría guardada.
     */
    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = categoryPersistenceMapper.toCategoryEntity(category);
        categoryEntity = categoryDao.save(categoryEntity);
        return categoryPersistenceMapper.toCategory(categoryEntity);
    }

    /**
     * Obtiene todas las categorías de la base de datos.
     *
     * @return una lista de todas las categorías.
     */
    @Override
    public List<Category> findAll() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        return categoryPersistenceMapper.toCategories(categoryEntities);
    }

    /**
     * Encuentra una categoría por su identificador en la base de datos.
     *
     * @param idCategory el identificador de la categoría.
     * @return una categoría opcional que coincide con el identificador.
     */
    @Override
    public Optional<Category> findById(Long idCategory) {
        Optional<CategoryEntity> categoryEntity = categoryDao.findById(idCategory);

        if(categoryEntity.isEmpty()) {
            return Optional.empty();
        }

        Category category = categoryPersistenceMapper.toCategory(categoryEntity.get());
        return Optional.of(category);
    }
}
