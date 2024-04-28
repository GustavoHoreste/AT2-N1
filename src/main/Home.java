package main;

import java.util.ArrayList;

public class Home {

	public static void main(String[] args) {
		
		Banco banco = new Banco();
		
		Funcionario gustavo = new Funcionario("Gustavo");
		Funcionario carlos = new Funcionario("Carlos");
		Funcionario jose = new Funcionario("Jose");
		Funcionario henrique = new Funcionario("Henrique");
		
		ArrayList<Loja> lojas = new ArrayList<Loja>();
		Loja amazon = new Loja("Amazon", gustavo, carlos, banco);
		Loja apple = new Loja("Apple", jose, henrique, banco);
		lojas.add(apple);
		lojas.add(amazon);
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Cliente cliente1 = new Cliente("Cliente1", lojas);
		Cliente cliente2 = new Cliente("Cliente2", lojas);
		Cliente cliente3 = new Cliente("Cliente3", lojas);
		Cliente cliente4 = new Cliente("Cliente4", lojas);
		Cliente cliente5 = new Cliente("Cliente5", lojas);
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);
		clientes.add(cliente5);
		
		try {
		    Thread.sleep(1000); 
		    banco.exibirHistorico();
		    ValoresFinais vf = new ValoresFinais(lojas, clientes);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}
}
