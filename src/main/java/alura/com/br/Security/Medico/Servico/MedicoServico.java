package alura.com.br.Security.Medico.Servico;

import alura.com.br.Security.ExceptionHandling.MedicoNotFoundException;
import alura.com.br.Security.Medico.DTO.MedicoDadosAtualizacaoDTO;
import alura.com.br.Security.Medico.DTO.MedicoRequestDTO;
import alura.com.br.Security.Medico.DTO.MedicoResponseDTO;
import alura.com.br.Security.Medico.Domain.Medico;
import alura.com.br.Security.Medico.Repository.MedicoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.NotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.MethodInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoServico {

    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public Medico salvar(MedicoRequestDTO medicoRequestDTO) throws Exception {
        validarCamposUnique(medicoRequestDTO);
        return medicoRepository.save(modelMapper.map(medicoRequestDTO, Medico.class));
    }


    @Transactional
    public void tornarInativo(Long id) throws MedicoNotFoundException {
        var medico = medicoRepository.findById(id).orElseThrow(() -> new MedicoNotFoundException("Médico com o id : " + id + " não foi encontrado ", List.of("id")));
        medico.tornarInativo();
    }

    public Page<MedicoResponseDTO> listar(Pageable pageable) {
        return medicoRepository.findAllByStatusTrue(pageable).map(MedicoResponseDTO::new);
    }

    public MedicoResponseDTO medicoDetalhado(Long id) {
        var medico = medicoRepository.findById(id).orElseThrow(() -> new RuntimeException(" O id inserido não corresponse a um médico valido"));
        return new MedicoResponseDTO(medico);
    }

    @Transactional
    public MedicoResponseDTO atualizar(MedicoDadosAtualizacaoDTO medicoDadosAtualizacaoDTO) {
        var medico = medicoRepository.findById(medicoDadosAtualizacaoDTO.id()).orElseThrow(() -> new RuntimeException(" O id inserido não corresponse a um médico valido "));
        medico.atualizar(medicoDadosAtualizacaoDTO);
        return new MedicoResponseDTO(medico);
    }

    private void validarCamposUnique(MedicoRequestDTO medicoRequestDTO) throws Exception {
        var medico = medicoRepository.findByEmail(medicoRequestDTO.email());
        if (medico.isPresent()) {
            throw new Exception("Usuario ja com email cadastrado");
        }
    }
}
