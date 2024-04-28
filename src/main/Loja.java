package main;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Loja extends Conta{
	private String nome;
	private Banco banco;
	private Funcionario ultimoFuncionario;
	private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	private final Lock lock = new ReentrantLock();
	
	public Loja(String nome, Funcionario func1, Funcionario func2, Banco banco) {
		this.nome = nome;
		this.banco = banco;
		this.funcionarios.add(func1);
		this.funcionarios.add(func2);
	}
	
	public void novaCompra(double value, Cliente cliente, Loja loja){
		lock.lock();
		try {
			double novoValue = this.getsaldo() + value;
			this.setsaldo(novoValue);
			this.banco.adicionarHistoricoCompra(cliente, loja, value);
			this.verificaSaldo();
		} finally {
			lock.unlock();
		}
	}
	
	public void verificaSaldo() {
		double correnteSaldo = this.getsaldo();
		if (correnteSaldo >= 1400 ) {
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
		this.banco.adicionarHistoricoDePagemento(ultimoFuncionario, this.getsaldo(), this);
	}
	
	public String getnome() {
		return this.nome;
	}
}
