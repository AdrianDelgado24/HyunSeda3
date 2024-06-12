package co.com.hyunseda.market.service;

import co.com.hyunseda.market.domain.NotSentState;
import co.com.hyunseda.market.domain.Order;
import co.com.hyunseda.market.domain.State;
import co.com.hyunseda.market.domain.acess.IOrderRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe Pino
 */
public class OrderService {

    private Order order;
    private IOrderRepository repository;

    /**
     * Inyección de dependencias en el constructor. Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     * @param repository una clase hija de IOrderRepository
     */
    public OrderService(IOrderRepository repository) {
        this.repository = repository;
    }

    public boolean saveOrder(long orderId, long codigoCuenta, double productsQuantity) {
        Order newOrder = new Order();
        newOrder.setOrderId(orderId);
        newOrder.setClientId(codigoCuenta);
        newOrder.setProductsQuantity(productsQuantity);
        State newState = new State(newOrder);
        newState.setStateId(orderId);
        if (newOrder.getOrderId() <= 0 || newOrder.getClientId() <= 0) {
            return false;
        }

        return repository.save(newOrder);
    }

    public List<Order> findAllOrder() {
        List<Order> orders = new ArrayList<>();
        orders = repository.findAll();
        return orders;
    }

    public boolean editOrder(long orderId, Order order) {
        if (order == null || order.getOrderId() <= 0 || findOrderById(orderId) == null) {
            return false;
        }
        repository.edit(orderId, order);
        return true;
    }

    public boolean deleteOrder(long orderId) {
        return repository.delete(orderId);
    }

    public Order findOrderById(long orderId) {
        return repository.findById(orderId);
    }

}
