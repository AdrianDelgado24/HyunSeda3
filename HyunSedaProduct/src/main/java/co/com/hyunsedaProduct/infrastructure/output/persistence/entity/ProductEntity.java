package co.com.hyunsedaProduct.infrastructure.output.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "products")
public class ProductEntity implements Serializable
{

   private static final long serialVersionUID = 1L; /*se utiliza para garantizar la compatibilidad entre diferentes
                                                        //versiones de la clase cuando se serializa y deserializa*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)/* Identity es que sea único y se debe ingresar manualmente */
    private long productId;

    @Column (name="product_name")
    private String productName; /* Nombre del producto. */

    @Column (name="product_Descripcion")
    private String productDescripcion; /* Descripción del producto. */

    @Column (name="product_price")
    private double productPrice; /* Precio del producto. */

    @Column (name="product_stock")
    private long productStock; /* Stock disponible del producto. */

    @Column (name="keywords")
    private String keywords; /* Palabras clave relacionadas con el producto. */
    @Column (name="product_caracteristc")
    private String productCaracteristc; /* Características del producto. */

    @Column (name="product_photo")
    private String productPhoto; /* URL de la foto del producto. */

    @ManyToMany()
    @JoinTable(name = "productCategory",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private List<CategoryEntity> categories; /* Lista de categorías a las que pertenece el producto. */
}


