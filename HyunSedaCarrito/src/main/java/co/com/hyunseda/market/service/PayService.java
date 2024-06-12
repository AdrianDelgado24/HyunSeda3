package co.com.hyunseda.market.service;

import co.com.hyunseda.market.domain.Pay;
import co.com.hyunseda.market.domain.acess.IPayRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe Pino
 */
public class PayService {

    private Pay pay;
    private IPayRepository repository;

    /**
     * Inyección de dependencias en el constructor. Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     * @param repository una clase hija de IPayRepository
     */
    public PayService(IPayRepository repository) {
        this.repository = repository;
    }

    public boolean savePay(long payId, double totalPago, long codigoCuenta, String plataformaPago, long orderId) {

        Pay newPay = new Pay();
        newPay.setPayId(payId);
        newPay.setTotalPago(totalPago);
        newPay.setCodigoCuenta(codigoCuenta);
        newPay.setPlataformaPago(plataformaPago);
        newPay.setOrderId(orderId);

        if (newPay.getPayId() <= 0 || newPay.getTotalPago() <= 0 || newPay.getOrderId() <= 0 || newPay.getCodigoCuenta() <= 0) {
            return false;
        }

        return repository.save(newPay);
    }

    public List<Pay> findAllPay() {
        List<Pay> pays = new ArrayList<>();
        pays = repository.findAll();
        return pays;
    }

    public boolean editPay(long payId, Pay pay) {

        /*//Validate pay
        if (pay == null || pay.getPayName().isEmpty() ) {
            return false;
        }
        repository.edit(payId, prod);*/
        return true;
    }

    public boolean deletePay(long payId) {
        return repository.delete(payId);
    }

    public Pay findPayById(long payId) {
        return repository.findById(payId);
    }

}
