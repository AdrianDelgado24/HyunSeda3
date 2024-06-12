package co.com.hyunseda.market.domain.acess;

import co.com.hyunseda.market.domain.Pay;
import java.util.List;

/**
 *
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian
 * Fernando Delgado Serna, Felipe Armand Pino Sierra
 */
public interface IPayRepository {

    List<Pay> findAll();

    Pay findById(long productId);

    boolean save(Pay newPay); //Lo guarda en un repositorio

    boolean edit(long payId, Pay pay);

    boolean delete(long payId);

}
