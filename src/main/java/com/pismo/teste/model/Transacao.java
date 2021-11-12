package com.pismo.teste.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Objects;
import java.util.spi.CalendarNameProvider;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pismo.teste.domain.enums.TipoTransacao;

@Entity
@Table(name = "transacao")
public class Transacao{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double quantia;

	private Integer tipoOperacao;

	private Calendar dataRegistro;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conta_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Conta conta;

	public Transacao() {

	}

	public Transacao(Double quantia, Integer tipoOperacao, Calendar dataRegistro, Conta conta) {
		super();
		this.quantia = quantia;
		this.tipoOperacao = tipoOperacao;
		this.dataRegistro = Calendar.getInstance();
		this.conta = conta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		return Objects.equals(id, other.id);
	}

	public Double getQuantia() {
		return quantia;
	}

	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}

	public TipoTransacao getTipoOperacao() throws IllegalAccessException {
		return TipoTransacao.toEnum(tipoOperacao);
	}

	public void setTipoOperacao(TipoTransacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao.getCod();
	}

	public Calendar getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Calendar dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Conta getConta_id() {
		return conta;
	}

	public void setConta_id(Conta conta) {
		this.conta = conta;
	}

}
