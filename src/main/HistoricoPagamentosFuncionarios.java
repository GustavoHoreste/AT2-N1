package main;

public class HistoricoPagamentosFuncionarios {
    private Funcionario funcionario;
    private double valorPago;
    private Loja loja;

    public HistoricoPagamentosFuncionarios(Funcionario func, double value, Loja loja) {
        this.funcionario = func;
        this.valorPago = value;
        this.loja = loja;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
}

