package co.com.hyunsedaProduct.domain.exception;

import java.util.List;

public class CategoryDomainException extends Exception {

    /** Listado de errores*/
    public final List<CategoryError> errors;
    public CategoryDomainException(List<CategoryError> errors) {
        this.errors = errors;
    }

}


