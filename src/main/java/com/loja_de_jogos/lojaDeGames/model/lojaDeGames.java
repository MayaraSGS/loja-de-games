package com.loja_de_jogos.lojaDeGames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_games")
public class lojaDeGames {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLoja;
	
	@NotBlank(message = "Campo (nome) obrigatorio!")
	private String nome;
	
	@NotBlank(message = "Campo (classificação) obrigatorio!")
	private String classificacao;
	
	@NotBlank(message = "Campo monetario (valor) obrigatorio!")
	private double valor;
	
	@OneToMany(mappedBy = "lojaDeGames", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("lojaDeGames")
	private List<Ligacao> ligacao;
	
	public long getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(long idLoja) {
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Ligacao> getLigacao() {
		return ligacao;
	}

	public void setLigacao(List<Ligacao> ligacao) {
		this.ligacao = ligacao;
	}
	
}
