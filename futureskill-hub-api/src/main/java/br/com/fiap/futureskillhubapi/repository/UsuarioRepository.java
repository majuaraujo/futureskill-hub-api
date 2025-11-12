package br.com.fiap.futureskillhubapi.repository;

import br.com.fiap.futureskillhubapi.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { }
