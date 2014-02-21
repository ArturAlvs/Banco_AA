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
	
	public void pagar(){
		super.setSaldo(0);
		
		HistoricoConta h = new HistoricoConta();
		h.setTransacao(Transacao.PAGAR);
		//h.setData(data);
		
		super.getHistorico().add(h);
	}
	
	public void cobrarJuros(){
		super.setSaldo(super.getSaldo() * 1.05);
		

		HistoricoConta h = new HistoricoConta();
		h.setTransacao(Transacao.COBRAR_JUROS);
		//h.setData(data);
		
		super.getHistorico().add(h);
	}


}
