package co.com.hyunseda.market.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Funcionalidad basica de un cliente. Con ella el objeto cliente puede hacer operaciones de depósitos y retiros.
 * @author Felipe Pino
 */
public class Order {
    //Contantes para definer los limites de las transacciones
    public static final double MIN_PRODUCTSQUANTITY = 1;
    public static final double MAX_PRODUCTSQUANTITY = 100;
    public static final double FREE_PRODUCTS_NOT_SENT = 1.00;
    public static final double FREE_PRODUCTS_RECEIVED = 2.00;
    public static final double FREE_PRODUCTS_PROCESSED = 3.00;
    public static final double FREE_PRODUCTS_EMBARKED = 4.00;
    public static final double FREE_PRODUCTS_SENT = 5.00;
    public static final double FREE_PRODUCTS_CANCELLED = 0.00;

    //public static final String ERR_OVERDRAW_LIMIT_EXCEED = "Error: Transaction cannot be processed. " + "Overdraw limit exceeded.";
    //Atributos
    @JsonProperty("orderId")
    private long orderId;
    @JsonProperty("objState")
    private State objState;
    @JsonProperty("clientId")
    private long clientId;
    @JsonProperty("productsQuantity")
    private double productsQuantity;

    public Order() {
    }

    public Order(long accountNum) {
    	clientId = accountNum; //Número de cuenta del usuario que hizo la orden
        objState = State.InitialState(this); //El estado de esa orden
    }

    public Order(long orderId, State objState, long clientId, double productsQuantity) {
        this.orderId = orderId;
        this.objState = objState;
        this.clientId = clientId;
        this.productsQuantity = productsQuantity;
    }
    public boolean shipment(double additionalProducts) {
        return getObjState().shipment(additionalProducts);
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public State getObjState() {
        return objState;
    }

    public void setObjState(State objState) {
        this.objState = objState;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public double getProductsQuantity() {
        return productsQuantity;
    }

    public void setProductsQuantity(double productsQuantity) {
        this.productsQuantity = productsQuantity;
    }

    
}
