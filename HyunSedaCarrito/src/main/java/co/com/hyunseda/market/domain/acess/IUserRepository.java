/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.hyunseda.market.domain.acess;

import co.com.hyunseda.market.domain.User;
import java.util.List;

/**
 *
 * @author Laura Sofia
 */
public interface IUserRepository {
    
    List<User> findAll();
    User findById(long userId);
    boolean save(User newUser); 
    boolean validarUsuario(User user);
}
