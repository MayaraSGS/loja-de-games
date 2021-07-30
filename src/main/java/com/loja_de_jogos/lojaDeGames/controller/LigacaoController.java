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

import com.loja_de_jogos.lojaDeGames.model.Ligacao;
import com.loja_de_jogos.lojaDeGames.repository.LigacaoRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/ligacao")
public class LigacaoController {
	
	@Autowired
	private LigacaoRepository repositorio;

	@GetMapping("/todos")
	public ResponseEntity<List<Ligacao>> GetAll(){
		return ResponseEntity.status(200).body(repositorio.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ligacao> GetById(@PathVariable long id){
		return repositorio.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<Ligacao> post (@RequestBody Ligacao ligacao){
		return ResponseEntity.status(200).body(repositorio.save(ligacao));
	}
	
	@PutMapping("/alterar")
	public ResponseEntity<Ligacao> put (@RequestBody Ligacao ligacao){
		return ResponseEntity.status(200).body(repositorio.save(ligacao));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@PathVariable long id){
		Optional<Ligacao> ligacaoExiste = repositorio.findById(id);
		if(ligacaoExiste.isPresent()) {
			return ResponseEntity.status(200).body("Ligação Deletada.");
		} else {
			return ResponseEntity.status(200).body("Ligação não Existe!");
		}
	}
}
