package alura.com.br.Security.Medico.Controller;

import alura.com.br.Security.ExceptionHandling.MedicoNotFoundException;
import alura.com.br.Security.Medico.DTO.MedicoDadosAtualizacaoDTO;
import alura.com.br.Security.Medico.DTO.MedicoRequestDTO;
import alura.com.br.Security.Medico.DTO.MedicoResponseDTO;
import alura.com.br.Security.Medico.Repository.MedicoRepository;
import alura.com.br.Security.Medico.Servico.MedicoServico;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoServico medicoServico;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity salvar(@RequestBody @Valid MedicoRequestDTO medicoRequestDTO, UriComponentsBuilder uriComponentsBuilder)throws Exception{
        var medico = medicoServico.salvar(medicoRequestDTO);
        var uri = uriComponentsBuilder.path("/medico/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new MedicoResponseDTO(medico));
    }

    @GetMapping
    public ResponseEntity<Page<MedicoResponseDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return ResponseEntity.ok().body(medicoServico.listar(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) throws MedicoNotFoundException {
        medicoServico.tornarInativo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid MedicoDadosAtualizacaoDTO medicoDadosAtualizacaoDTO) {
        var dto = medicoServico.atualizar(medicoDadosAtualizacaoDTO);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity medicoDetalhado(@PathVariable Long id) {
        var dto = medicoServico.medicoDetalhado(id);
        return ResponseEntity.ok(dto);
    }

}
