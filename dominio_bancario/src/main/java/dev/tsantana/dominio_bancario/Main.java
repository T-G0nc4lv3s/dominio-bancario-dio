package dev.tsantana.dominio_bancario;

import dev.tsantana.dominio_bancario.entities.Banco;
import dev.tsantana.dominio_bancario.entities.Cliente;
import dev.tsantana.dominio_bancario.entities.Conta;
import dev.tsantana.dominio_bancario.entities.ContaCorrente;
import dev.tsantana.dominio_bancario.entities.ContaPoupanca;

public class Main {

	public static void main(String[] args) {

		System.out.println("Domínio Bancário DIO");
		Banco banco = new Banco("Santander");
		banco.addAgencia(4241);
		banco.addAgencia(4254);
		banco.addAgencia(4366);
		banco.addAgencia(4389);

		System.out.println(banco);
		System.out.println("----------");

		Cliente cliente1 = new Cliente("Osnobor");

		Conta cp = new ContaPoupanca(4241, cliente1);

		cliente1.setConta(cp);

		banco.addCliente(cliente1);
		banco.addConta(cp);

		cp.depositar(500);
		cp.extrato();

		boolean autenticado = banco.autenticar(cliente1, cp);

		if (autenticado) {
			double saque = cp.sacar(100);
			if (saque != 0) {
				System.out.printf("\nSaque realizado com sucesso.\n");
			} else {
				System.out.println("\nNão autorizado.\nSaldo insuficiente\n");
			}
		}

		cp.extrato();

		Cliente cliente2 = new Cliente("Riump");
		Conta cc = new ContaCorrente(4254, cliente2, 250);

		banco.addCliente(cliente2);
		banco.addConta(cc);

		cliente2.setConta(cc);
		cc.depositar(250);

		cc.extrato();

		autenticado = banco.autenticar(cliente2, cc);

		if (autenticado) {
			double saque = cc.sacar(300);
			if (saque != 0) {
				System.out.printf("\nSaque realizado com sucesso.\n");
			} else {
				System.out.println("\nNão autorizado.\nSaldo insuficiente\n");
			}
		}

		cc.extrato();

		autenticado = banco.autenticar(cliente1, cp);

		if (autenticado) {
			cp.transferir(cc, 100);
		}
		System.out.println();
		cc.extrato();

	}

}
