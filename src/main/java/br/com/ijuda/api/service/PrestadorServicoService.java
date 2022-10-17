package br.com.ijuda.api.service;

import br.com.ijuda.api.controller.dto.ClienteDTO;
import br.com.ijuda.api.controller.dto.PrestadorServicoDTO;
import br.com.ijuda.api.model.Cliente;
import br.com.ijuda.api.model.PrestadorServico;
import br.com.ijuda.api.repository.PrestadorServicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestadorServicoService {

    @Autowired
    private PrestadorServicoRepository prestadorServicoRepository;

    public PrestadorServico atualizar(Long codigo, PrestadorServico prestadorServico){
        PrestadorServico prestadorServicoSalvo = findPrestadorServicoByCodigo(codigo);

        BeanUtils.copyProperties(prestadorServico,prestadorServicoSalvo,"codigo");
        return prestadorServicoRepository.save(prestadorServicoSalvo);
    }

    public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo){
        PrestadorServico prestadorServicoSalvo = findPrestadorServicoByCodigo(codigo);
        prestadorServicoSalvo.setAtivo(ativo);
        prestadorServicoRepository.save(prestadorServicoSalvo);
    }

    private PrestadorServico findPrestadorServicoByCodigo(Long codigo) {
        PrestadorServico prestadorServicoSalvo = prestadorServicoRepository.findById(codigo)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        return prestadorServicoSalvo;
    }

    public List<PrestadorServicoDTO> findAll() {
        List<PrestadorServico> prestadorServicoList = prestadorServicoRepository.findAll();
        return prestadorServicoList.stream().map(dto -> PrestadorServicoDTO.builder()
                .id(dto.getId())
                .usuario(dto.getUsuario())
                .cpf(dto.getCpf())
                .telefone(dto.getTelefone())
                .endereco(dto.getEndereco())
                .ativo(dto.getAtivo())
                .build()
        ).collect(Collectors.toList());
    }

}



