package com.tdso.ativos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tdso.ativos.entities.Ativo;

public interface AtivoRepository extends JpaRepository<Ativo, Long> {

}
