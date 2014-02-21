package conta;

import java.util.ArrayList;

import conta.intgraph.ContaTabbedPanel;
import cliente.Cliente;
import data.Data;
import enums.TipoContas;

public abstract class Conta {
	
//	Painel
	private ContaTabbedPanel painelDaConta; 

	// Atributos

	private TipoContas tipo;

	private int numero;
	private double saldo;
	private Data dataAbertura;

	private ArrayList<HistoricoConta> historico = new ArrayList<HistoricoConta>();

	// alterado por Douglas 04/01/14
	private Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// fim da alteracao

	// Construtor----------
	public Conta(TipoContas tipo, Cliente cliente) {
		// TODO Auto-generated constructor stub
		this.setTipo(tipo);
		this.cliente = cliente;
	}

	// Metodo usado para ver o SALDO da conta
	public double obterSaldo() {
		return this.saldo;
	}

	// Metodos de Conta
	public boolean sacar(double valorSaque) {

		if (valorSaque > this.getSaldo()) {
			return false;
		}

		this.setSaldo(this.obterSaldo() - valorSaque);

		HistoricoConta h = new HistoricoConta();
		h.setTransacao(Transacao.SACAR);
		h.setValor(valorSaque);
		// h.setData(data);

		this.historico.add(h);

		return true;
	}
	

	// Gets AND Sets
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Data getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Data dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public TipoContas getTipo() {
		return tipo;
	}

	public void setTipo(TipoContas tipo) {
		this.tipo = tipo;
	}
	
	public ArrayList<HistoricoConta> getHistorico(){
		return this.historico;
	}
	
	
	
	public ContaTabbedPanel getPainelDaConta() {
		return painelDaConta;
	}

	public void setPainelDaConta(ContaTabbedPanel painelDaConta) {
		this.painelDaConta = painelDaConta;
	}

	public String toString(){
		return this.getNumero()+","+this.getSaldo()+","+this.getDataAbertura().toString();
	}
	
	
//	Instanciar painel
	public void instanciarPainel(){
		painelDaConta = new ContaTabbedPanel();
	}

}
