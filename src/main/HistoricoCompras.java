package main;

public class HistoricoCompras {
	private Cliente cliente;
	private Loja loja;
	private double value;
	
	public HistoricoCompras(Cliente cliente, Loja loja, double value) {
		this.loja = loja;
		this.cliente = cliente;
		this.value = value;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
