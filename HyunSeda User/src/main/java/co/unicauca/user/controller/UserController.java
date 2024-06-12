package co.unicauca.user.controller;

import co.unicauca.user.models.UserModel;
import co.unicauca.user.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/UserModel")
public class UserController {
    @Autowired
    IUserService userService;

    /**
     * Maneja las solicitudes HTTP GET para obtener todos los usuarios.
     *
     * @return Una lista de todos los objetos UserModel.
     */
    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.getUsers();
    }

    /**
     * Maneja las solicitudes HTTP POST para crear un nuevo usuario.
     *
     * @param userModel El objeto UserModel recibido en el cuerpo de la solicitud.
     * @return El objeto UserModel guardado.
     */
    @PostMapping
    public UserModel createUser(@RequestBody UserModel userModel) {
        return userService.saveUser(userModel);
    }

    /**
     * Maneja las solicitudes HTTP GET para obtener un usuario por nombre de usuario.
     *
     * @param username El nombre de usuario recibido como parámetro de ruta.
     * @return Un Optional que contiene el objeto UserModel si se encuentra.
     */
    @GetMapping("/byUsername/{username}")
    public Optional<UserModel> getUserByUsername(@PathVariable("username") String username) {
        return userService.findByUsername(username);
    }
}
