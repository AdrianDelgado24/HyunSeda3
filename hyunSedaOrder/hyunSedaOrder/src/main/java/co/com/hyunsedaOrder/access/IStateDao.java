package co.com.hyunsedaOrder.access;
import org.springframework.data.repository.CrudRepository;
import co.com.hyunsedaOrder.domain.entity.State;

/**Interfaces DAO de productos*/
public interface IStateDao extends CrudRepository<State, Long> {
}
