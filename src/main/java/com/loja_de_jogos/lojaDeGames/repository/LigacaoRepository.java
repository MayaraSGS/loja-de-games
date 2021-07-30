package com.loja_de_jogos.lojaDeGames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja_de_jogos.lojaDeGames.model.Ligacao;

@Repository
public interface LigacaoRepository extends JpaRepository<Ligacao, Long>{

}
