package main;

public class Loja extends Conta{
	private String nome;
	
	public Loja(String nome) {
		this.nome = nome;
	}
	
	public void novaCompra(double value){
		this.setsaldo(value);
	}
}
