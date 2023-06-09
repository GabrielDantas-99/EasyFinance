package com.gabriel.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.backend.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByCpf(String cpf);
	Optional<Usuario> findByEmail(String email);
    
}