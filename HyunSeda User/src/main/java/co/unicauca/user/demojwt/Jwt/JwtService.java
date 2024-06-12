package co.unicauca.user.demojwt.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private static final String SECRET_KEY="586E3272357538782F413F4428472B4B6250655368566B597033733676397924";
    /**
     * Genera un token JWT para un usuario dado sin reclamos adicionales.
     *
     * @param user Los detalles del usuario.
     * @return El token JWT generado.
     */
    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(), user);
    }
    /**
     * Genera un token JWT con reclamos adicionales para un usuario dado.
     *
     * @param extraClaims Los reclamos adicionales.
     * @param user Los detalles del usuario.
     * @return El token JWT generado.
     */
    private String getToken(Map<String,Object> extraClaims, UserDetails user) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    /**
     * Obtiene la clave secreta para firmar el JWT.
     *
     * @return La clave secreta.
     */
    private Key getKey() {
        byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    /**
     * Obtiene el nombre de usuario del token JWT.
     *
     * @param token El token JWT.
     * @return El nombre de usuario extraído del token.
     */
    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }
    /**
     * Verifica si el token JWT es válido.
     *
     * @param token El token JWT.
     * @param userDetails Los detalles del usuario.
     * @return true si el token es válido, false en caso contrario.
     */
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username=getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }
    /**
     * Obtiene todos los reclamos (claims) del token JWT.
     *
     * @param token El token JWT.
     * @return Los reclamos del token.
     */
    private Claims getAllClaims(String token)
    {
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    /**
     * Obtiene un reclamo específico del token JWT.
     *
     * @param token El token JWT.
     * @param claimsResolver La función para resolver el reclamo.
     * @param <T> El tipo del reclamo.
     * @return El reclamo resuelto.
     */
    public <T> T getClaim(String token, Function<Claims,T> claimsResolver)
    {
        final Claims claims=getAllClaims(token);
        return claimsResolver.apply(claims);
    }
    /**
     * Obtiene la fecha de expiración del token JWT.
     *
     * @param token El token JWT.
     * @return La fecha de expiración.
     */
    private Date getExpiration(String token)
    {
        return getClaim(token, Claims::getExpiration);
    }
    /**
     * Verifica si el token JWT ha expirado.
     *
     * @param token El token JWT.
     * @return true si el token ha expirado, false en caso contrario.
     */
    private boolean isTokenExpired(String token)
    {
        return getExpiration(token).before(new Date());
    }

}
