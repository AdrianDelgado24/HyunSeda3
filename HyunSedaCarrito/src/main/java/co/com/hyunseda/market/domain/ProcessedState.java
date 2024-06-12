package co.com.hyunseda.market.domain;

/**
 * Estado de la orden: procesado. Recibe 3 productos gratis
 *
 * @author Felipe Pino
 */
public class ProcessedState extends State {

    public void sendMailToAccountHolder() {
        System.out.println("Attention: Your order has been processed");
    }

    public ProcessedState(Order account) {
        super(account);
        sendMailToAccountHolder();
    	setStateName("Procesado");
    }

    public ProcessedState(State source) {
        super(source);
        sendMailToAccountHolder();
    	setStateName("Procesado");
    }

    public State transitionState() {
        double productsQuantity = getContext().getProductsQuantity();
        if (productsQuantity > Order.MIN_PRODUCTSQUANTITY && productsQuantity < Order.MAX_PRODUCTSQUANTITY) {
            getContext().setObjState(new EmbarkedState(this));
        } else {
            getContext().setObjState(new CancelledState(this));
        }
        return getContext().getObjState();
    }

    public boolean shipment(double additionalProducts) {
        double productsQuantity = getContext().getProductsQuantity();
        getContext().setProductsQuantity(productsQuantity + Order.FREE_PRODUCTS_PROCESSED);
        System.out.println("You will receive 3 free products due to your order status (Received)");
        return super.shipment(additionalProducts);
    }
}
