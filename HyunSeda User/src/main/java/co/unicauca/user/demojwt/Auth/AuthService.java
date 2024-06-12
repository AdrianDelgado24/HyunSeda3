package co.unicauca.user.demojwt.Auth;

import co.unicauca.user.demojwt.Jwt.JwtService;
import co.unicauca.user.exceptions.EnumErrorCodes;
import co.unicauca.user.exceptions.UserDomainException;
import co.unicauca.user.exceptions.UserError;
import co.unicauca.user.models.RoleModel;
import co.unicauca.user.models.UserModel;
import co.unicauca.user.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final IUserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    /**
     * Maneja la lógica de inicio de sesión.
     *
     * @param request El objeto LoginRequest recibido con las credenciales del usuario.
     * @return Un objeto AuthResponse que contiene el token JWT, el rol y el nombre de usuario.
     */
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String username = user.getUsername();
        String role = user.getAuthorities().toString();
        System.out.println(username);
        System.out.println(role);

        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .role(role)
                .username(username)
                .build();

    }
    /**
     * Maneja la lógica de registro de un nuevo usuario.
     *
     * @param request El objeto RegisterRequest recibido con los datos del usuario a registrar.
     * @return Un objeto AuthResponse que contiene el token JWT y el rol del usuario registrado.
     * @throws UserDomainException Si ocurre un error de dominio durante el registro.
     */
    public AuthResponse register(RegisterRequest request) throws UserDomainException {
        UserModel user = UserModel.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                //.firstName(request.getFirstName())
                //.lastName(request.getLastName())
                .email(request.getEmail())
                .roleModel(RoleModel.USER)
                .build();
        List<UserError>errors=validateDomain(user);
        if(!errors.isEmpty()){
            throw new UserDomainException(errors);
        }

        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .role(user.getRoleModel().toString())
                .build();

    }
    /**
     * Valida el dominio del usuario.
     *
     * @param user El objeto UserModel que se va a validar.
     * @return Una lista de errores de dominio si hay violaciones.
     */
    private List<UserError> validateDomain(UserModel user) {
        List<UserError> errors = new ArrayList<>();
        if(this.userRepository.findByUsername(user.getUsername()).isPresent()){
            errors.add(new UserError(EnumErrorCodes.EXISTENT_FIELD, "name", "El username ya existe"));
        }
        return errors;
    }
}
