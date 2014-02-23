package conta.intgraph;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Inicio.Teste;

public class ContaTabbedPanel {

	private final JTabbedPane tPanel = new JTabbedPane();

//	private final ShowAgenciaTable agenciaTable = new ShowAgenciaTable();
//	private final CriarAgencia agenciaCriar = new CriarAgencia();

	private JPanel painelCompleto = new JPanel();

	// Construtor
	public ContaTabbedPanel() {

		tPanel.setPreferredSize(new Dimension(Teste.getJanelaWidth(), Teste
				.getJanelaHeight() - (Teste.getDiferencaTamanho() / 6 )));

		tPanel.addTab("Conta", null, new PainelConta(),
				"Lista de AGENCIAS");
		tPanel.setMnemonicAt(0, KeyEvent.VK_1);
		
		
		tPanel.addTab("Depositar", null, new PainelDepositar(Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap()).getContas().get(Teste.getContaIntMap()) ),
				"Criar Agencia");
		tPanel.setMnemonicAt(1, KeyEvent.VK_2);
		
		tPanel.addTab("Sacar", null, new PainelSacar(Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap()).getContas().get(Teste.getContaIntMap()) ),
				"Lista de AGENCIAS");
		tPanel.setMnemonicAt(2, KeyEvent.VK_3);
		
		
		tPanel.addTab("Transferir", null, new PainelTransferencia(Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap()), Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap()).getContas().get(Teste.getContaIntMap()) ),
				"Criar Agencia");
		tPanel.setMnemonicAt(3, KeyEvent.VK_4);
		
		tPanel.addTab("Historico", null, new PainelHistorico(),
				"Criar Agencia");
		tPanel.setMnemonicAt(4, KeyEvent.VK_5);
		



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
