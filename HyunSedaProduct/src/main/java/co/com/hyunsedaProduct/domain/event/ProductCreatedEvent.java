package co.com.hyunsedaProduct.domain.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreatedEvent {
    private Long id;
    private LocalDateTime date;

    /**
     * Constructor que crea un evento de producto creada con un identificador específico.
     * La fecha se establece al momento de la creación del objeto.
     *
     * @param id El identificador único del producto.
     */
    public ProductCreatedEvent(Long id) {
        this.id= id;
        this.date = LocalDateTime.now();
    }
}
