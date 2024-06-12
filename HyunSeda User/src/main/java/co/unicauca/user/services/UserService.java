package co.unicauca.user.services;

import co.unicauca.user.models.UserModel;
import co.unicauca.user.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;
    /**
     * Obtiene todos los usuarios.
     *
     * @return Lista de todos los usuarios.
     */
    @Override
    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }
    /**
     * Guarda un usuario en la base de datos.
     *
     * @param user El usuario a guardar.
     * @return El usuario guardado.
     */
    @Override
    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }
    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username El nombre de usuario a buscar.
     * @return El usuario encontrado, si existe.
     */
    @Override
    public Optional<UserModel> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
