package com.alexandredias.course.entities.enums;

public enum OrderStatus {
	// atribuimos um valor numerico para cada um para evitar erro ao acrescentar
	// outros, evitando que seja gerado automaticamente
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);

//precisamos criar um  code para o tipo enum
	private int code;

//esse construtor do tipo enum precisa ser privado
	private OrderStatus(int code) {
		this.code = code;
	}

//para poder acessar externo
	public int getCode() {
		return code;
	}

//precisamos de um metodo static para converter o valor numerico para o tipo enum
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
