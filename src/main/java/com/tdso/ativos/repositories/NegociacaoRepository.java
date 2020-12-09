package com.tdso.ativos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tdso.ativos.entities.Negociacao;

public interface NegociacaoRepository extends JpaRepository<Negociacao, Long>{

}
