package co.com.hyunseda.market.domain;

/**
 * Estado de orden embarcado: Recibe 4 productos gratis
 */
public class EmbarkedState extends State {

    public void sendMailToAccountHolder() {
        System.out.println("Attention: Your Account is Embarked");
    }

    public EmbarkedState(Order account) {
        super(account);
        sendMailToAccountHolder();
    	setStateName("Embarcado");
    }

    public EmbarkedState(State source) {
        super(source);
        sendMailToAccountHolder();
    	setStateName("Embarcado");
    }

    public State transitionState() {
        double productsQuantity = getContext().getProductsQuantity();
        if (productsQuantity > Order.MIN_PRODUCTSQUANTITY && productsQuantity < Order.MAX_PRODUCTSQUANTITY) {
            getContext().setObjState(new SentState(this));
        } else {
            getContext().setObjState(new CancelledState(this));
        }
        return getContext().getObjState();
    }

    public boolean shipment(double additionalProducts) {
        double productsQuantity = getContext().getProductsQuantity();
        getContext().setProductsQuantity(productsQuantity + Order.FREE_PRODUCTS_EMBARKED);
        System.out.println("You will receive 4 free products due to your order status (Embarked)");
        return super.shipment(additionalProducts);
    }
}
