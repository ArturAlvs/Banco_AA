package cliente;

public class PessoaFisica extends Cliente {

//	Atributos
	private String cpf;

//	Construtor--------------
	public PessoaFisica(String nome) {
		// TODO Auto-generated constructor stub
		this.setIdentificacao(nome);
	}
	
//	Gets 'n' Sets
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String getInfo(){
		return cpf;
	}
	
}
