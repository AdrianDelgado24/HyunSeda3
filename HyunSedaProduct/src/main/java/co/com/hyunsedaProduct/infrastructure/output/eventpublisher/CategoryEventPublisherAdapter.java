package co.com.hyunsedaProduct.infrastructure.output.eventpublisher;

import co.com.hyunsedaProduct.aplication.port.output.ICategoryEventPublisher;
import co.com.hyunsedaProduct.domain.event.CategoryCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

/**
 * Adaptador para publicar eventos de creación de categorías.
 */
@RequiredArgsConstructor
public class CategoryEventPublisherAdapter implements ICategoryEventPublisher {
    /**
     * Publicador de eventos de la aplicación.
     */
    private final ApplicationEventPublisher applicationEventPublisher;

    /**
     * Publica un evento de creación de categoría.
     *
     * @param event el evento de creación de la categoría.
     */
    @Override
    public void publishCategoryCreatedEvent(CategoryCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}

