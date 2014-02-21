package agencia.intgraph;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import menu.testaMenu;
import Inicio.Teste;

public class CriarConta {
	
	private final JLabel labelDecricao = new JLabel("Descrição: ");
	private final JTextArea textAreaDescricao = new JTextArea("Descrição da AGENCIA!");
	private final JButton botaoAdicionar = new JButton("Adicionar");
	
	private final JPanel painelCompleto = new JPanel();
	
	
//	Construtor --------------
	public CriarConta() {
		// TODO Auto-generated constructor stub
		
		botaoAdicionar.setPreferredSize(new Dimension(50, 50));
		
		
//		Adicionando Componentes
		painelCompleto.setLayout(new BorderLayout());
		painelCompleto.add(labelDecricao, BorderLayout.NORTH);
		painelCompleto.add(textAreaDescricao, BorderLayout.CENTER);
		painelCompleto.add(botaoAdicionar, BorderLayout.SOUTH);
		
		criaEventoBotao();
	
	}
	

//	Gets 'n' Sets----------------
	public JPanel getPainelCompleto() {
		return painelCompleto;
	}
	
	
//	Metodos----------------
//	---------------------------
	
//	Adiciona Evento de criar Agencia ao Botao
	private void criaEventoBotao() {
		
		botaoAdicionar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println(Teste.getBancoGNB().getAgencias().size());
				Teste.getBancoGNB().criarAgencia(textAreaDescricao.getText());
//				System.out.println(Teste.getBancoGNB().getAgencias().size());
				
				Teste.janela.getContentPane().removeAll();
				Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap()).setPainelTabbed(new AgenciaTabbedPanel());
				Teste.janela.getContentPane().add(Teste.getBancoGNB().getPainelTabbed().getPainelCompleto());
				Teste.janela.getContentPane().revalidate();
				
			}
		});
		
	}
	
	

}
