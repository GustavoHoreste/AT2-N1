package main;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco{
	private final Lock lock = new ReentrantLock();
	private Conta conta = new Conta();

	public Banco() { }
	
	public synchronized void tranferencia(Funcionario funcionario, double value) {
		lock.lock();
		try {
			System.out.println("Funcionario " + funcionario.getnome() + " recebeu " + value);
			funcionario.receberSalario(value);
		} finally {
			lock.unlock();
		}
	}
	
	public Conta getconta() {
		return this.conta;
	}
	
	public void setconta(Conta conta) {
		this.conta = conta;
	}
}
