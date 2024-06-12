package co.com.hyunsedaProduct.infrastructure.input.eventlistener;

import co.com.hyunsedaProduct.domain.event.CategoryCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j

public class CategoryEventListenerAdapter {

    /**
     * Maneja el evento {@link CategoryCreatedEvent} cuando se crea una categoría.
     *
     * @param event el evento de creación de la categoría.
     */
    @EventListener
    public void handle(CategoryCreatedEvent event){
        log.info("Category created with id " + event.getId() + " at " + event.getDate());
    }
}
