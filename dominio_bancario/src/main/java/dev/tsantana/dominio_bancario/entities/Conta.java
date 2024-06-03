package dev.tsantana.dominio_bancario.entities;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
public abstract class Conta {

	private static int SEQUENCIAL = 1;

	private int agencia;

	@Include
	protected int numero;

	protected double saldo;

	private Cliente cliente;

	public Conta(int agencia, Cliente cliente) {
		this.agencia = agencia;
		this.cliente = cliente;
		this.numero = SEQUENCIAL++;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void depositar(double valor) {
		this.saldo += valor;
	}

	public abstract double sacar(double valor);

	public abstract void transferir(Conta destino, double valor);

	public abstract void extrato();

}
