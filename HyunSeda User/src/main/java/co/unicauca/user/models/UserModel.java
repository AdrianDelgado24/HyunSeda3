package co.unicauca.user.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class UserModel implements UserDetails {
    @Id
    @Column(nullable = false)
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    @Enumerated(EnumType.STRING)
    private RoleModel roleModel;

    /**
     * Obtiene los roles del usuario.
     *
     * @return Una lista de roles del usuario.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((roleModel.name())));
    }
    /**
     * Indica si la cuenta del usuario ha expirado.
     *
     * @return Siempre retorna true, la cuenta nunca expira.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    /**
     * Indica si la cuenta del usuario está bloqueada.
     *
     * @return Siempre retorna true, la cuenta nunca está bloqueada.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    /**
     * Indica si las credenciales del usuario han expirado.
     *
     * @return Siempre retorna true, las credenciales nunca expiran.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    /**
     * Indica si el usuario está habilitado.
     *
     * @return Siempre retorna true, el usuario siempre está habilitado.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

}
