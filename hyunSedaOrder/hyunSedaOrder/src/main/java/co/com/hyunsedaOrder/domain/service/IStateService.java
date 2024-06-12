package co.com.hyunsedaOrder.domain.service;


import java.util.List;

import co.com.hyunsedaOrder.domain.entity.State;
import co.com.hyunsedaOrder.presentation.exception.ResourceNotFoundException;
import co.com.hyunsedaOrder.presentation.exception.StateDomainException;
/**
 * Interfaz de operaciones de la base de datos de Estado
 */
public interface IStateService {

    List<State> findAll();
    State findById(Long id) throws ResourceNotFoundException;
    State create(State state) throws StateDomainException;
    State update(Long id, State state) throws StateDomainException, ResourceNotFoundException;
    void deleteById(Long id) throws ResourceNotFoundException;
}
