package main;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;

public class Banco{
	private final Lock lock = new ReentrantLock();
	private Conta conta = new Conta();
	private ArrayList<HistoricoCompras> historicoCompras = new ArrayList<HistoricoCompras>();
	private ArrayList<HistoricoPagamentosFuncionarios> historicoPagamentosFuncionarios = new ArrayList<HistoricoPagamentosFuncionarios>();

	public Banco() { }
	
	public void tranferencia(Funcionario funcionario, double value) {
		lock.lock();
		try {
//			System.out.println("Funcionario " + funcionario.getnome() + " recebeu " + value);
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
	
	public void adicionarHistoricoCompra(Cliente cliente, Loja loja, double value) {
	    lock.lock();
	    try {
	        HistoricoCompras historico = new HistoricoCompras(cliente, loja, value);
	        historicoCompras.add(historico);
	    } finally {
	        lock.unlock();
	    }
	}

	
	public void adicionarHistoricoDePagemento(Funcionario func, double value, Loja loja) {
	    lock.lock();
	    try {
	        HistoricoPagamentosFuncionarios historico = new HistoricoPagamentosFuncionarios(func, value, loja);
	        historicoPagamentosFuncionarios.add(historico);
	    } finally {
	        lock.unlock();
	    }
	}
	
	public void exibirHistorico() {
	    StringBuilder historicoComprasTabela = new StringBuilder();
	    StringBuilder historicoPagamentosTabela = new StringBuilder();

	    historicoComprasTabela.append("Histórico de Compras:\n");
	    historicoComprasTabela.append("Cliente\t\tLoja\tValor da Compra\n");
	    historicoComprasTabela.append("-------\t\t----\t---------------\n");

	    for (HistoricoCompras compra : historicoCompras) {
	        historicoComprasTabela.append(compra.getCliente().getnome())
	              .append("\t")
	              .append(compra.getLoja().getnome())
	              .append("\t")
	              .append("R$")
	              .append(String.format("%.2f", compra.getValue()))
	              .append("\n");
	    }

	    historicoPagamentosTabela.append("Histórico de Pagamentos de Funcionários:\n");
	    historicoPagamentosTabela.append("Funcionário\tLoja\tValor do Pagamento\n");
	    historicoPagamentosTabela.append("-----------\t----\t-------------------\n");

	    for (HistoricoPagamentosFuncionarios pagamento : historicoPagamentosFuncionarios) {
	        historicoPagamentosTabela.append(pagamento.getFuncionario().getnome())
	              .append("\t\t")
	              .append(pagamento.getLoja().getnome())
	              .append("\t")
	              .append("R$")
	              .append(String.format("1.400,00"))
	              .append("\n");
	    }

	    System.out.println("Bem-vindo ao Histórico:");
	    System.out.println(historicoComprasTabela);
	    System.out.println(historicoPagamentosTabela);
	}


}
