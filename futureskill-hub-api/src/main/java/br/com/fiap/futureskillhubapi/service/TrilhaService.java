package br.com.fiap.futureskillhubapi.service;

import br.com.fiap.futureskillhubapi.domain.Trilha;
import br.com.fiap.futureskillhubapi.exception.ResourceNotFoundException;
import br.com.fiap.futureskillhubapi.repository.TrilhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrilhaService {

    private final TrilhaRepository repo;

    public TrilhaService(TrilhaRepository repo) {
        this.repo = repo;
    }

    public Trilha criar(Trilha t) {
        return repo.save(t);
    }

    public List<Trilha> listar() {
        return repo.findAll();
    }

    public Trilha buscar(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada"));
    }

    public Trilha atualizar(Long id, Trilha dados) {
        Trilha t = buscar(id);
        t.setNome(dados.getNome());
        t.setDescricao(dados.getDescricao());
        t.setNivel(dados.getNivel());
        t.setCargaHoraria(dados.getCargaHoraria());
        t.setFocoPrincipal(dados.getFocoPrincipal());
        return repo.save(t);
    }

    public void deletar(Long id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("Trilha não encontrada");
        repo.deleteById(id);
    }
}
