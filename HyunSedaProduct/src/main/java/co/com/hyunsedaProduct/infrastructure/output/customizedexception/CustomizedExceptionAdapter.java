package co.com.hyunsedaProduct.infrastructure.output.customizedexception;

import co.com.hyunsedaProduct.infrastructure.output.customizedexception.data.response.ExceptionResponse;
import co.com.hyunsedaProduct.domain.exception.ProductNotFound;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//mirar
/**
 * Manejador global de excepciones para los controladores REST.
 */
@ControllerAdvice
@RestController
public class CustomizedExceptionAdapter extends ResponseEntityExceptionHandler {
    /**
     * Maneja todas las excepciones genéricas.
     *
     * @param ex la excepción lanzada.
     * @param request la solicitud web en la que ocurrió la excepción.
     * @return una respuesta con los detalles de la excepción.
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), Arrays.asList(request.getDescription(false)));

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Maneja las excepciones de tipo {@link ProductNotFound}.
     *
     * @param ex la excepción lanzada.
     * @param request la solicitud web en la que ocurrió la excepción.
     * @return una respuesta con los detalles de la excepción.
     */
    @ExceptionHandler(ProductNotFound.class)
    public final ResponseEntity<Object> handleUserNotFoundException(ProductNotFound ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), Arrays.asList(request.getDescription(false)));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Maneja las excepciones de argumentos no válidos en métodos.
     *
     * @param ex la excepción lanzada.
     * @param headers las cabeceras HTTP.
     * @param status el estado HTTP.
     * @param request la solicitud web en la que ocurrió la excepción.
     * @return una respuesta con los detalles de la excepción.
     */
    // @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        ex.getBindingResult().getAllErrors().stream().forEach(error -> {
            errors.add(error.getDefaultMessage());
        });

        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), "Validation Failed", errors);

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
