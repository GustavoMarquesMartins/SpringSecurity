package alura.com.br.Security.Medico.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicoDadosAtualizacaoDTO(@NotNull Long id, String nome, String email) {
}
