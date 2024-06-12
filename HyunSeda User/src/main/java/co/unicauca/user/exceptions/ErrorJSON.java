package co.unicauca.user.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorJSON {

    public final EnumErrorCodes code;
    public final String field;
    public final String message;

    /**
     * Constructor para crear una instancia de ErrorJSON.
     *
     * @param code Código de error.
     * @param field Campo relacionado con el error.
     * @param message Mensaje de error.
     */
    public ErrorJSON(EnumErrorCodes code, String field, String message) {
        this.code = code;
        this.field = field;
        this.message = message;
    }
}
