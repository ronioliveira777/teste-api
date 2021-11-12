package com.pismo.teste.domain.enums;

public enum TipoTransacao {

	COMPRAVISTA(1, "Compra a vista"), COMPRAPARC(2, "Compra Parcelada"), SAQUE(3, "Saque"), PAGAMENTO(4, "Pagamento");

	private int cod;
	private String descricao;

	private TipoTransacao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoTransacao toEnum(Integer cod) throws IllegalAccessException {
		if (cod == null) {
			return null;
		}
		for (TipoTransacao x : TipoTransacao.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalAccessException("Id Inválido: " + cod);

	}

}
