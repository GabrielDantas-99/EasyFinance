package com.gabriel.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.backend.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
