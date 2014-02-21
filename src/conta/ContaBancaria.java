package conta;

import cliente.Cliente;
import enums.TipoContas;

public abstract class ContaBancaria extends Conta {
	
	public ContaBancaria(TipoContas tipo, Cliente cliente) {
		// TODO Auto-generated constructor stub
		super(tipo, cliente);
	}
	
//	Metodo creditar
	public void creditar(){
		
	}
	
//	Metodo debitar
	public void debitar(){
		
	}
	
//	Metodo abstract para Aplicar Rendimentos
	public abstract void aplicarRendimentos();

}
