package br.com.ijuda.api.controller;

import br.com.ijuda.api.model.PrestadorServico;
import br.com.ijuda.api.repository.PrestadorServicoRepository;
import br.com.ijuda.api.service.PrestadorServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/prestadorservico")
public class PrestadorServicoController {

    @Autowired
    private PrestadorServicoRepository prestadorServicoRepository;

    @Autowired
    private PrestadorServicoService prestadorServicoService;

    @PostMapping
    public ResponseEntity<PrestadorServico> criar(@Valid @RequestBody PrestadorServico prestadorServico, HttpServletResponse response) {
        PrestadorServico prestadorServicoSalvo = prestadorServicoRepository.save(prestadorServico);
        return ResponseEntity.status(HttpStatus.CREATED).body(prestadorServicoSalvo);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<PrestadorServico> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<PrestadorServico> prestadorServico = prestadorServicoRepository.findById(codigo);
        return prestadorServico.isPresent()? ResponseEntity.ok(prestadorServico.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover (@PathVariable Long codigo) {
        this.prestadorServicoRepository.deleteById(codigo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<PrestadorServico> atualizar(@PathVariable Long codigo, @Valid @RequestBody PrestadorServico prestadorServico) {
        PrestadorServico prestadorServicoSalvo = prestadorServicoService.atualizar(codigo,prestadorServico);
        return ResponseEntity.ok(prestadorServicoSalvo);
    }

    @PutMapping("/{codigo}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
        prestadorServicoService.atualizarPropriedadeAtivo(codigo,ativo);
    }
}
