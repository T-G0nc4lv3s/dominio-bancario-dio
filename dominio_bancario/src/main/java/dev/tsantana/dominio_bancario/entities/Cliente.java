package dev.tsantana.dominio_bancario.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
public class Cliente {

	@Include
	private String nome;

	@Include
	private Conta conta;

	public Cliente(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cliente: " + nome;
	}

}
