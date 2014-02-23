package banco.intgraph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import agencia.Agencia;
import Inicio.Teste;

public class CriarAgencia {
	
	JLabel lblNumeroDaAgncia = new JLabel("Numero da Agencia:");	
	JLabel label ;
	JLabel lblDescrio = new JLabel("Descricao:");
	JTextArea textArea = new JTextArea();
	JButton btnAdicionarAgncia = new JButton("Adicionar Agência");
	
	private final JPanel painelCompleto = new JPanel();
	
	
//	Construtor --------------
	public CriarAgencia() {
		
		label = new JLabel("0" + ( Teste.getBancoGNB().getAgencias().size() + 2));
		
		painelCompleto.setLayout(null);
		
		
		lblNumeroDaAgncia.setBounds(12, 36, 142, 15);
		painelCompleto.add(lblNumeroDaAgncia);
		
		
		label.setBounds(166, 36, 70, 15);
		painelCompleto.add(label);
		
		
		lblDescrio.setBounds(12, 63, 91, 15);
		painelCompleto.add(lblDescrio);
		
		
		textArea.setBounds(121, 63, 196, 113);
		painelCompleto.add(textArea);
		
		
		btnAdicionarAgncia.setBounds(121, 188, 196, 25);
		painelCompleto.add(btnAdicionarAgncia);
		
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
		
		btnAdicionarAgncia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Teste.getBancoGNB().addAgencia(textArea.getText());
//				System.out.println(Teste.getBancoGNB().getAgencias().size());
//				Teste.getBancoGNB().criarAgencia(textArea.getText());
//				System.out.println(Teste.getBancoGNB().getAgencias().size());
				
				
				Teste.janela.getContentPane().removeAll();
				Teste.getBancoGNB().setPainelTabbed(new BancoTabbedPanel());
				Teste.janela.getContentPane().add(Teste.getBancoGNB().getPainelTabbed().getPainelCompleto());
				Teste.janela.getContentPane().revalidate();
				
			}
		});
		
	}
	
	

}
