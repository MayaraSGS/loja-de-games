package com.loja_de_jogos.lojaDeGames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ligação")
public class Ligacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLigacao;

	@ManyToOne
	@JsonIgnoreProperties("Ligacao")
	private lojaDeGames lojaDeGames;
	
	@ManyToOne
	@JsonIgnoreProperties("Ligacao")
	private Genero genero;

	public long getIdLigacao() {
		return idLigacao;
	}

	public void setIdLigacao(long idLigacao) {
		this.idLigacao = idLigacao;
	}

	public lojaDeGames getLojaDeGames() {
		return lojaDeGames;
	}

	public void setLojaDeGames(lojaDeGames lojaDeGames) {
		this.lojaDeGames = lojaDeGames;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
}
