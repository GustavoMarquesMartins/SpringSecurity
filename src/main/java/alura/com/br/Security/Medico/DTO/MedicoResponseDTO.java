package alura.com.br.Security.Medico.DTO;

import alura.com.br.Security.Medico.Domain.Medico;

public record MedicoResponseDTO(String nome, String email, Boolean status) {

    public MedicoResponseDTO(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getStatus());
    }
}
