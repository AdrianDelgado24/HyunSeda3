package co.com.hyunsedaProduct.aplication.port.output;

import co.com.hyunsedaProduct.domain.event.CategoryCreatedEvent;

public interface ICategoryEventPublisher {
    void publishCategoryCreatedEvent(CategoryCreatedEvent categoryEvent);
}
