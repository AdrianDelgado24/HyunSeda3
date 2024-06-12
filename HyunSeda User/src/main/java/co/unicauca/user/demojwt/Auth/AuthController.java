package co.unicauca.user.demojwt.Auth;

import co.unicauca.user.exceptions.UserDomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    /**
     * Maneja las solicitudes HTTP POST para iniciar sesión.
     *
     * @param loginRequest El objeto LoginRequest recibido en el cuerpo de la solicitud.
     * @return Un ResponseEntity que contiene el objeto AuthResponse con el resultado del inicio de sesión.
     */
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }
    /**
     * Maneja las solicitudes HTTP POST para registrar un nuevo usuario.
     *
     * @param registerRequest El objeto RegisterRequest recibido en el cuerpo de la solicitud.
     * @return Un ResponseEntity que contiene el objeto AuthResponse con el resultado del registro.
     * @throws UserDomainException Si ocurre un error de dominio durante el registro.
     */
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest) throws UserDomainException {
        return ResponseEntity.ok(authService.register(registerRequest));
    }
}
