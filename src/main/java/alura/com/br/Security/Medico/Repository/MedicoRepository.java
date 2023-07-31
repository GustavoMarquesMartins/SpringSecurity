package alura.com.br.Security.Medico.Repository;

import alura.com.br.Security.Medico.Domain.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByStatusTrue(Pageable pageable);

    Optional findByEmail(String email);
}
