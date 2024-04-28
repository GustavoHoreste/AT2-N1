package main;

import java.util.ArrayList;

public class ValoresFinais {
	private ArrayList<Loja> lojas = new ArrayList<Loja>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public ValoresFinais(ArrayList<Loja> lojas, ArrayList<Cliente> clientes) {
		this.clientes = clientes;
		this.lojas = lojas;
		
		this.imprimirValoresFinais();
	}
	
	
	private void imprimirValoresFinais() {
	    StringBuilder lojasTabela = new StringBuilder();
	    StringBuilder clientesTabela = new StringBuilder();

	    lojasTabela.append("Saldo final das lojas:\n");
	    lojasTabela.append("Loja\t\tSaldo Final\n");
	    lojasTabela.append("----\t\t------------\n");

	    for (Loja loja : lojas) {
	        lojasTabela.append(loja.getnome())
	              .append("\t\tR$ ")
	              .append(String.format("%.2f", loja.getsaldo()))
	              .append("\n");
	    }

	    clientesTabela.append("Saldo final dos clientes:\n");
	    clientesTabela.append("Cliente\t\tSaldo Final\n");
	    clientesTabela.append("-------\t\t------------\n");

	    for (Cliente cliente : clientes) {
	        clientesTabela.append(cliente.getnome())
	              .append("\tR$ ")
	              .append(String.format("%.2f", cliente.getsaldo()))
	              .append("\n");
	    }

	    
	    System.out.println(lojasTabela);
	    System.out.println("\u001B[34m---------------------------------------------\u001B[0m");
	    System.out.println(clientesTabela);
	}


}
