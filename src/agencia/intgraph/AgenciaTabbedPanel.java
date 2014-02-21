package agencia.intgraph;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Inicio.Teste;

public class AgenciaTabbedPanel {

	private final JTabbedPane tPanel = new JTabbedPane();


	private final JPanel painelCompleto = new JPanel();

	// Construtor
	public AgenciaTabbedPanel() {

		tPanel.setPreferredSize(new Dimension(Teste.getJanelaWidth(), Teste
				.getJanelaHeight() - (Teste.getDiferencaTamanho() / 6 )));

		tPanel.addTab("Contas", null, new ShowContaTable(),
				"Lista de AGENCIAS");
		tPanel.setMnemonicAt(0, KeyEvent.VK_1);
	
		
		tPanel.addTab("Criar Conta", null, new PainelNovoCliente(),
				"Criar Agencia");
		tPanel.setMnemonicAt(1, KeyEvent.VK_2);
		



		painelCompleto.add(tPanel);
		
//		Instanciando 

	}

	public JPanel getPainelCompleto() {
		return painelCompleto;
	}

}
