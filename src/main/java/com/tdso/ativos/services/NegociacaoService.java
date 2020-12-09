package com.tdso.ativos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tdso.ativos.entities.Negociacao;
import com.tdso.ativos.repositories.NegociacaoRepository;
import com.tdso.ativos.services.exception.ResourceNotFoundException;

@Service
public class NegociacaoService {
	
	@Autowired
	NegociacaoRepository repo;
	
	public List<Negociacao> findAll(){
		return repo.findAll();
	}
	
	public Negociacao findById(Long id) {
		Optional<Negociacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id) );
	}
	
	public void delete (Long id) {
		try {
			repo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}

}
