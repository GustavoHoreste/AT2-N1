package main;

import java.lang.Thread;
import java.lang.Runnable;


public class Cliente extends Conta implements Runnable{
	private String nome;
	
	public Cliente(String nome) {
		this.nome = nome;
		
		this.startConta();
		this.starThread();
	}
	
	
	@Override
	public void run() {
		System.out.println(this.getnome());
//		for(int i = 0; i<5; i++) {
//			this.setsaldo(getsaldo() - 200);
//			System.out.println(this.getsaldo());
//		}
	}
	
	//funcao que cria e star o thread
	public void starThread() {
		Thread thread = new Thread(this);
		thread.start();
	}
	
	private void startConta() {
		this.setnome(this.nome);
		this.setsaldo(1000);
	}
}
