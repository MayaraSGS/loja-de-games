package com.loja_de_jogos.lojaDeGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja_de_jogos.lojaDeGames.model.lojaDeGames;

@Repository
public interface lojaDeGamesRepository extends JpaRepository<lojaDeGames, Long>{
	
	public List<lojaDeGames> findAllByNomeContainingIgnoreCase(String nome);

}
