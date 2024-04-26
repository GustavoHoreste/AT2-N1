package main;

public class Home {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("Gustavo");
		Cliente cliente2 = new Cliente("Pedro");
		Cliente cliente3 = new Cliente("Davi");
		Cliente cliente4 = new Cliente("Julia");
		Cliente cliente5 = new Cliente("Carlos");

		Loja amazon = new Loja("Amazon");
		Loja apple = new Loja("Apple");
		
		System.out.println("Terminei execucao");
	}
}
