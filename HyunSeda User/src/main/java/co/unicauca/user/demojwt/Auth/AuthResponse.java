package co.unicauca.user.demojwt.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    /**
     * Token JWT generado durante la autenticación.
     */
    String token;

    /**
     * Rol del usuario autenticado.
     */
    String role;

    /**
     * Nombre de usuario del usuario autenticado.
     */
    String username;
}
