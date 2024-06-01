package dev.tsantana.dominio_bancario;

import dev.tsantana.dominio_bancario.entities.Banco;

public class main {

	public static void main(String[] args) {
		
		System.out.println("Domínio Bancário DIO");
		
		Banco banco = new Banco("Santander");
		
		System.out.println(banco);
	}

}
