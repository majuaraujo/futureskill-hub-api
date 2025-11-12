package br.com.fiap.futureskillhubapi.service;

import br.com.fiap.futureskillhubapi.domain.Usuario;
import br.com.fiap.futureskillhubapi.exception.ResourceNotFoundException;
import br.com.fiap.futureskillhubapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public Usuario criar(Usuario u) {
        return repo.save(u);
    }

    public List<Usuario> listar() {
        return repo.findAll();
    }

    public Usuario buscar(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    public Usuario atualizar(Long id, Usuario dados) {
        Usuario u = buscar(id);
        u.setNome(dados.getNome());
        u.setEmail(dados.getEmail());
        u.setAreaAtuacao(dados.getAreaAtuacao());
        u.setNivelCarreira(dados.getNivelCarreira());
        // dataCadastro é setado em @PrePersist; normalmente não alteramos aqui
        return repo.save(u);
    }

    public void deletar(Long id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("Usuário não encontrado");
        repo.deleteById(id);
    }
}
