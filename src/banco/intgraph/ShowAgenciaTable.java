package banco.intgraph;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TabExpander;
import javax.swing.JTextField;
import javax.swing.JButton;

import Inicio.Teste;
import agencia.Agencia;

public class ShowAgenciaTable extends JPanel {
	
//	Constantes------------
	private final int NUM_DE_DADOS = 3;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField textField = new JTextField();
	
	private JLabel lblNewLabel = new JLabel("Código:");
	private JLabel label = new JLabel("...");
	private JLabel lblDescrio = new JLabel("Descrição:");
	private JTextPane txtpnTextoGrandeAqui = new JTextPane();
	private JLabel lblNumeroDeContas = new JLabel("Nº de Contas:");
	private JLabel label_1 = new JLabel("...");
	private JScrollPane scrollPane = new JScrollPane();
	private JTable table= new JTable(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) { // Bloquear edição da ROW
			return false;
		}

	}; ;
	
	private JButton btnEscolherAgncia = new JButton("Escolher Agência");

	

	/**
	 * Create the panel.
	 */
	public ShowAgenciaTable() {
		setLayout(null);
		
		
		lblNewLabel.setBounds(12, 25, 64, 15);
		add(lblNewLabel);
		
		
		label.setForeground(UIManager.getColor("Label.foreground"));
		label.setBounds(94, 25, 70, 15);
		add(label);
		
		
		lblDescrio.setBounds(12, 68, 89, 15);
		add(lblDescrio);
		
		
		txtpnTextoGrandeAqui.setForeground(UIManager.getColor("Label.foreground"));
		txtpnTextoGrandeAqui.setEditable(false);
		txtpnTextoGrandeAqui.setBackground(UIManager.getColor("Panel.background"));
		txtpnTextoGrandeAqui.setText("...");
		txtpnTextoGrandeAqui.setBounds(94, 68, 149, 75);
		add(txtpnTextoGrandeAqui);
		
		
		lblNumeroDeContas.setBounds(12, 155, 104, 15);
		add(lblNumeroDeContas);
		
		
		label_1.setForeground(UIManager.getColor("Label.foreground"));
		label_1.setBounds(122, 155, 70, 15);
		add(label_1);
		
		
		scrollPane.setBounds(356, 12, 315, 538);
		add(scrollPane);
		
		table = new JTable(
				Teste.getBancoGNB().getAgencias().size() + 1, NUM_DE_DADOS) {
			/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) { // Bloquear edição da ROW
				return false;
			}

		};

		table.setRowHeight(30);
		
		
		scrollPane.setViewportView(table);
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//					{null, null, null},{null, null, null},{null, null, null}
//			},
//			new String[] {
//				"Id", "Descri\u00E7\u00E3o", "Contas"
//			}
//		) {
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//			boolean[] columnEditables = new boolean[] {
//				false, false, false
//			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
//		});
		table.getColumnModel().getColumn(0).setPreferredWidth(56);
		table.getColumnModel().getColumn(1).setPreferredWidth(241);
		table.getColumnModel().getColumn(2).setResizable(false);
		
		
		textField.setBounds(356, 559, 114, 25);
		add(textField);
		textField.setColumns(10);
		
		
		btnEscolherAgncia.setBounds(491, 559, 180, 25);
		add(btnEscolherAgncia);
		
		
		elementosNaTabela();
		criaEventoTextField();
		criaEventoBotao();

	}
	
	
	
//	METODOS-------------------
	
	private void elementosNaTabela(){
//		Bota os elementos
		int i = 0;
		for (Agencia agn : Teste.getBancoGNB().getAgencias().values()) {

			for (int j = 0; j < NUM_DE_DADOS; j++) {

				switch (j) {
				case 0:
					table.setValueAt(agn.getCodigo(), i, j);
					break;
				case 1:
					table.setValueAt(agn.getDescricao(), i, j);
					break;
				case 2:
					table.setValueAt(agn.getContas().size(), i, j);
					break;

				}

			}

			i++;
		}
		
		
		// Selecionar ROW----------

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

					ListSelectionModel rowSM = table.getSelectionModel();
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

								if (table.getValueAt(rowSelecionada, 0) != null) {
									for (int i = 0; i < NUM_DE_DADOS; i++) {

										switch (i) {
										case 0:
											label.setText(table
													.getValueAt(rowSelecionada, i)
													.toString());
											break;
										case 1:
											txtpnTextoGrandeAqui.setText(table
													.getValueAt(rowSelecionada, i)
													.toString());
											break;
										case 2:
											label_1.setText(table
													.getValueAt(rowSelecionada, i)
													.toString());
											break;
										}
									}
								}

							}
						}
					});
		
	}
	
	
	// Cria Evento do click na caixa de texto
			private void criaEventoTextField() {

				textField.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						if (textField.getText() != null) {

							Integer agenciaSelecionada = new Integer(textField
									.getText());
							agenciaSelecionada--;

							// Se o ususario digitar 0(zero)
							if (agenciaSelecionada < 0) {
								agenciaSelecionada = 0;
							}

							if (table.getValueAt(agenciaSelecionada, 0) != null) {
								for (int i = 0; i < NUM_DE_DADOS; i++) {

									switch (i) {
									case 0:
										label.setText(table
												.getValueAt(agenciaSelecionada, i)
												.toString());
										break;
									case 1:
										txtpnTextoGrandeAqui.setText(table
												.getValueAt(agenciaSelecionada, i)
												.toString());
										break;
									case 2:
										label_1.setText(table
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

			
//			Cria Evento do botao Selecionar Agencia
			
			private void criaEventoBotao(){
				
				btnEscolherAgncia.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						if (label.getText() != null) {
							
							Integer numeroAgencia = new Integer(label.getText());
							Teste.setAgenciaIntMap(numeroAgencia);
							
//							System.out.println(Teste.getBancoGNB().getAgencias().size());
//							System.out.println(numeroAgencia);
//							
//							System.out.println(Teste.getBancoGNB().getAgencias().get(numeroAgencia).getDescricao());
							Teste.getBancoGNB().getAgencias().get(numeroAgencia).instaciarPaineis();
							
////							Limpa janela e adiciona outra tela  					
							Teste.janela.getContentPane().removeAll();
							Teste.janela.getContentPane().add(Teste.getBancoGNB().getAgencias().get(numeroAgencia).getPainelTabbed().getPainelCompleto());
							Teste.janela.getContentPane().revalidate();
							
							
							
						}
						
						
					}
				});
				
			}
	
	
	
	

	
}
