package co.com.hyunseda.market.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Felipe Pino
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pay {

    @JsonProperty("payId")
    private long payId;

    @JsonProperty("payValue")
    private double totalPago;

    @JsonProperty("clientId")
    private long codigoCuenta;

    @JsonProperty("payPlatform")
    private String plataformaPago;

    @JsonProperty("orderId")
    private long orderId;

    public Pay() {

    }

    public Pay(long payId, double totalPago, long codigoCuenta, String plataformaPago, long orderId) {
        this.payId = payId;
        this.totalPago = totalPago;
        this.codigoCuenta = codigoCuenta;
        this.plataformaPago = plataformaPago;
        this.orderId = orderId;
    }

    public long getPayId() {
        return payId;
    }

    public void setPayId(long payId) {
        this.payId = payId;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

    public long getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(long codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getPlataformaPago() {
        return plataformaPago;
    }

    public void setPlataformaPago(String plataformaPago) {
        this.plataformaPago = plataformaPago;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

}
