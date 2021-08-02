package com.loja_de_jogos.lojaDeGames.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_de_jogos.lojaDeGames.model.Genero;
import com.loja_de_jogos.lojaDeGames.model.LojaDeGames;
import com.loja_de_jogos.lojaDeGames.repository.GeneroRepository;
import com.loja_de_jogos.lojaDeGames.repository.LojaDeGamesRepository;

@Service
public class GeneroServices {

	@Autowired
	private GeneroRepository repository;

	@Autowired
	private LojaDeGamesRepository repositoryL;

	public Optional<Genero> addJogo(LojaDeGames novoJogo, Long idGenero) {
		return repository.findById(idGenero).map(generoExistente -> {
			LojaDeGames jogoCriado = repositoryL.save(novoJogo);
			generoExistente.getLojaDeGames().add(jogoCriado);
			return Optional.ofNullable(repository.save(generoExistente));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
	
	public Optional<?> addJogo2(Long idGenero, Long idJogo){
		return repository.findById(idGenero).map(generoExistente -> {
			Optional<LojaDeGames> jogoExistente = repositoryL.findById(idJogo);
			if (jogoExistente.isPresent()) {
				generoExistente.getLojaDeGames().add(jogoExistente.get());
				return Optional.ofNullable(repository.save(generoExistente));
			} else {
				return Optional.empty();
			}
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
}