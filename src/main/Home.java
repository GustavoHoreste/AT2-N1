package main;

import java.util.ArrayList;

public class Home {

	public static void main(String[] args) {
		
		Funcionario gustavo = new Funcionario("gustavo");
		Funcionario carlos = new Funcionario("carlos");
		Funcionario jose = new Funcionario("jose");
		Funcionario henrique = new Funcionario("henrique");
		
		ArrayList<Loja> lojas = new ArrayList<Loja>();
		Loja amazon = new Loja("Amazon", gustavo, carlos);
		Loja apple = new Loja("Apple", jose, henrique);
		lojas.add(apple);
		lojas.add(amazon);
		
		Cliente cliente1 = new Cliente("Gustavo", lojas);
		Cliente cliente2 = new Cliente("Pedro", lojas);
		Cliente cliente3 = new Cliente("Davi", lojas);
		Cliente cliente4 = new Cliente("Julia", lojas);
		Cliente cliente5 = new Cliente("Carlos", lojas);

		Banco banco = new Banco();
		banco.tranferencia(carlos, 1400);
		banco.tranferencia(gustavo, 1400);
		
	}
}
