package agencia.intgraph;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.DimensionUIResource;

import agencia.intgraph.event.PainelClientActionListeners;
import cliente.PessoaFisica;

public class PainelCliente extends JPanel{
	
//	private final PainelNovoCliente painelNovoCliente = new PainelNovoCliente();
	
	private JLabel titulo = new JLabel("Tabela de Clientes");
	private final CrudCliente grid = new CrudCliente(30,3);
	private final JScrollPane scroll = new JScrollPane();	
	
	//botoes do painel south
	private final JButton botaoOk= new JButton("Ok"),botaoCancelar =new JButton("Cancelar" );
	
	//botoes do painel west
	private final JButton botaoNovo= new JButton("Novo"),
						  botaoAlterar =new JButton("Alterar"),
						  botaoExcluir =new JButton("Excluir");
	
	private final int larguraBotao = 100, alturaBotao=60;
		
	
	public PainelCliente(){
		
		this.setLayout(null);
		
		//montar grid
		this.grid.getColumnModel().getColumn(0).setMaxWidth(40);
		this.grid.getColumnModel().getColumn(0).setHeaderValue("Tipo");
		this.grid.getColumnModel().getColumn(1).setHeaderValue("Nome");  
		this.grid.getColumnModel().getColumn(2).setHeaderValue("CPF/CNPJ");
		this.grid.getTableHeader().resizeAndRepaint();  
		this.scroll.getViewport().add(this.grid);
		this.scroll.setBounds(200, 50, 400, 400);
		this.add(this.scroll);
		this.grid.setEnabled(false);
		
		//colocar titulo na tela
		this.titulo.setBounds(280, 5, 400, 50);
		this.titulo.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 20)); 
		this.add(this.titulo);

		//adicionar eventos
		this.botaoOk.addActionListener(PainelClientActionListeners.botaoOkGetAction());		
		this.botaoCancelar.addActionListener(PainelClientActionListeners.botaoCancelarGetAction(this));
		
		this.botaoNovo.addActionListener(PainelClientActionListeners.botaoNovoGetAction());		
		this.botaoAlterar.addActionListener(PainelClientActionListeners.botaoAlterarGetAction(this));		
		this.botaoExcluir.addActionListener(PainelClientActionListeners.botaoExcluirGetAction());

		//setar posicoes
		this.botaoNovo.setBounds(50, 130, this.larguraBotao, this.alturaBotao);
		this.botaoAlterar.setBounds(50, 130+this.alturaBotao+20, this.larguraBotao, this.alturaBotao);
		this.botaoExcluir.setBounds(50, 130+2*this.alturaBotao+2*20, this.larguraBotao, this.alturaBotao);
		
		this.botaoOk.setBounds(this.scroll.getX()+70, this.scroll.getY()+this.scroll.getHeight()+20,  this.larguraBotao,this.alturaBotao);
		this.botaoCancelar.setBounds(this.botaoOk.getX()+this.botaoOk.getWidth()+20, this.botaoOk.getY(), this.larguraBotao,this.alturaBotao);
		
		//adicionar botoes
		this.add(botaoNovo);
		this.add(botaoAlterar);
		this.add(botaoExcluir);
		this.add(botaoOk);
		this.add(botaoCancelar);
		
	}
	
	public CrudCliente getCrudCliente(){
		return this.grid;
	}	
}