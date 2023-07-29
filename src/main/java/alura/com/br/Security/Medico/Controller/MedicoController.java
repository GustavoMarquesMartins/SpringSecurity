package alura.com.br.Security.Medico.Controller;

import alura.com.br.Security.Medico.DTO.MedicoRequestDTO;
import alura.com.br.Security.Medico.DTO.MedicoResponseDTO;
import alura.com.br.Security.Medico.Repository.MedicoRepository;
import alura.com.br.Security.Medico.Servico.MedicoServico;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoServico medicoServico;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<MedicoResponseDTO> salvar(@RequestBody @Valid MedicoRequestDTO medicoRequestDTO, UriComponentsBuilder uriComponentsBuilder) {
        var medico = medicoServico.salvar(medicoRequestDTO);
        var uri = uriComponentsBuilder.path("/medico/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new MedicoResponseDTO(medico));
    }
}
