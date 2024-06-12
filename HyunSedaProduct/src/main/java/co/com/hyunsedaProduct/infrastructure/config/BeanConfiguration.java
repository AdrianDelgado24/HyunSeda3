package co.com.hyunsedaProduct.infrastructure.config;

import co.com.hyunsedaProduct.domain.service.ProductService;
import co.com.hyunsedaProduct.infrastructure.output.CategoryPersistenceAdapter;
import co.com.hyunsedaProduct.infrastructure.output.ProductPersistenceAdapter;
import co.com.hyunsedaProduct.infrastructure.output.eventpublisher.CategoryEventPublisherAdapter;
import co.com.hyunsedaProduct.infrastructure.output.eventpublisher.ProductEventPublisherAdapter;
import co.com.hyunsedaProduct.infrastructure.output.persistence.mapper.ICategoryPersistenceMapper;
import co.com.hyunsedaProduct.infrastructure.output.persistence.mapper.IProductPersistenceMapper;
import co.com.hyunsedaProduct.infrastructure.output.persistence.repository.ICategoryDao;
import co.com.hyunsedaProduct.infrastructure.output.persistence.repository.ICategoryRepository;
import co.com.hyunsedaProduct.infrastructure.output.persistence.repository.IProductRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    /**
     * Crea un bean para ProductPersistenceAdapter.
     *
     * @param productRepository El repositorio de productos.
     * @param productPersistenceMapper El mapper de persistencia de productos.
     * @return Una instancia de ProductPersistenceAdapter.
     */
   @Bean
    public ProductPersistenceAdapter productPersistenceAdapter(IProductRepository productRepository, IProductPersistenceMapper productPersistenceMapper) {
        return new ProductPersistenceAdapter(productRepository, productPersistenceMapper);
    }

    /**
     * Crea un bean para ProductEventPublisherAdapter.
     *
     * @param applicationEventPublisher El publicador de eventos de la aplicación.
     * @return Una instancia de ProductEventPublisherAdapter.
     */
    @Bean
    public ProductEventPublisherAdapter productEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new ProductEventPublisherAdapter(applicationEventPublisher);
    }

    /**
     * Crea un bean para CategoryPersistenceAdapter.
     *
     * @param categoryDao El DAO de categorías.
     * @param categoryRepository El repositorio de categorías.
     * @param categoryPersistenceMapper El mapper de persistencia de categorías.
     * @return Una instancia de CategoryPersistenceAdapter.
     */
    @Bean
    public CategoryPersistenceAdapter categoryPersistenceAdapter(ICategoryDao categoryDao, ICategoryRepository categoryRepository, ICategoryPersistenceMapper categoryPersistenceMapper) {
        return new CategoryPersistenceAdapter(categoryDao,categoryRepository, categoryPersistenceMapper);
    }

    /**
     * Crea un bean para CategoryEventPublisherAdapter.
     *
     * @param applicationEventPublisher El publicador de eventos de la aplicación.
     * @return Una instancia de CategoryEventPublisherAdapter.
     */
    @Bean
    public CategoryEventPublisherAdapter categoryEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new CategoryEventPublisherAdapter(applicationEventPublisher);
    }

    /*@Bean
    public ProductService productService(ProductPersistenceAdapter productPersistenceAdapter, ProductEventPublisherAdapter productEventPublisherAdapter) {
        return new ProductService(productPersistenceAdapter, productEventPublisherAdapter);
    }*/
}


