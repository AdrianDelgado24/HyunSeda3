package co.com.hyunsedaProduct.infrastructure.output.eventpublisher;

import co.com.hyunsedaProduct.aplication.port.output.IProductEventPublisher;
import co.com.hyunsedaProduct.domain.event.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

/**
 * Adaptador para publicar eventos de creación de productos.
 */
@RequiredArgsConstructor
public class ProductEventPublisherAdapter implements IProductEventPublisher {
    /**
     * Publicador de eventos de la aplicación.
     */
    private final ApplicationEventPublisher applicationEventPublisher;

    /**
     * Publica un evento de creación de producto.
     *
     * @param event el evento de creación del producto.
     */
    @Override
    public void publishProductCreatedEvent(ProductCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
