package alura.com.br.Security.Medico.DTO;

import jakarta.validation.constraints.NotBlank;

public record MedicoRequestDTO(
        @NotBlank String login,
        @NotBlank String email) {
}
