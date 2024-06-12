package co.unicauca.user.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ErrorsPayload {

    public final List<ErrorJSON> errors;
    /**
     * Constructor para crear un payload de errores a partir de una lista de errores de la aplicación.
     *
     * @param applicationErrors La lista de errores de la aplicación.
     */
    public ErrorsPayload(List<UserError> applicationErrors) {
        this.errors = new ArrayList<>();
        applicationErrors.forEach(applicationError -> errors.add(fromApplicationError(applicationError)));
    }
    /**
     * Convierte un error de aplicación (UserError) en un error JSON (ErrorJSON).
     *
     * @param error El error de aplicación a convertir.
     * @return El error JSON convertido.
     */
    private ErrorJSON fromApplicationError(UserError error) {
        return new ErrorJSON(error.code, error.field, error.description);
    }
}
