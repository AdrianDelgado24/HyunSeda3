package co.com.hyunseda.market.domain.acess;


/**
 * Fabrica que se encarga de instanciar ProductRepository o cualquier otro que
 * se cree en el futuro.
 */
public class Factory {
     
    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    /**
     * Método que crea una instancia concreta de la jerarquia IProductRepository
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción IProductRepository
     */
   public IProductRepository getProductRepository(String type) {

        IProductRepository result = null;

        switch (type) { //Viola el principio abierto cerrado pero por simplidad lo dejamos por ahora ahi
            case "default":
                result = new ProductRepository();
                break;
            case "mongo":
//                result = new ProductMongoRepository();
        }

        return result;

    }
    
    public ICategoryRepository getCategoryRepository(String type) {

        ICategoryRepository result = null;

        switch (type) { //Viola el principio abierto cerrado pero por simplidad lo dejamos por ahora ahi
            case "default":
                result = new CategoryRepository();
                break;
            case "mongo":
//                result = new ProductMongoRepository();
        }

        return result;

    }
    /**
     * Método que crea una instancia concreta de la jerarquia IPayRepository
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción IPayRepository
     */
   public IPayRepository getPayRepository(String type) {

        IPayRepository result = null;

        switch (type) { //Viola el principio abierto cerrado pero por simplidad lo dejamos por ahora ahi
            case "default":
                result = new PayRepository();
                break;
            case "mongo":
//                result = new ProductMongoRepository();
        }

        return result;

    }
    /**
     * Método que crea una instancia concreta de la jerarquia IOrderRepository
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción IOrderRepository
     */
   public IOrderRepository getOrderRepository(String type) {

        IOrderRepository result = null;

        switch (type) { //Viola el principio abierto cerrado pero por simplidad lo dejamos por ahora ahi
            case "default":
                result = new OrderRepository();
                break;
            case "mongo":
//                result = new ProductMongoRepository();
        }

        return result;

    }
   
   /**
     * Método que crea una instancia concreta de la jerarquia IUserRepository
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción IUserRepository
     */
   public IUserRepository getUserRepository(String type) {

        IUserRepository result = null;

        switch (type) { //Viola el principio abierto cerrado pero por simplidad lo dejamos por ahora ahi
            case "default":
                result = (IUserRepository) new UserRepository();
                break;
            case "mongo":
//                result = new ProductMongoRepository();
        }

        return result;

    }
}


