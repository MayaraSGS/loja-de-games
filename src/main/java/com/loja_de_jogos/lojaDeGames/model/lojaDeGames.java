package com.loja_de_jogos.lojaDeGames.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_games")
public class LojaDeGames {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLoja;
	
	//@NotBlank(message = "Campo (nome) obrigatorio!")
	private String nome;
	
	//@NotBlank(message = "Campo (classificação) obrigatorio!")
	private String classificacao;
	
	//@NotBlank(message = "Campo monetario (valor) obrigatorio!")
	private Float valor;
	
	@ManyToMany(mappedBy = "lojaDeGames", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER) //--------------------------------------------------
	@JsonIgnoreProperties("lojaDeGames")
	private List<Genero> genero;
	
	public Long getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(Long idLoja) {
		this.idLoja = idLoja;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public List<Genero> getGenero() {
		return genero;
	}

	public void setGenero(List<Genero> genero) {
		this.genero = genero;
	}
	
}
