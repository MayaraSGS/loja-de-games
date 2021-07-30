package com.loja_de_jogos.lojaDeGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.loja_de_jogos.lojaDeGames.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long>{

	public List<Genero> findAllByNomeContainingIgnoreCase(String nome);
}
