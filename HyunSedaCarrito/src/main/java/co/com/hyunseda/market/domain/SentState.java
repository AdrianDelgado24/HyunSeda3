package co.com.hyunseda.market.domain;

/**
 * Estado de la orden: Enviado. Recibe 5 productos gratis
 *
 * @author Felipe Pino
 */
public class SentState extends State {

    public SentState(Order account) {
        super(account);
    }

    public SentState(State source) {
        super(source);
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
        getContext().setProductsQuantity(productsQuantity + Order.FREE_PRODUCTS_SENT);
        System.out.println("You will receive 5 free products due to your order status (Sent)");
        return super.shipment(additionalProducts);
    }
}
