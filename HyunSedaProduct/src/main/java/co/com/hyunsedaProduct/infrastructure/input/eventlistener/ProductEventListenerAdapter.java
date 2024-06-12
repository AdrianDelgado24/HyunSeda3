package co.com.hyunsedaProduct.infrastructure.input.eventlistener;

import co.com.hyunsedaProduct.domain.event.ProductCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductEventListenerAdapter {

    /**
     * Maneja el evento {@link ProductCreatedEvent} cuando se crea un producto.
     *
     * @param event el evento de creación del producto.
     */
    @EventListener
    public void handle(ProductCreatedEvent event){
        log.info("Product created with id " + event.getId() + " at " + event.getDate());
    }
}
