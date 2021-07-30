package com.loja_de_jogos.lojaDeGames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_genero")
public class Genero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idGenero;
	
	@NotBlank(message = "Campo (nome) Obrigatorio!")
	private String nome;
	
	@OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("genero")
	private List<Ligacao> ligacao;

	public long getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(long idGenero) {
		this.idGenero = idGenero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ligacao> getLigacao() {
		return ligacao;
	}

	public void setLigacao(List<Ligacao> ligacao) {
		this.ligacao = ligacao;
	}
		
}
