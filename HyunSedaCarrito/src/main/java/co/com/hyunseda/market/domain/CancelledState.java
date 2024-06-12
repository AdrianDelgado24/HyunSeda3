package co.com.hyunseda.market.domain;

/**
 * Estado de orden cancelado: Recibe 0 productos gratis
 * 
 */
public class CancelledState extends State {

    public void sendMailToAccountHolder() {
        System.out.println("Attention: Your order was cancelled");
    }

    public CancelledState(Order account) {
        super(account);
        sendMailToAccountHolder();
    	setStateName("Cancelado");
    }

    public CancelledState(State source) {
        super(source);
        sendMailToAccountHolder();
    	setStateName("Cancelado");
    }

    public State transitionState() {
        double productsQuantity = getContext().getProductsQuantity();
        if (productsQuantity > Order.MIN_PRODUCTSQUANTITY && productsQuantity < Order.MAX_PRODUCTSQUANTITY) {
            getContext().setObjState(new CancelledState(this));
        } else {
            getContext().setObjState(new CancelledState(this));
        }
        return getContext().getObjState();
    }

    public boolean shipment(double additionalProducts) {
        double productsQuantity = getContext().getProductsQuantity();
        getContext().setProductsQuantity(productsQuantity + Order.FREE_PRODUCTS_CANCELLED);
        System.out.println("You will receive 0 free products due to your order status (Cancelled)");
        return super.shipment(additionalProducts);
    }
}
