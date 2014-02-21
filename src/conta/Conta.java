package conta;

import cliente.Cliente;
import data.Data;
import enums.TipoContas;

public abstract class Conta {
	
//	Atributos
	
	private TipoContas tipo;
	
	private int numero;
	private double saldo;
	private Data dataAbertura;
	
	//alterado por Douglas 04/01/14
	private Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	//fim da alteracao
	
	
//	Construtor----------
	public Conta(TipoContas tipo, Cliente cliente) {
		// TODO Auto-generated constructor stub
		this.setTipo(tipo);
		this.cliente = cliente;
	}
	
	
//	Metodo usado para ver o SALDO da conta
	public double obterSaldo(){
		return this.saldo;
	}
	
	
//	Metodos de Conta
	public boolean sacar(double valorSaque){
		
		if (valorSaque > this.getSaldo()) {
			return false;
		}
		else {
			this.setSaldo(this.getSaldo() - valorSaque);
		}
		
		return true;
	}
	
	
//	Gets AND Sets
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
	
	
	
}
