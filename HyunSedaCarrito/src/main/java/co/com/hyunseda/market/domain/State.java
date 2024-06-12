package co.com.hyunseda.market.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Define el comportamiento común de todas las cuentas. Es una clase base
 * concreta.
 *
 * @author Felipe Pino
 */
public class State {

    @JsonProperty("stateId")
    private long stateId;
    @JsonProperty("stateName")
    private String stateName;
    @JsonProperty("context")
    private Order context;

    public State() {
    }

    public State(Order account) {
        setContext(account);
    }

    public Order getContext() {
        return context;
    }

    public void setContext(Order newAccount) {
        context = newAccount;
    }

    public State transitionState() {
        return null;
    }

    public State(State source) {
        setContext(source.getContext());
    }

    public static State InitialState(Order account) {
        return new NotSentState(account);
    }

    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    //deposito
    public boolean shipment(double additionalProducts) {
        double customerProducts = getContext().getProductsQuantity();
        getContext().setProductsQuantity(customerProducts + additionalProducts);
        transitionState();
        System.out.println("An amount of " + getContext().getProductsQuantity() + " will be delivered to your house");
        return true;
    }

}
