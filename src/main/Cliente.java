package main;

import java.lang.Thread;
import java.lang.Runnable;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Cliente extends Conta implements Runnable{
	private String nome;
	private Conta conta = new Conta();
	private ArrayList<Loja> lojas = new ArrayList<Loja>();
	
	private final Lock lock = new ReentrantLock();
	
	public Cliente(String nome, ArrayList<Loja> lojas) {
		this.nome = nome;
		this.lojas = lojas;
		
		this.startConta();
		this.starThread();
	}
	
	
	@Override
	public void run() {
		lock.lock();
		try {
			this.fazendoCompras();
		}finally{
			lock.unlock();
		}
	}
	
	private void fazendoCompras() {
		this.conta.setsaldo(10000);
//		while()
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
