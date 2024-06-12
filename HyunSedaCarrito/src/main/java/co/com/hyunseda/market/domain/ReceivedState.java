package co.com.hyunseda.market.domain;

/**
 * Estado de la orden recibido: Recibe 2 productos gratis
 *
 * @author Felipe Pino
 */
public class ReceivedState extends State {

    public void sendMailToAccountHolder() {
        System.out.println("Attention: We've received your order");
    }

    public ReceivedState(Order account) {
        super(account);
        sendMailToAccountHolder();
    	setStateName("Recibido");
    }

    public ReceivedState(State source) {
        super(source);
        sendMailToAccountHolder();
    	setStateName("Recibido");
    }

    public State transitionState() {
        double productsQuantity = getContext().getProductsQuantity();
        if (productsQuantity > Order.MIN_PRODUCTSQUANTITY && productsQuantity < Order.MAX_PRODUCTSQUANTITY) {
            getContext().setObjState(new ProcessedState(this));
        } else {
            getContext().setObjState(new CancelledState(this));
        }
        return getContext().getObjState();
    }

    public boolean shipment(double additionalProducts) {
        double productsQuantity = getContext().getProductsQuantity();
        getContext().setProductsQuantity(productsQuantity + Order.FREE_PRODUCTS_RECEIVED);
        System.out.println("You will receive 2 free products due to your order status (Received)");
        return super.shipment(additionalProducts);
    }
}
