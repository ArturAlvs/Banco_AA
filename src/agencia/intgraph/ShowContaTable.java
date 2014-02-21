package agencia.intgraph;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import conta.Conta;
import agencia.Agencia;
import Inicio.Teste;

public class ShowContaTable {

	// Dados (esquerda)
	final JLabel labelCodigo = new JLabel("Numero: ");
	final JFormattedTextField labelCodigoValue = new JFormattedTextField("_"); 
	final JLabel labelTipo = new JLabel("Tipo:");
	final JLabel labelTipoValue = new JLabel("_");
	final JLabel labelNomeCliente = new JLabel("Cliente: ");
	final JLabel labelNomeClienteValue = new JLabel("_");
	private JPanel painelCodigoDados = new JPanel();
	private JPanel painelTipoDados = new JPanel();
	private JPanel painelNomeDados = new JPanel();
	private final JPanel painelDadosConta = new JPanel();

	// Tabela (direito)
	private JScrollPane scrollPane;
	private JTable tabelaContas;
	private final JPanel painelTabelaContas = new JPanel();

	// Formulario (inferior)
	final JTextField textFieldConta = new JTextField(20);
	final JButton botaoEscolherConta = new JButton("Escolher Conta");
	private final JPanel painelFormularioEscolherConta = new JPanel();

	private final JPanel painelCompleto = new JPanel();

	// Construtor -------------------------------
	public ShowContaTable() {

		// Tamanho dos paineis
		painelDadosConta.setPreferredSize(new Dimension(Teste
				.getJanelaWidth() / 2, Teste.getJanelaHeight()
				- Teste.getDiferencaTamanho()));
		painelTabelaContas.setPreferredSize(new Dimension(Teste
				.getJanelaWidth() / 2, Teste.getJanelaHeight()
				- Teste.getDiferencaTamanho()));

		// Adiciona componentes no painel de DADOS
		painelDadosConta.setLayout(new GridLayout(25,1));
		
		
		painelCodigoDados.add(labelCodigo);
		painelCodigoDados.add(labelCodigoValue);
		
		painelTipoDados.add(labelTipo);
		painelTipoDados.add(labelTipoValue);
		
		painelNomeDados.add(labelNomeCliente);
		painelNomeDados.add(labelNomeClienteValue);
		
		painelDadosConta.add(painelCodigoDados);
		painelDadosConta.add(painelTipoDados);
		painelDadosConta.add(painelNomeDados);

		// Adicionando elementos no painel da Tabela

		criarTabela();

		criaEventoTextField();
		criaEventoBotao();

		// painelTabelaContas.add(tabelaContas);
		painelTabelaContas.add(scrollPane);

		// Adicionando elementos no Formulario de escolha da Agencia
		painelFormularioEscolherConta.add(textFieldConta);
		painelFormularioEscolherConta.add(botaoEscolherConta);

		// Layout do PAINEL
		painelCompleto.setLayout(new BorderLayout());
		painelCompleto.add(painelDadosConta, BorderLayout.WEST);
		painelCompleto.add(painelTabelaContas, BorderLayout.EAST);
		painelCompleto.add(painelFormularioEscolherConta, BorderLayout.SOUTH);

	}

	// Gets 'n' Sets
	public JPanel getPainelCompleto() {
		return painelCompleto;
	}

	// Metodos-------------------------------------------------
	// ----------------------------------
	// Cria a table das contas
	@SuppressWarnings("serial")
	private void criarTabela() {
		// System.out.println(Teste.getBancoGNB());

		final int numDeDados = NUM_DE_DADOS;

		
		tabelaContas = new JTable(
				Teste.getBancoGNB().getAgencias().get(AGENCIA_ATUAL).getContas().size() + 1, numDeDados) {
			public boolean isCellEditable(int row, int column) { // Bloquear edição da ROW
				return false;
			}

		};

		tabelaContas.setRowHeight(30);

		

		scrollPane = new JScrollPane(tabelaContas);
		tabelaContas.setPreferredScrollableViewportSize(new Dimension((Teste
				.getJanelaWidth() / 2) - 30, Teste.getJanelaHeight()
				- Teste.getDiferencaTamanho()));

		// Selecionar ROW----------

		tabelaContas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		ListSelectionModel rowSM = tabelaContas.getSelectionModel();
		rowSM.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// Ignore extra messages.
				if (e.getValueIsAdjusting())
					return;

				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if (lsm.isSelectionEmpty()) {
					// no rows are selected
				} else {
					int rowSelecionada = lsm.getMinSelectionIndex(); // selectedRow
																		// is
																		// selected

					if (tabelaContas.getValueAt(rowSelecionada, 0) != null) {
						for (int i = 0; i < numDeDados; i++) {

							switch (i) {
							case 0:
								labelCodigoValue.setText(tabelaContas
										.getValueAt(rowSelecionada, i)
										.toString());
								break;
							case 1:
								labelTipoValue.setText(tabelaContas
										.getValueAt(rowSelecionada, i)
										.toString());
								break;
							case 2:
								labelNomeClienteValue.setText(tabelaContas
										.getValueAt(rowSelecionada, i)
										.toString());
								break;
							}
						}
					}

				}
			}
		});

		// Faz coluna da descricao ficar maior
		TableColumn coluna = null;
		for (int i = 0; i < numDeDados; i++) {

			coluna = tabelaContas.getColumnModel().getColumn(i);
			if (i == 1) {
				coluna.setPreferredWidth(300); // Descrição da Agencia

			} else {
				coluna.setPreferredWidth(30);
			}
		}

		int i = 0;
		for (Conta conta : Teste.getBancoGNB().getAgencias().get(AGENCIA_ATUAL).getContas().values()) {

			for (int j = 0; j < numDeDados; j++) {

				switch (j) {
				case 0:
					tabelaContas.setValueAt(conta.getNumero(), i, j);
					break;
				case 1:
					tabelaContas.setValueAt(conta.getTipo() , i, j);
					break;
				case 2:
					tabelaContas.setValueAt(conta.getCliente().getIdentificacao(), i, j);
					break;

				}

			}

			i++;
		}
	}

	// Cria Evento do click na caixa de texto
	private void criaEventoTextField() {

		textFieldConta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (textFieldConta.getText() != null) {

					Integer agenciaSelecionada = new Integer(textFieldConta
							.getText());
					agenciaSelecionada--;

					// Se o ususario digitar 0(zero)
					if (agenciaSelecionada < 0) {
						agenciaSelecionada = 0;
					}

					if (tabelaContas.getValueAt(agenciaSelecionada, 0) != null) {
						for (int i = 0; i < NUM_DE_DADOS; i++) {

							switch (i) {
							case 0:
								labelCodigoValue.setText(tabelaContas
										.getValueAt(agenciaSelecionada, i)
										.toString());
								break;
							case 1:
								labelTipoValue.setText(tabelaContas
										.getValueAt(agenciaSelecionada, i)
										.toString());
								break;
							case 2:
								labelNomeClienteValue.setText(tabelaContas
										.getValueAt(agenciaSelecionada, i)
										.toString());
								break;
							}
						}
					}

				}

			}
		});
	}

	
//	Cria Evento do botao Selecionar Conta
	
	private void criaEventoBotao(){
		
	}
	
	
	
	
	
	
//	Constantes------------
	private final int NUM_DE_DADOS = 3;
	private final int AGENCIA_ATUAL = Teste.getAgenciaIntMap();
}
