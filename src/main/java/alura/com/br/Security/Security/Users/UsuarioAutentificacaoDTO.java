package alura.com.br.Security.Security.Users;

import jakarta.validation.constraints.NotBlank;

public record UsuarioAutentificacaoDTO(@NotBlank String login, @NotBlank String senha) {
}
