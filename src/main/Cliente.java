package main;

import java.lang.Thread;
import java.lang.Runnable;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;


public class Cliente extends Conta implements Runnable{
	private String nome;
	private ArrayList<Loja> lojas = new ArrayList<Loja>();
	
	private final Lock lock = new ReentrantLock();
	
	public Cliente(String nome, ArrayList<Loja> lojas) {
		this.nome = nome;
		this.lojas = lojas;
		
		this.startConta();
		this.starThread();
	}
	
	@Override
	public  void run() {
		lock.lock();
		try {
			this.fazendoCompras();
		}finally{
			lock.unlock();
		}
	}
	
	private void fazendoCompras() {
		double saldoCorrente = this.getsaldo();
		boolean ultimaCompra = false;
		
		while(saldoCorrente > 0 ) {
			double valorCompra = valorCompraAleatorio();
			if (saldoCorrente >= valorCompra) {
				if (ultimaCompra == true) {
					this.compraNaLoja(lojas.get(0), valorCompra);
					saldoCorrente = this.subtraiNovaCompra(saldoCorrente, valorCompra);
					ultimaCompra = false;
				}else {
					this.compraNaLoja(lojas.get(1), valorCompra);
					saldoCorrente = this.subtraiNovaCompra(saldoCorrente, valorCompra);
					ultimaCompra = true;
				}
			}
		}
		
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
	
	//retorna um valor aleatorio de compra
	private double valorCompraAleatorio() {
		Random random = new Random();
		int value = random.nextInt(2);
		return (value == 0) ? 100 : 200;
	}
	
	private double subtraiNovaCompra(double corrSaldo, double valorCompra) {
		this.setsaldo(corrSaldo - valorCompra);
		return this.getsaldo();
	}
	
	private void compraNaLoja(Loja loja, double valor) {
		loja.novaCompra(valor, this, loja);
	}
}
