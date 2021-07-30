package com.loja_de_jogos.lojaDeGames.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja_de_jogos.lojaDeGames.model.Genero;
import com.loja_de_jogos.lojaDeGames.repository.GeneroRepository;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;

@RestController
@CrossOrigin("*")
@RequestMapping("/generos")
public class GeneroController {
	
	@Autowired
	public GeneroRepository repositorio;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Genero>> GetAll(){
		return ResponseEntity.status(200).body(repositorio.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Genero> GetById(@PathVariable long id){
		return repositorio.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Genero>> GetByNome(String nome){
		return ResponseEntity.status(200).body(repositorio.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<Genero> post (@RequestBody Genero genero){
		return ResponseEntity.status(200).body(repositorio.save(genero));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Genero> put (@RequestBody Genero genero){
		return ResponseEntity.status(200).body(repositorio.save(genero));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@PathVariable long id){
		Optional<Genero> generoExiste = repositorio.findById(id);
		if(generoExiste.isPresent()) {
			return ResponseEntity.status(200).body("Gênero Deletado.");
		} else {
			return ResponseEntity.status(201).body("Gênero não encontrado!");
		}
	}
}
