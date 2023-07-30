package alura.com.br.Security.Security.Token;

import alura.com.br.Security.Security.Users.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class TokenService {

    public String gerarToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256("12345678");
            return JWT.create().withIssuer("Security").withSubject(usuario.getLogin()).withExpiresAt(dataExpiracaoToken()).sign(algoritmo);
        } catch (JWTCreationException jwtCreationException) {
            throw new RuntimeException(" erro ao gerar o token JWT ! ", jwtCreationException);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256("12345678");
            return JWT.require(algoritmo)
                    .withIssuer("Security")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    public Instant dataExpiracaoToken() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
