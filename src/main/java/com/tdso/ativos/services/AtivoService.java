package com.tdso.ativos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdso.ativos.entities.Ativo;
import com.tdso.ativos.repositories.AtivoRepository;

@Service
public class AtivoService {
	
	@Autowired
	AtivoRepository repo;
	
	public List<Ativo> findAll(){
		return repo.findAll();
	}
	
	public Ativo findById(Long id) {
		Optional<Ativo> obj = repo.findById(id);
		return obj.get();
	}

}
