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

import com.loja_de_jogos.lojaDeGames.model.Genero;
import com.loja_de_jogos.lojaDeGames.model.LojaDeGames;
import com.loja_de_jogos.lojaDeGames.repository.GeneroRepository;
import com.loja_de_jogos.lojaDeGames.services.GeneroServices;

@RestController
@CrossOrigin("*")
@RequestMapping("/generos")
public class GeneroController {

	@Autowired
	private GeneroRepository repositorio;

	@Autowired
	private GeneroServices services;

	@GetMapping("/todos")
	public ResponseEntity<List<Genero>> GetAll() {
		return ResponseEntity.status(200).body(repositorio.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Genero> GetById(@PathVariable Long id) {
		return repositorio.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Genero>> GetByNome(String nome) {
		return ResponseEntity.status(200).body(repositorio.findAllByNomeContainingIgnoreCase(nome));
	}

	@PostMapping("/adicionar")
	public ResponseEntity<Genero> post(@Valid @RequestBody Genero genero) {
		return ResponseEntity.status(200).body(repositorio.save(genero));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Genero> put(@Valid @RequestBody Genero genero) {
		return ResponseEntity.status(200).body(repositorio.save(genero));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		Optional<Genero> generoExiste = repositorio.findById(id);
		if (generoExiste.isPresent()) {
			return ResponseEntity.status(200).body("Gênero Deletado.");
		} else {
			return ResponseEntity.status(201).body("Gênero não encontrado!");
		}
	}

	@PutMapping("/boaz/genero/{id_genero}")
	public ResponseEntity<Genero> addJogoAGenero(@Valid @RequestBody LojaDeGames novoJogo,
			@PathVariable(value = "id_genero") Long idGenero) {
		return services.addJogo(novoJogo, idGenero).map(jogoCriado -> ResponseEntity.status(201).body(jogoCriado))
				.orElse(ResponseEntity.status(400).build());
	}

	@PutMapping("/boaz2/genero/{id_genero}/jogo/{id_jogo}")
	public ResponseEntity<?> addJogoAGenero2(@PathVariable(value = "id_genero") Long idGenero,
			@PathVariable(value = "id_jogo") Long idJogo) {
		return services.addJogo2(idGenero, idJogo).map(jogoAdcionado -> ResponseEntity.status(201).body(jogoAdcionado))
				.orElse(ResponseEntity.status(400).build());
	}
}
