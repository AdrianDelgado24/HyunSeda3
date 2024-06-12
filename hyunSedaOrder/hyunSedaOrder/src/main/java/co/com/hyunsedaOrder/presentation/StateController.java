package co.com.hyunsedaOrder.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import co.com.hyunsedaOrder.domain.entity.State;
import co.com.hyunsedaOrder.domain.service.IStateService;
import co.com.hyunsedaOrder.presentation.exception.ResourceNotFoundException;
import co.com.hyunsedaOrder.presentation.exception.StateDomainException;

import java.util.List;
/**Servicios web de estados*/

@RestController
@RequestMapping("states")
public class StateController {

    @Autowired
    private IStateService stateService;

    /**
     * Crear un estado
     * @param state estado
     * @return estado creado
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public State create(@RequestBody State state) throws StateDomainException {
        return stateService.create(state);
    }
    /**
     * Editar
     * @param state Estado a editar
     * @param id      codigo del estado
     * @return estado editada
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 Id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public State update(@RequestBody State state, @PathVariable Long id)
            throws StateDomainException, ResourceNotFoundException {
        return stateService.update(id, state);
    }

    /**
     * Eliminar
     * @param id codigo del estado
     * @throws ResourceNotFoundException id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
        stateService.deleteById(id);
    }

    /**
     * Listar todos
     * @return listado de estados en json
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<State> findAll() {
        return (List<State>) stateService.findAll();
    }
    /**
     * Listar un estado  por id
     * @param id codigo
     * @return Estado en formato json
     * @throws Exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public State findById(@PathVariable Long id) throws ResourceNotFoundException {

        State cate = stateService.findById(id);
        return cate;
    }
}

