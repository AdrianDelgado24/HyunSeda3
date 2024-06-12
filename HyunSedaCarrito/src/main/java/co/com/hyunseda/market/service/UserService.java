/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.service;

import co.com.hyunseda.market.domain.User;
import co.com.hyunseda.market.domain.acess.IUserRepository;
import co.com.hyunseda.market.infrastructure.Subject;
import java.util.ArrayList;
import java.util.List;
/**
 *
 */
public class UserService {
    
     private User user;
    private IUserRepository repository;

    /**
     * Inyección de dependencias en el constructor. Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     * @param repository una clase hija de IProductRepository
     */
    public UserService() {
        this.repository = repository; 
                                    
    }
    public UserService(IUserRepository repository) {
        this.repository = repository; //NO HAY  new
                                       //Se hace por inyección de dependencia
    }
    
    public boolean saveUser( String userName, String firstName, String lastName, String email, String password, String roleModel) {
      
        //Validate product
        User newUser = new User();
        
        //newProduct.setProductId(productId);
        newUser.setUserName(userName);
        newUser.setFirstName(firstName);
        
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setRoleModel(roleModel);
        
        if (newUser.getEmail().isEmpty() || newUser.getPassword().isEmpty()) {
            return false;
        }
         
        return repository.save(newUser);
    }
   
      public List<User> findAll(){
        List<User> users = new ArrayList<>();
        users = repository.findAll();
        
        return users;
    }
      
    public boolean validateUser(User newUser) {
        return repository.validarUsuario(user);
    }
    
}
