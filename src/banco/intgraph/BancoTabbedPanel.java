package banco.intgraph;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Inicio.Teste;

public class BancoTabbedPanel {

	private final JTabbedPane tPanel = new JTabbedPane();

	private final ShowAgenciaTable agenciaTable = new ShowAgenciaTable();
	private final CriarAgencia agenciaCriar = new CriarAgencia();

	private JPanel painelCompleto = new JPanel();

	// Construtor
	public BancoTabbedPanel() {

		tPanel.setPreferredSize(new Dimension(Teste.getJanelaWidth(), Teste
				.getJanelaHeight() - (Teste.getDiferencaTamanho() / 6 )));

		tPanel.addTab("Agencias", null, agenciaTable,
				"Lista de AGENCIAS");
		tPanel.setMnemonicAt(0, KeyEvent.VK_1);
		
		
		tPanel.addTab("Criar", null, agenciaCriar.getPainelCompleto(),
				"Criar Agencia");
		tPanel.setMnemonicAt(1, KeyEvent.VK_2);
		



		painelCompleto.add(tPanel);
		
//		Instanciando 

	}

	public JPanel getPainelCompleto() {
		return painelCompleto;
	}

	public void setPainelCompleto(JPanel painelCompleto) {
		this.painelCompleto = painelCompleto;
	}
	

}
