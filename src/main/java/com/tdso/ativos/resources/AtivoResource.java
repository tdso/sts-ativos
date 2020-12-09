package com.tdso.ativos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tdso.ativos.entities.Ativo;
import com.tdso.ativos.services.AtivoService;

@RestController
@RequestMapping("/ativos")
public class AtivoResource {
	
	@Autowired
	AtivoService service;
	
	@RequestMapping("/")
	public ResponseEntity<List<Ativo>> findAll(){
		
		List<Ativo> ativos = service.findAll();
		return ResponseEntity.ok().body(ativos);	
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Ativo> findById(@PathVariable Long id){
		
		Ativo a = service.findById(id);
		return ResponseEntity.ok().body(a);	
	}

}
