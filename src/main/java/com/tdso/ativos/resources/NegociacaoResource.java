package com.tdso.ativos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tdso.ativos.entities.Negociacao;
import com.tdso.ativos.services.NegociacaoService;

@RestController
@RequestMapping("/negs")
public class NegociacaoResource {
	
	@Autowired
	NegociacaoService service;
	
	@RequestMapping("/")
	public ResponseEntity<List<Negociacao>> findAll(){
		
		List<Negociacao> negs = service.findAll();
		return ResponseEntity.ok().body(negs);	
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Negociacao> findById(@PathVariable Long id){
		
		Negociacao n = service.findById(id);
		return ResponseEntity.ok().body(n);	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Negociacao> deleteById(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok().build();	
	}

}
