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
		
		Cliente cliente1 = new Cliente("cliente1", lojas);
		Cliente cliente2 = new Cliente("cliente2", lojas);
		Cliente cliente3 = new Cliente("cliente3", lojas);
		Cliente cliente4 = new Cliente("cliente4", lojas);
		Cliente cliente5 = new Cliente("cliente5", lojas);
	}
}
