package com.tdso.ativos.entities.enums;

public enum TipoOperacao {
	
	COMPRA(1),
	VENDA(2),
	ALUGUEL(3);
	
	private int code;
	
	// note que o contructor para enum é privado
	private TipoOperacao (int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TipoOperacao valueOf(int code) {
		for (TipoOperacao value : TipoOperacao.values()) {
			if (code == value.getCode()) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo invalido para o tipo de Operação");
	}
	

}
