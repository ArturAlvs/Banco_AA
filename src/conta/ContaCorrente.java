package conta;

import cliente.Cliente;
import enums.TipoContas;

public class ContaCorrente extends ContaBancaria {
	
//	Atributos

	private static TipoContas tipo = TipoContas.CONTA_CORRENTE;
		
	private double taxaJuros;
	private double limiteSaque;
	private double taxaServico;

	
	public ContaCorrente(Cliente cliente) {
		// TODO Auto-generated constructor stub
		
		super(tipo, cliente);
		
		this.setTaxaJuros(7.0);
		this.setLimiteSaque(200.00);
		this.setTaxaServico(50.00);
		
	}
	
	
	// Override da classe abstract ContaBancaria
	@Override
	public void aplicarRendimentos() {
		// TODO Auto-generated method stub

	}
	
//	Override da classe Conta
	@Override
	public boolean sacar(double valorSaque) {
		// TODO Auto-generated method stub
		
		if (valorSaque > this.getLimiteSaque()) {
			return false;
		}
		else {
			super.setSaldo(super.getSaldo() - valorSaque);
		}
		
		return true;
	}
	
	
//	Gets 'n' Sets
	public double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	public double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public double getTaxaServico() {
		return taxaServico;
	}

	public void setTaxaServico(double taxaServico) {
		this.taxaServico = taxaServico;
	}

	
	public String toString(){
		return super.toString()+","+this.getLimiteSaque()+","+this.getTaxaJuros()+","+this.getTaxaServico();
	}
	
	

}
