package alura.com.br.Security.Security.Autentication;


import alura.com.br.Security.Security.Users.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoServico implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(login);
    }
}