package cliente;

public class Endereco {

	private String cep;
	private int numeroEnd;
	
	public Endereco(String cep, int numeroEnd){
		
		this.cep = cep;
		this.numeroEnd = numeroEnd;
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
	
	
}
