package cliente;

public class PessoaJuridica extends Cliente{

//	Atributos
	private String cnpj;

//	Construtor----------------
	public PessoaJuridica(String nome) {
		// TODO Auto-generated constructor stub
		this.setIdentificacao(nome);
	}
	
//	Gets 'n' Sets
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public String getInfo(){
		return cnpj;
	}
	
}
