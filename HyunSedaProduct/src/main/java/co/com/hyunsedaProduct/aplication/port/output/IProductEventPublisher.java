package co.com.hyunsedaProduct.aplication.port.output;

import co.com.hyunsedaProduct.domain.event.ProductCreatedEvent;

public interface IProductEventPublisher {
    void publishProductCreatedEvent(ProductCreatedEvent productEvent);
}
