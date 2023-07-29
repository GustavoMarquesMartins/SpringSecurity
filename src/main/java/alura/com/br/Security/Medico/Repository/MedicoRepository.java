package alura.com.br.Security.Medico.Repository;

import alura.com.br.Security.Medico.Domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
