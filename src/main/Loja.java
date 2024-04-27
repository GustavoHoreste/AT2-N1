package main;

import java.util.ArrayList;

public class Loja extends Conta{
	private String nome;
	private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public Loja(String nome, Funcionario func1, Funcionario func2) {
		this.nome = nome;
		this.funcionarios.add(func1);
		this.funcionarios.add(func2);
	}
	
	public void novaCompra(double value){
		this.setsaldo(value);
		this.verificaSaldo();
	}
	
	public void verificaSaldo() {
//		double correnteSaldo = this.con
	}
	
	public void pagarFuncionarios(){
		//implementacao futura
	}
}
