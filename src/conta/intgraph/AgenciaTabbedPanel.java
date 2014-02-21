package conta.intgraph;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import agencia.Agencia;
import conta.Conta;
import Inicio.Teste;

public class AgenciaTabbedPanel {

	private final JTabbedPane tPanel = new JTabbedPane();

//	private final ShowContaTable contaTable = new ShowContaTable();
	
	private Conta contaAtual = Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap()).getContas().get(Teste.getContaIntMap());
	private Agencia agenciaAtual = Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap());

	private final JPanel painelCompleto = new JPanel();

	// Construtor
	public AgenciaTabbedPanel() {

		tPanel.setPreferredSize(new Dimension(Teste.getJanelaWidth(), Teste
				.getJanelaHeight() - (Teste.getDiferencaTamanho() / 6 )));

		tPanel.addTab("Contas", null, new PainelDepositar(contaAtual),
				"Lista de AGENCIAS");
		tPanel.setMnemonicAt(0, KeyEvent.VK_1);
	
		
		tPanel.addTab("Criar Conta", null, new PainelDepositar(contaAtual),
				"Criar Agencia");
		tPanel.setMnemonicAt(1, KeyEvent.VK_2);
		
		tPanel.addTab("Criar Conta", null, new PainelSacar(contaAtual),
				"Criar Agencia");
		tPanel.setMnemonicAt(2, KeyEvent.VK_3);
		
		tPanel.addTab("Criar Conta", null, new PainelTransferencia(agenciaAtual),
				"Criar Agencia");
		tPanel.setMnemonicAt(3, KeyEvent.VK_4);
		



		painelCompleto.add(tPanel);
		
//		Instanciando 

	}

	public JPanel getPainelCompleto() {
		return painelCompleto;
	}

}
