package agencia;

import java.util.HashMap;

import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import cliente.*;

public class Agencia {
	
	// Paineis--------------------------------------
//	Painel de Agencias
	private agencia.intgraph.AgenciaTabbedPanel painelTabbed;

	
	
	//sempre que uma agencia for criada ela recebera um codigo referente a esta variavel
	private static int AgenciasCriadas = 0;
	
	//sempre q uma conta for criada na agencia ela recebera um codigo referente a esta variavel
	private int geradorCodContas=0;
	
	//codigo da agencia
	private int codigo;
	
	private String descricao;
	
	// contas pertencentes a agencia
	private HashMap<Integer, Conta> contas = new HashMap<Integer, Conta>();

//	Construtor
//	public Agencia() {
//		AgenciasCriadas++;
//		this.setCodigo(AgenciasCriadas);
//	}
	
	public Agencia(String desc){
		
		AgenciasCriadas++;
		this.setCodigo(AgenciasCriadas);
		
		this.setDescricao(desc);
		
		this.contas.put(0, new ContaCorrente(new PessoaFisica("Artur")));
		
	}
	
//	Gets AND Sets

	public static int getAgenciasCriadas() {
		return AgenciasCriadas;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public HashMap<Integer, Conta> getContas() {
		return contas;
	}
	
//	public agencia.intgraph.ShowAgenciaTable getShowAgencias() {
//		return showAgencias;
//	}
//
//	public void setShowAgencias(agencia.intgraph.ShowAgenciaTable showAgencias) {
//		this.showAgencias = showAgencias;
//	}
	
	
	
	
	
	
//	Metodos
	public ContaCorrente criarContaCorrente(Cliente cliente){
		
		//criar conta do cliente
		ContaCorrente c = new ContaCorrente(cliente);
//		c.setCliente(cliente);
		//setar codigo da conta criada com o numero da agencia e o gerador
		//ex.:  agencia 10 gerador = 1
		//      conta.codigo = 100001
		c.setNumero(this.getCodigo()*1000+this.getGeradorContas());
		
		//adicionar conta na agencia
		this.contas.put(c.getNumero(), c);
		
		this.geradorCodContas++;
		
		return c;
	}
	
	public agencia.intgraph.AgenciaTabbedPanel getPainelTabbed() {
		return painelTabbed;
	}

	public void setPainelTabbed(agencia.intgraph.AgenciaTabbedPanel painelTabbed) {
		this.painelTabbed = painelTabbed;
	}

	public ContaPoupanca criarContaPoupanca(Cliente cliente){
		
		//criar conta do cliente
		ContaPoupanca c = new ContaPoupanca(cliente);
//		c.setCliente(cliente);
		
		//setar codigo da conta criada com o numero da agencia e o gerador
		//ex.:  agencia 10 gerador = 1
		//      conta.codigo = 100001
		c.setNumero(this.getCodigo()*1000+this.getGeradorContas());
		
		//adicionar conta na agencia
		this.contas.put(c.getNumero(), c);		
		this.geradorCodContas++;
		
		return c;
	}
	
	public Conta buscaConta(int numero){
		
		return	this.getContas().get(numero);
		
	}
	

	public int getGeradorContas(){
		return this.geradorCodContas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString(){
		return this.getCodigo()+","+this.getDescricao();
	}
	
	
	public void instaciarPaineis(){
//		Intanciando Paineis
//		Painel de Contas
		painelTabbed = new agencia.intgraph.AgenciaTabbedPanel();
	}
	
//	Testes
	public void aAA(){
		System.out.println("Agencia");
	}
	
}
