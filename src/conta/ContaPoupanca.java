package conta;

import cliente.Cliente;
import data.Data;
import enums.TipoContas;

public class ContaPoupanca extends ContaBancaria {
	
//	Atributos
	
	private static TipoContas tipo = TipoContas.CONTA_POUPANCA;
	
	private Data dataAniversario;
	private double taxaRendimento;
	
	public ContaPoupanca(Cliente cliente) {
		// TODO Auto-generated constructor stub
		super(tipo, cliente);
		
		this.setTaxaRendimento(0.1);
	}
	
//	Override do metodo de ContaBancaria
	@Override
	public void aplicarRendimentos() {
		// TODO Auto-generated method stub
		super.setSaldo(super.getSaldo() * (1 + this.getTaxaRendimento()));
		
	}
	
	
//	Gets 'n' Sets
	public Data getDataAniversario() {
		return dataAniversario;
	}
	public void setDataAniversario(Data dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
	public double getTaxaRendimento() {
		return taxaRendimento;
	}
	public void setTaxaRendimento(double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}
		
	

}
