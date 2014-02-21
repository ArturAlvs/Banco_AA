package cliente;

import java.util.ArrayList;

public class TesteCliente {

	public static void main(String[] args) {
		
		PessoaFisica pessoa1 = new PessoaFisica("The Couro Eat");
		pessoa1.setCpf("785.652.458-03");
		Endereco end1 = new Endereco("20654-365", 225);
		
		pessoa1.addEndereco(end1);
		
		System.out.println("Cliente " + pessoa1.getIdentificacao() + " cujo cpf � " + pessoa1.getCpf());
		
		ArrayList<Endereco> endereco2 = pessoa1.getEndereco();
		
		for (int i = 0; i < endereco2.size(); i++){
			System.out.println(end1.getCep() + " " + end1.getNumeroEnd());
		}
	}
		

}
