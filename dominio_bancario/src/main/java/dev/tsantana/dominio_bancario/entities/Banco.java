package dev.tsantana.dominio_bancario.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@NoArgsConstructor
public class Banco {

	@Include
	private String nome;

	private List<Integer> agencias = new ArrayList<Integer>();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Conta> contas = new ArrayList<Conta>();

	public Banco(String nome) {
		this.nome = nome;
	}

	public void addAgencia(Integer agencia) {
		agencias.add(agencia);
	}

	public void addCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public void addConta(Conta conta) {
		if (this.verificaAgencia(conta.getAgencia())) {
			contas.add(conta);
		} else {
			System.out.println("Agencia inválida");
		}
	}

	private boolean verificaCliente(Cliente cliente) {
		if (clientes.contains(cliente)) {
			return true;
		} else {
			System.out.println("Verifica cliente falhou");
			return false;
		}
	}

	private boolean verificaConta(Conta conta) {
		if (contas.contains(conta)) {
			return true;
		} else {
			System.out.println("Verifica conta falhou");
			return false;
		}
	}

	private boolean verificaAgencia(Integer agencia) {
		if (agencias.contains(agencia)) {
			return true;
		} else {
			System.out.println("Verifica agencia falhou");
			return false;
		}
	}

	private boolean verificaClienteConta(Cliente cliente, Conta conta) {
		if (cliente.getConta().equals(conta)) {
			return true;
		} else {
			System.out.println("Verifica cliente conta falhou");
			return false;
		}
	}

	public boolean autenticar(Cliente cliente, Conta conta) {
		if (verificaCliente(cliente) & verificaConta(conta) & verificaClienteConta(cliente, conta)) {
			System.out.println("\nAutenticação bem sucedida");
			return true;
		} else {
			System.out.println("\nNão autenticado");
			return false;
		}
	}

	@Override
	public String toString() {
		return "Banco " + nome;
	}

}
