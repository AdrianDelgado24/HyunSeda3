package co.com.hyunsedaProduct.domain.model;
/**
 * Esta clase representa la entidad Category en el dominio del sistema.
 * Cada instancia de esta clase corresponde a una categoría en la base de datos.
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Category {

    private long categoryId; /* Identificador único de la categoría en la base de datos. */
    private String categoryName; /* Nombre de la categoría. */
}
