package com.pismo.teste.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long conta_id;

	@Column(nullable = false, unique = true)
	private Long doc;

	public Conta() {}

	public Conta(Long doc) {
		super();
		this.doc = doc;
	}

	public Long getConta_id() {
		return conta_id;
	}

	public void setConta_id(Long conta_id) {
		this.conta_id = conta_id;
	}

	public Long getDoc() {
		return doc;
	}

	public void setDoc(Long doc) {
		this.doc = doc;
	}

}
