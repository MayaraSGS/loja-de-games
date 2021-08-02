package com.loja_de_jogos.lojaDeGames.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_genero")
public class Genero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGenero;
	
	//@NotBlank(message = "Campo (nome) Obrigatorio!")
	private String nome;
	
	@ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinTable(
		name = "tb_game",
		joinColumns = @JoinColumn(name = "id_genero"),
		inverseJoinColumns = @JoinColumn(name = "id_loja"))
	@JsonIgnoreProperties("genero")
	private List<LojaDeGames> lojaDeGames;

	public Long getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Long idGenero) {
		this.idGenero = idGenero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<LojaDeGames> getLojaDeGames() {
		return lojaDeGames;
	}

	public void setLojaDeGames(List<LojaDeGames> lojaDeGames) {
		this.lojaDeGames = lojaDeGames;
	}
	
}
