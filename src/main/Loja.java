package main;

import java.util.ArrayList;

public class Loja extends Conta{
	private String nome;
	private Banco banco = new Banco();
	private Funcionario ultimoFuncionario;
	private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public Loja(String nome, Funcionario func1, Funcionario func2) {
		this.nome = nome;
		this.funcionarios.add(func1);
		this.funcionarios.add(func2);
	}
	
	public synchronized void novaCompra(double value){
		double novoValue = this.getsaldo() + value;
		this.setsaldo(novoValue);
		this.verificaSaldo();
	}
	
	public void verificaSaldo() {
		double correnteSaldo = this.getsaldo();
		if (correnteSaldo >= 1400 ) {
			System.out.println("Saldo "+ this.nome + " " + this.getsaldo() + " saldo corrente " + correnteSaldo);
			this.pagarFuncionario();
		}
	}
	
	public void pagarFuncionario() {
	    if (ultimoFuncionario != null && funcionarios.contains(ultimoFuncionario)) {
	        int proximoIndice = (funcionarios.indexOf(ultimoFuncionario) + 1) % funcionarios.size();
	        this.transferencia(proximoIndice);
	    }else {
	        this.transferencia(0);
	    }
	}
	
	private void transferencia(int index) {
		this.banco.tranferencia(funcionarios.get(index), 1400);
		this.setsaldo(getsaldo() - 1400);
		this.ultimoFuncionario = this.funcionarios.get(index);
	}
	
	public String getnome() {
		return this.nome;
	}
}
