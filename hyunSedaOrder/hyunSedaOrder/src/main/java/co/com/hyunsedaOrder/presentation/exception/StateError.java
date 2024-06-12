package co.com.hyunsedaOrder.presentation.exception;

import co.com.hyunsedaOrder.domain.service.ErrorCodes;
/**
 * 
 */
public class StateError {
	/**
	 * Codigo del error
	 */
	public final ErrorCodes code;
	/**
	 * Campo del error
	 */
	public final String field;
	/**
	 * Descripción del error
	 */
	public final String description;

	public StateError(ErrorCodes code, String field, String description) {
		this.code = code;
		this.field = field;
		this.description = description;
	}
}
