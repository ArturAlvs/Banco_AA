package cliente;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList <Endereco> endereco = new ArrayList <Endereco> ();
	private String identificacao;
	
	public abstract String getInfo();
	
	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public ArrayList <Endereco> getEndereco() {
		return endereco;
	}

	public void addEndereco(Endereco endereco) {
		this.endereco.add(endereco);
	}
}
