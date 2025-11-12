package br.com.fiap.futureskillhubapi.controller;

import br.com.fiap.futureskillhubapi.domain.Trilha;
import br.com.fiap.futureskillhubapi.service.TrilhaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/trilhas")
public class TrilhaController {

    private final TrilhaService service;

    public TrilhaController(TrilhaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Trilha> criar(@Valid @RequestBody Trilha t) {
        Trilha criada = service.criar(t);
        return ResponseEntity.created(URI.create("/api/trilhas/" + criada.getId()))
                .body(criada);
    }

    @GetMapping
    public List<Trilha> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Trilha buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Trilha atualizar(@PathVariable Long id, @Valid @RequestBody Trilha t) {
        return service.atualizar(id, t);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
