package com.gabriel.backend.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabriel.backend.domain.dtos.ClienteDTO;
import com.gabriel.backend.domain.enums.Perfil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cliente extends Usuario {
    
    private static final long serialVersionUID = 1L;

    @JsonIgnore
	@OneToMany(mappedBy = "cliente")
    private List<Lancamento> lancamentos = new ArrayList<>();

    public Cliente() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Long id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(ClienteDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}

}
