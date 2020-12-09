package com.tdso.ativos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdso.ativos.entities.Provento;
import com.tdso.ativos.repositories.ProventoRepository;

@Service
public class ProventoService {
	
	@Autowired
	ProventoRepository repo;
	
	public List<Provento> findAll(){
		return repo.findAll();
	}
	
	public Provento findById(Long id) {
		Optional<Provento> obj = repo.findById(id);
		return obj.get();
	}

}
