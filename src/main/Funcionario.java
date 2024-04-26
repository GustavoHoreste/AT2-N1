package main;

import java.lang.Thread;
import java.lang.Runnable;

public class Funcionario implements Runnable{
	private String nome;
	private Conta contaPoupanca;
	private Conta contaCorrente;
	
	public Funcionario() {
		
		this.starThread();
	}
	
	
	@Override
	public void run() {
		
	}
	
	public void starThread() {
		Thread thread = new Thread(this);
		thread.start();
	}
	
	private void fazerInvestimento() {
		this.contaCorrente = this.contaPoupanca * 0.2;
	}
}
