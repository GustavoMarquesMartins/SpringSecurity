package alura.com.br.Security.Medico.Domain;


import alura.com.br.Security.Medico.DTO.MedicoDadosAtualizacaoDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Medico")
@Table(name = "medicos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;


    private Boolean status = true;

    public void tornarInativo() {
        this.status = false;
    }

    public void atualizar(MedicoDadosAtualizacaoDTO medicoDadosAtualizacaoDTO) {
        if (medicoDadosAtualizacaoDTO.nome() != null) {
            this.nome = medicoDadosAtualizacaoDTO.nome();
        }
        if (medicoDadosAtualizacaoDTO.email() != null) {
            this.email = medicoDadosAtualizacaoDTO.email();
        }
    }
}
