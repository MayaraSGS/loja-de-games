package com.loja_de_jogos.lojaDeGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja_de_jogos.lojaDeGames.model.LojaDeGames;

@Repository
public interface LojaDeGamesRepository extends JpaRepository<LojaDeGames, Long>{
	
	public List<LojaDeGames> findAllByNomeContainingIgnoreCase(String nome);

}
