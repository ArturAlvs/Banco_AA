package cliente;

import java.io.Serializable;

public class Endereco implements Serializable{

	private String cep;
	private String rua;
	private int numeroEnd;
	
	public Endereco(String cep, int numeroEnd, String rua){
		
		this.cep = cep;
		this.numeroEnd = numeroEnd;
		this.setRua(rua);
	}
	
	public int getNumeroEnd() {
		return numeroEnd;
	}
	
	public void setNumeroEnd(int numeroEnd) {
		this.numeroEnd = numeroEnd;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
	
	
	
}
