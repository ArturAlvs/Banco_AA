package banco;

import java.util.HashMap;

import agencia.Agencia;

public class Banco {

	// Paineis--------------------------------------
//	Painel Inicial
	private banco.intgraph.PainelInicial painelInicial ;
//	Painel de Agencias
	private banco.intgraph.BancoTabbedPanel painelTabbed;

//	Atributos
	private String nome;
	private HashMap<Integer, Agencia> agencias = new HashMap<Integer, Agencia>();

	public Banco(String nome) {
			
		setNome(nome);

		Agencia agencia = new Agencia("Primeira Agencia");
		getAgencias().put(agencia.getCodigo(), agencia);
		agencia = null;
		

	}

	// Gets 'n' Sets
	public HashMap<Integer, Agencia> getAgencias() {
		return agencias;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void addAgencia(String desc) {
		Agencia agencia = new Agencia(desc);
		getAgencias().put(agencia.getCodigo(), agencia);
	}

	public void escreverCoisa() {
		System.out.println("Coisa");
	}

	public banco.intgraph.PainelInicial getPainelInicial() {
		return painelInicial;
	}

	public void setPainelInicial(banco.intgraph.PainelInicial painelInicial) {
		this.painelInicial = painelInicial;
	}


	public banco.intgraph.BancoTabbedPanel getPainelTabbed() {
		return painelTabbed;
	}

	public void setPainelTabbed(banco.intgraph.BancoTabbedPanel painelTabbed) {
		this.painelTabbed = painelTabbed;
	}

	
//	Metodos-----------------------
	
	public void criarAgencia(String desc){
		Agencia agencia = new Agencia(desc);
		getAgencias().put(agencia.getCodigo(), agencia);
		agencia = null;
	}
	
	public void instaciarPaineis(){
//		Intanciando Paineis
//		Painel Inicial
		painelInicial = new banco.intgraph.PainelInicial();
//		Painel de Agencias
		painelTabbed = new banco.intgraph.BancoTabbedPanel();
	}

	
	// Testes----------------------------
	public void aAA() {
		System.out.println("Banco");
	}

}
