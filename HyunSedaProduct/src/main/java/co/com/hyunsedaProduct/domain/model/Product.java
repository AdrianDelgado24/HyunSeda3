package co.com.hyunsedaProduct.domain.model;
/**
 * Esta clase representa la entidad Producto en el dominio del sistema.
 * Cada instancia de esta clase corresponde a un producto en la base de datos.
 */
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private long productId;
    private String productName; /* Nombre del producto. */
    private String productDescripcion; /* Descripción del producto. */
    private double productPrice; /* Precio del producto. */
    private long productStock; /* Stock disponible del producto. */
    private String keywords; /* Palabras clave relacionadas con el producto. */
    private String productCaracteristc; /* Características del producto. */
    private String productPhoto; /* URL de la foto del producto. */
}


