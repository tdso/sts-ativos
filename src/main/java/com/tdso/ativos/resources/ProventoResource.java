package com.tdso.ativos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tdso.ativos.entities.Provento;
import com.tdso.ativos.services.ProventoService;

@RestController
@RequestMapping("/provs")
public class ProventoResource {
	
	@Autowired
	ProventoService service;
	
	@RequestMapping("/")
	public ResponseEntity<List<Provento>> findAll(){
		
		List<Provento> provs = service.findAll();
		return ResponseEntity.ok().body(provs);	
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Provento> findById(@PathVariable Long id){
		
		Provento p = service.findById(id);
		return ResponseEntity.ok().body(p);	
	}
	

}
