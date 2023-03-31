package com.gabriel.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.backend.domain.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
