package com.avaliacao.models;

import java.time.LocalDateTime;
import java.util.List;

import com.avaliacao.util.BeneficiarioSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
@JsonSerialize(using = BeneficiarioSerializer.class )
public class Beneficiario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id", nullable=false)
	private int id;
	
	@Column(name="Nome", nullable=false)
	private String nome;
	
	@Column(name="Telefone")
	private String telefone;
	
	@Column(name="Data Nascimento")
	private String dataNascimento;
	
	@Column(name="Data Inclusao")
	private LocalDateTime dataInclusao;
	
	@Column(name="Data Atualizacao")
	private LocalDateTime dataAtualizacao;
	
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="beneficiario", cascade=CascadeType.ALL)
//	private List<Documento> documentos;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true )
	@JoinColumn(name="beneficiario_Id")	
	private List<Documento> documentos;

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public Beneficiario() {}
	
	public Beneficiario(String nome, String telefone, String dataNascimento, LocalDateTime dataInclusao,
			LocalDateTime dataAtualizacao) {
		this.nome = nome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.dataInclusao = dataInclusao;
		this.dataAtualizacao = dataAtualizacao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public LocalDateTime getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(LocalDateTime dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
}
