package alura.com.br.Security.Medico.Domain;


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

}
