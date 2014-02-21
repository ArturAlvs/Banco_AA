package banco.intgraph;

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

import agencia.Agencia;
import Inicio.Teste;

public class ShowAgenciaTable2 {

	// Dados (esquerda)
	final JLabel labelCodigo = new JLabel("Codigo: ");
	final JLabel labelCodigoValue = new JLabel();
	final JLabel labelText = new JLabel("Descrição:");
	final JLabel labelTextValue = new JLabel("_____________________");
	final JLabel labelNumContas = new JLabel("Numero de Contas: ");
	final JLabel labelNumContasValue = new JLabel("_");
	private final JPanel painelDadosAgencia = new JPanel();

	// Tabela (direito)
	private JScrollPane scrollPane;
	private JTable tabelaAgencias;
	private final JPanel painelTabelaAgencias = new JPanel();

	// Formulario (inferior)
	final JTextField textFieldAgencia = new JTextField(20);
	final JButton botaoEscolherAgencia = new JButton("Escolher Agencia");
	private final JPanel painelFormularioEscolherTabela = new JPanel();

	private final JPanel painelCompleto = new JPanel();

	// Construtor -------------------------------
	public ShowAgenciaTable2() {
		labelCodigoValue.setText( null );

		// Tamanho dos paineis
		painelDadosAgencia.setPreferredSize(new Dimension(Teste
				.getJanelaWidth() / 2, Teste.getJanelaHeight()
				- Teste.getDiferencaTamanho()));
		painelTabelaAgencias.setPreferredSize(new Dimension(Teste
				.getJanelaWidth() / 2, Teste.getJanelaHeight()
				- Teste.getDiferencaTamanho()));

		// Adiciona componentes no painel de DADOS
		painelDadosAgencia.setLayout(new GridLayout(3, 2));

		painelDadosAgencia.add(labelCodigo);
		painelDadosAgencia.add(labelCodigoValue);
		painelDadosAgencia.add(labelText);
		painelDadosAgencia.add(labelTextValue);
		painelDadosAgencia.add(labelNumContas);
		painelDadosAgencia.add(labelNumContasValue);

		// Adicionando elementos no painel da Tabela

		criarTabela();

		criaEventoTextField();
		criaEventoBotao();

		// painelTabelaAgencias.add(tabelaAgencias);
		painelTabelaAgencias.add(scrollPane);

		// Adicionando elementos no Formulario de escolha da Agencia
		painelFormularioEscolherTabela.add(textFieldAgencia);
		painelFormularioEscolherTabela.add(botaoEscolherAgencia);

		// Layout do PAINEL
		painelCompleto.setLayout(new BorderLayout());
		painelCompleto.add(painelDadosAgencia, BorderLayout.WEST);
		painelCompleto.add(painelTabelaAgencias, BorderLayout.EAST);
		painelCompleto.add(painelFormularioEscolherTabela, BorderLayout.SOUTH);

	}

	// Gets 'n' Sets
		public JPanel getPainelCompleto() {
			return painelCompleto;
		}

		// Metodos-------------------------------------------------
		// ----------------------------------
		// Cria a table das agencias
		@SuppressWarnings("serial")
		private void criarTabela() {
			// System.out.println(Teste.getBancoGNB());

			final int numDeDados = NUM_DE_DADOS;

			
			tabelaAgencias = new JTable(
					Teste.getBancoGNB().getAgencias().size() + 1, numDeDados) {
				public boolean isCellEditable(int row, int column) { // Bloquear edição da ROW
					return false;
				}

			};

			tabelaAgencias.setRowHeight(30);

			

			scrollPane = new JScrollPane(tabelaAgencias);
			tabelaAgencias.setPreferredScrollableViewportSize(new Dimension((Teste
					.getJanelaWidth() / 2) - 30, Teste.getJanelaHeight()
					- Teste.getDiferencaTamanho()));

			// Selecionar ROW----------

			tabelaAgencias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			ListSelectionModel rowSM = tabelaAgencias.getSelectionModel();
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

						if (tabelaAgencias.getValueAt(rowSelecionada, 0) != null) {
							for (int i = 0; i < numDeDados; i++) {

								switch (i) {
								case 0:
									labelCodigoValue.setText(tabelaAgencias
											.getValueAt(rowSelecionada, i)
											.toString());
									break;
								case 1:
									labelTextValue.setText(tabelaAgencias
											.getValueAt(rowSelecionada, i)
											.toString());
									break;
								case 2:
									labelNumContasValue.setText(tabelaAgencias
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

				coluna = tabelaAgencias.getColumnModel().getColumn(i);
				if (i == 1) {
					coluna.setPreferredWidth(300); // Descrição da Agencia

				} else {
					coluna.setPreferredWidth(30);
				}
			}

			int i = 0;
			for (Agencia agn : Teste.getBancoGNB().getAgencias().values()) {

				for (int j = 0; j < numDeDados; j++) {

					switch (j) {
					case 0:
						tabelaAgencias.setValueAt(agn.getCodigo(), i, j);
						break;
					case 1:
						tabelaAgencias.setValueAt(agn.getDescricao(), i, j);
						break;
					case 2:
						tabelaAgencias.setValueAt(agn.getContas().size(), i, j);
						break;

					}

				}

				i++;
			}
		}

		// Cria Evento do click na caixa de texto
		private void criaEventoTextField() {

			textFieldAgencia.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if (textFieldAgencia.getText() != null) {

						Integer agenciaSelecionada = new Integer(textFieldAgencia
								.getText());
						agenciaSelecionada--;

						// Se o ususario digitar 0(zero)
						if (agenciaSelecionada < 0) {
							agenciaSelecionada = 0;
						}

						if (tabelaAgencias.getValueAt(agenciaSelecionada, 0) != null) {
							for (int i = 0; i < NUM_DE_DADOS; i++) {

								switch (i) {
								case 0:
									labelCodigoValue.setText(tabelaAgencias
											.getValueAt(agenciaSelecionada, i)
											.toString());
									break;
								case 1:
									labelTextValue.setText(tabelaAgencias
											.getValueAt(agenciaSelecionada, i)
											.toString());
									break;
								case 2:
									labelNumContasValue.setText(tabelaAgencias
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

		
//		Cria Evento do botao Selecionar Agencia
		
		private void criaEventoBotao(){
			
			botaoEscolherAgencia.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if (labelCodigoValue.getText() != null) {
						
						Integer numeroAgencia = new Integer(labelCodigoValue.getText());
						Teste.setAgenciaIntMap(numeroAgencia);
						
//						System.out.println(Teste.getBancoGNB().getAgencias().size());
//						System.out.println(numeroAgencia);
//						
//						System.out.println(Teste.getBancoGNB().getAgencias().get(numeroAgencia).getDescricao());
						Teste.getBancoGNB().getAgencias().get(numeroAgencia).instaciarPaineis();
						
////						Limpa janela e adiciona outra tela  					
						Teste.janela.getContentPane().removeAll();
						Teste.janela.getContentPane().add(Teste.getBancoGNB().getAgencias().get(numeroAgencia).getPainelTabbed().getPainelCompleto());
						Teste.janela.getContentPane().revalidate();
						
						
						
					}
					
					
				}
			});
			
		}
		
		
		
		
		
		
//		Constantes------------
		private final int NUM_DE_DADOS = 3;
}
