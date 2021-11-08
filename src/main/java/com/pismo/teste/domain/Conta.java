package com.pismo.teste.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;


@Entity
public class Conta {
	
	public enum TipoOperacao {
		
		COMPRAVISTA, COMPRAPARC, SAQUE, PAGAMENTO
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(nullable = false, length = 14)
	private Long Doc;
	
	@Enumerated(EnumType.STRING)
	@NonNull
	private TipoOperacao tipoOperacao;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getDoc() {
		return Doc;
	}

	public void setDoc(Long doc) {
		Doc = doc;
	}

	public TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	
}
