package main;

//import java.lang.Thread;
//import java.lang.Runnable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco{
	private final Lock lock = new ReentrantLock();
	private Conta conta = new Conta();

	public Banco() { }
	
	public void tranferencia(Funcionario funcionario, double value) {
//		funcionario.receberSalario(value);
		lock.lock();
		try {
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
