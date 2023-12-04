package com.avaliacao.models;

import java.time.LocalDateTime;

import com.avaliacao.util.BeneficiarioSerializer;
import com.avaliacao.util.DocumentoSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@JsonSerialize(using = DocumentoSerializer.class )
public class Documento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id", nullable=false)
	private int id;
	
	@Column(name="Tipo Documento", nullable=false)
	private String tipoDocumento;
	
	@Column(name="Descricao")
	private String descricao;
	
	@Column(name="Data Inclusao")
	private LocalDateTime dataInclusao;
	
	@Column(name="Data Atualizacao")
	private LocalDateTime dataAtualizacao;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name="beneficiario_Id")
	private Beneficiario beneficiario;

	public Documento() {}
	
	public Documento(int id, String tipoDocumento, String descricao, LocalDateTime dataInclusao, LocalDateTime dataAtualizacao) {
		super();
		this.id = id;
		this.tipoDocumento = tipoDocumento;
		this.descricao = descricao;
		this.dataInclusao = dataInclusao;
		this.dataAtualizacao = dataAtualizacao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	
	public Beneficiario getBenefeficiario() {
		return beneficiario;
	}

	public void setBenefeficiario(Beneficiario benefeficiario) {
		this.beneficiario = benefeficiario;
	}	
	
}
