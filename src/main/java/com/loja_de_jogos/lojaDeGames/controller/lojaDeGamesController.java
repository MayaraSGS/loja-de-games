package com.loja_de_jogos.lojaDeGames.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.loja_de_jogos.lojaDeGames.model.LojaDeGames;
import com.loja_de_jogos.lojaDeGames.repository.LojaDeGamesRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/lojaGamer")
public class LojaDeGamesController {
	
	@Autowired
	private LojaDeGamesRepository repositorio;
	
	@GetMapping("/todos")
	public ResponseEntity<List<LojaDeGames>> GetAll(){
		return ResponseEntity.status(200).body(repositorio.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LojaDeGames> GetById(@PathVariable Long id){
		return repositorio.findById(id)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<LojaDeGames>> GetByNome(@PathVariable String nome){
		return ResponseEntity.status(200).body(repositorio.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<LojaDeGames> post (@Valid @RequestBody LojaDeGames lojaDeGames){
		return ResponseEntity.status(200).body(repositorio.save(lojaDeGames));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<LojaDeGames> put (@Valid @RequestBody LojaDeGames lojaDeGames){
		return ResponseEntity.status(200).body(repositorio.save(lojaDeGames));
	}
	
	@DeleteMapping("/deletar")
	public ResponseEntity<String> delete(@PathVariable Long id){
		Optional<LojaDeGames> gameExiste = repositorio.findById(id);
		if(gameExiste.isPresent()) {
			return ResponseEntity.status(200).body("Jogo Deletado.");
		} else {
			return ResponseEntity.status(201).body("Jogo não encontrado!");
		}
		
	}

}
