package conta;

import data.Data;

public class HistoricoConta {

	private Data data;
	private Transacao transacao;
	private double valor;
	
	
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public Transacao getTransacao() {
		return transacao;
	}
	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String toString(){
		
		String str = "";
		str = ""+this.getTransacao()+": "+this.getValor()+" ";
		
		if(this.getData()!= null)
			str+=this.getData().toString();
		
		return str;
		
	}
	
}
