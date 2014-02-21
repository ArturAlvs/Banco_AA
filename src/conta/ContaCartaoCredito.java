package conta;

import cliente.Cliente;
import enums.TipoContas;

public class ContaCartaoCredito extends Conta{
	
//	Atributos
	private static TipoContas tipo = TipoContas.CONTA_CARTAO;
	
	public ContaCartaoCredito(Cliente cliente) {
		// TODO Auto-generated constructor stub
		super(ContaCartaoCredito.tipo, cliente);
	}
	
	
//	Gets 'n' Sets
	public void cobrarJuros(){
		super.setSaldo(super.getSaldo() * 1.05);
	}
	
	
//	Metodos
	public void pagar(){
		super.setSaldo(0);
	}


}
