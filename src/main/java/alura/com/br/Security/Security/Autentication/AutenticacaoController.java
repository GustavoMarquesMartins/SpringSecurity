package alura.com.br.Security.Security.Autentication;


import alura.com.br.Security.Security.Token.TokenService;
import alura.com.br.Security.Security.Users.Usuario;
import alura.com.br.Security.Security.Users.UsuarioAutentificacaoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid UsuarioAutentificacaoDTO dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(token);
        return ResponseEntity.ok(tokenService.gerarToken((Usuario) authentication.getPrincipal()));
    }
}