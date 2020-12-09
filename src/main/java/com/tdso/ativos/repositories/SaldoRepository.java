package com.tdso.ativos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tdso.ativos.entities.Saldo;

public interface SaldoRepository extends JpaRepository<Saldo, Long> {

}
