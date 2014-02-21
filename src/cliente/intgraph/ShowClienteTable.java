package cliente.intgraph;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ShowClienteTable {

	// Tabela
	final JTable tabelaClientes = new JTable(2, 2);
	private final JPanel painelTabelaClientes = new JPanel();

	// Formulario em SOUTH
	final JTextField textField = new JTextField(20);
	final JButton botaoEscolherCliente = new JButton("Escolher Cliente");
	private final JPanel painelFormularioEscolherTabela = new JPanel();

	private final JPanel painelCompleto = new JPanel();

	public ShowClienteTable() {

		// Adicionando elementos no painel da Tabela
		tabelaClientes.setRowHeight(20);

		painelTabelaClientes.add(tabelaClientes);

		// Adicionando elementos no Formulario de escolha da Agencia
		painelFormularioEscolherTabela.add(textField);
		painelFormularioEscolherTabela.add(botaoEscolherCliente);

		// Layout do PAINEL
		painelCompleto.setLayout(new BorderLayout());
		painelCompleto.add(painelTabelaClientes, BorderLayout.NORTH);
		painelCompleto.add(painelFormularioEscolherTabela, BorderLayout.SOUTH);

	}

	// Gets 'n' Sets
	public JPanel getPainelCompleto() {
		return painelCompleto;
	}

}
