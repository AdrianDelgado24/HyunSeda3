package co.com.hyunsedaOrder.presentation.exception;

import java.util.List;

public class StateDomainException extends Exception {

    /** Listado de errores*/
    public final List<StateError> errors;
    public StateDomainException(List<StateError> errors) {
        this.errors = errors;
    }
}
