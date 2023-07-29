package alura.com.br.Security.Medico.Servico;

import alura.com.br.Security.Medico.DTO.MedicoRequestDTO;
import alura.com.br.Security.Medico.Domain.Medico;
import alura.com.br.Security.Medico.Repository.MedicoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoServico {

    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Medico salvar(MedicoRequestDTO medicoRequestDTO) {
        return medicoRepository.save(modelMapper.map(medicoRequestDTO, Medico.class));
    }

}
