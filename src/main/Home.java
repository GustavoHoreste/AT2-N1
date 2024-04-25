package main;

public class Home {

	public static void main(String[] args) {
		
		Conta conta1 = new Conta();
		
		conta1.setnome("gustavo");
		
		System.out.println(conta1.getnome());
		
		System.out.println("Terminei execucao");
	}
}
