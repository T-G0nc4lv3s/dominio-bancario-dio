package dev.tsantana.dominio_bancario.entities;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(int agencia, Cliente cliente) {
		super(agencia, cliente);
	}

	@Override
	public void extrato() {
		System.out.printf("\nAgencia: %d \nConta: %d \nSaldo: %.2f \n", this.getAgencia(), this.getNumero(),
				this.getSaldo());
	}

	@Override
	public double sacar(double valor) {
		if (this.getSaldo() >= valor) {
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
		if (this.getSaldo() >= valor) {
			double saque = this.sacar(valor);
			destino.depositar(saque);
			System.out.println("Transferência realizada com sucesso.");
			System.out.printf("Conta Origem: %s \nConta Destino: %s \nValor: R$ %.2f", this.getNumero(),
					destino.getNumero(), saque);
		} else {
			System.out.println("Transferência não autorizada. \nSaldo insuficiente");
		}
	}

}
