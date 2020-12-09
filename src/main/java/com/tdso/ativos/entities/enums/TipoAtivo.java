package com.tdso.ativos.entities.enums;

public enum TipoAtivo {
	FII(1),
	ACOES(2),
	FMM(3),
	IMOVEL(4);
	
	private int code;
	
	// note que o contructor para enum é privado
	private TipoAtivo (int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TipoAtivo valueOf(int code) {
		for (TipoAtivo tipo : TipoAtivo.values()) {
			if (tipo.getCode() == code) {
				return tipo;
			}
		}
		throw new IllegalArgumentException("Codigo invalido para o Tipo de Ativo");
	}

}
