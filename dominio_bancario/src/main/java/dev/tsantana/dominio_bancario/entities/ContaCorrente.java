package dev.tsantana.dominio_bancario.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaCorrente extends Conta {

	private double limite;

	public ContaCorrente(int agencia, Cliente cliente, double limite) {
		super(agencia, cliente);
		this.limite = limite;
	}

	@Override
	public double sacar(double valor) {
		double valorPosSaque = this.getSaldo() - valor;
		double limiteMaximo = -this.getLimite();

		if (valorPosSaque >= limiteMaximo) {
			this.saldo -= valor;
			// System.out.printf("Saque realizado com sucesso. \nSaldo atual: R$ %.2f",
			// this.getSaldo());
			return valor;
		} else {
			// System.out.println("Não autorizado. \nSaldo insuficiente");
			return 0;
		}
	}

	@Override
	public void transferir(Conta destino, double valor) {
		if ((this.getSaldo() + this.getLimite()) >= valor) {
			double saque = this.sacar(valor);
			destino.depositar(saque);
			System.out.println("Transferencia realizada com sucesso.");
			System.out.printf("Conta Origem: %s \nConta Destino: %s \nValor: R$ %.2f", this.getNumero(),
					destino.getNumero(), saque);
		} else {
			System.out.println("Transferencia não autorizada. \nSaldo insuficiente");
		}
	}

	@Override
	public void extrato() {
		System.out.printf("\nAgencia: %d \nConta: %d \nSaldo: %.2f \nLimite: %.2f \n", this.getAgencia(),
				this.getNumero(), this.getSaldo(), this.getLimite());

	}

}
