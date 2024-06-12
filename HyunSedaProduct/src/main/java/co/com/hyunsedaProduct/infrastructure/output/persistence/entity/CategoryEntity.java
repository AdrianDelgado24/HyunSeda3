package co.com.hyunsedaProduct.infrastructure.output.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor

@Entity
@Table(name = "Categories")
public class CategoryEntity implements Serializable
{

   private static final long serialVersionUID = 1L; /* Se utiliza para garantizar la compatibilidad entre diferentes
                                                           //versiones de la clase cuando se serializa y deserializa. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_Id")
    private long categoryId; /* Identificador único de la categoría en la base de datos. */
    @Column(name="category_Name")
    private String categoryName; /* Nombre de la categoría. */

    @JsonIgnore
    @ManyToMany(mappedBy = "categories") /* Indica que esta lista es mapeada por la relación 'categories' en la clase Product. */
    @JsonManagedReference
    private List<ProductEntity> products;
    //= new ArrayList<>();

    /**
     * Constructor de la clase CategoryEntity.
     */
    public CategoryEntity(){
       this.products = new ArrayList<>();
    }
}



