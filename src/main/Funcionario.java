package main;

import java.lang.Thread;
import java.lang.Runnable;

public class Funcionario implements Runnable{
	private String nome;
	private Conta contaPoupanca = new Conta();
	private Conta contaCorrente = new Conta();
	

	public Funcionario(String nome) {
		this.nome = nome;
		this.starThread();
	}
	
	
	@Override
	public void run() { }
	
	public String getnome() {
		return this.nome;
	}
	
	public void starThread() {
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void receberSalario(double value) {
		this.contaPoupanca.setsaldo(value);
		this.fazerInvestimento();
	}
	
	private void fazerInvestimento() {
		this.contaCorrente.setsaldo(this.contaPoupanca.getsaldo() * 0.2);
//		System.out.println("Funcionario - [" + this.nome + "] possui [" + this.contaCorrente.getsaldo() + "] investidos");
	}
}
