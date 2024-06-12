package co.com.hyunseda.market.domain.acess;

import co.com.hyunseda.market.domain.Order;
import co.com.hyunseda.market.domain.Pay;
import java.util.List;

/**
 *
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian
 * Fernando Delgado Serna, Felipe Armand Pino Sierra
 */
public interface IOrderRepository {

    List<Order> findAll();

    Order findById(long productId);

    boolean save(Order newOrder); 
    
    boolean save(long orderId, Pay newPay);

    boolean edit(long orderId, Order order);

    boolean delete(long orderId);

}
