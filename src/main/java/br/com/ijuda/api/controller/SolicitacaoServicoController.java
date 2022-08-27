package br.com.ijuda.api.controller;

import br.com.ijuda.api.model.PrestadorServico;
import br.com.ijuda.api.model.SolicitacaoServico;
import br.com.ijuda.api.repository.SolicitacaoServicoRepository;
import br.com.ijuda.api.service.SolicitacaoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/solicitacaoservico")
public class SolicitacaoServicoController {

    @Autowired
    private SolicitacaoServicoRepository solicitacaoServicoRepository;

    @Autowired
    private SolicitacaoServicoService solicitacaoServicoService;

    @PostMapping
    public ResponseEntity<SolicitacaoServico> criar(@Valid @RequestBody SolicitacaoServico solicitacaoServico, HttpServletResponse response) {
        SolicitacaoServico solicitacaoServicoSalva = solicitacaoServicoRepository.save(solicitacaoServico);
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacaoServicoSalva);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<SolicitacaoServico> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<SolicitacaoServico> solicitacaoServico = solicitacaoServicoRepository.findById(codigo);
        return solicitacaoServico.isPresent()? ResponseEntity.ok(solicitacaoServico.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover (@PathVariable Long codigo) {
        this.solicitacaoServicoRepository.deleteById(codigo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<SolicitacaoServico> atualizar(@PathVariable Long codigo, @Valid @RequestBody SolicitacaoServico solicitacaoServico) {
        SolicitacaoServico solicitacaoServicoSalva = solicitacaoServicoService.atualizar(codigo,solicitacaoServico);
        return ResponseEntity.ok(solicitacaoServicoSalva);
    }

    @PutMapping("/{codigo}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
        solicitacaoServicoService.atualizarPropriedadeAtivo(codigo,ativo);
    }
}
