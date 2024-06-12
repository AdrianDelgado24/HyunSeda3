package co.com.hyunsedaOrder.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.com.hyunsedaOrder.access.IStateDao;
import co.com.hyunsedaOrder.domain.entity.State;
import co.com.hyunsedaOrder.presentation.exception.ResourceNotFoundException;
import co.com.hyunsedaOrder.presentation.exception.StateDomainException;
import co.com.hyunsedaOrder.presentation.exception.StateError;

import java.util.ArrayList;
import java.util.List;
@Service
public class StateService implements IStateService {

    /**Inyección de estado Dao*/
    @Autowired//permite realizar la inyección de independencia
    private IStateDao stateDao;

    /**
     * Servicio para buscar todos las estados
     * @return Listado de estados
     */
    @Override
    @Transactional(readOnly = true) // Para que esté sincronizada con la bd
    public List<State> findAll() {
        return (List<State>) stateDao.findAll();
    }

    /**
     * Busca una estado por su Id
     * @param id codigo del estado
     * @return objeto de tipo estado
     */
    @Override // Para que esté sincronizada con la bd
    public State findById(Long id) throws ResourceNotFoundException {
        State est = stateDao.findById(id).orElse(null);
        if (est == null) {
            throw new ResourceNotFoundException();
        }
        return est ;
    }

    /**
     * Crea una nueva estado
     * @param state estado a crear en la bd
     * @return Categoria creada
     */
    @Override
    @Transactional
    public State create(State state) throws StateDomainException {
        List<StateError> errors = validateDomain(state);
        if (!errors.isEmpty()) {
            throw new StateDomainException(errors);
        }
        return stateDao.save(state);
    }

    /**
     * Modifica o edita una estado
     * @param id, codigo del estado a modificar
     * @param state estado con los datos a editar
     * @return Categoria modificado
     */
    @Override
    @Transactional
    public State update(Long id, State state) throws StateDomainException, ResourceNotFoundException {
        State est = this.findById(id);
        if (est == null) {
            throw new ResourceNotFoundException();
        }

        List<StateError> errors = validateDomain(state);

        if (!errors.isEmpty()) {
            throw new StateDomainException(errors);
        }
        //est.setStateName(state.getStateName());
        return stateDao.save(est);
    }

    /**
     * Aplica validaciones o reglas del dominio para una Categoria. Antes de ser
     * agregado o modificado.
     *
     * @param state estado a validar
     * @return lista de errores de validación
     */

    private List<StateError> validateDomain(State state) {
        List<StateError> errors = new ArrayList<>();
        if(state.getStateId() <= 0){
            errors.add(new StateError(ErrorCodes.INVALID_NUMBER, "codigo", "El codigo del estado es obligatorio y mayor a cero"));
        }
        /*if (state.getStateName() == null || state.getStateName().isBlank()) {
            errors.add(new StateError(ErrorCodes.EMPTY_FIELD, "name", "El nombre del estado es obligatoria"));
        }*/
        return errors;
    }
    /**
     * Eliminar estado por su id
     * @param id codigo del estado a eliminar
     */
    @Override
    @Transactional
    public void deleteById(Long id) throws ResourceNotFoundException {
        State est = this.findById(id);
        if (est == null) {
            throw new ResourceNotFoundException();
        }
        stateDao.deleteById(id);
    }
}


