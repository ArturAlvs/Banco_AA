package conta.intgraph;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

import agencia.Agencia;

import javax.swing.JTable;
import javax.swing.text.MaskFormatter;

import cliente.PessoaFisica;
import cliente.PessoaJuridica;
import conta.Conta;
import conta.ContaCorrente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// ATENCAO O CU ESTA NO RODAPE (CRIEI UM METODO MAIN AKI DENTOR SO PRA TESTAR)

public class PainelTransferencia extends JPanel {

	private final JFormattedTextField txtQuantia = new JFormattedTextField();
	private final JTable tabelaDestino;

	private final JButton btnOk = new JButton("Ok");
	private final JScrollPane scrollDestino = new JScrollPane();

	// a agencia sera usada para preencher a lista de contas
	public PainelTransferencia(final Agencia agencia, final Conta conta) {
		setLayout(null);

		JLabel lblTransferencia = new JLabel("Transferencia");
		lblTransferencia.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTransferencia.setBounds(138, 12, 113, 15);
		add(lblTransferencia);

		JLabel label_2 = new JLabel("Quantia:");
		label_2.setBounds(56, 331, 63, 17);
		add(label_2);

		txtQuantia
				.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);

		txtQuantia.setColumns(10);
		txtQuantia.setBounds(130, 330, 114, 19);

		txtQuantia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		add(txtQuantia);

		// adicionar evento de transferencia
		// btnOk.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		//
		//
		// // int linhaDestino = tabelaDestino.getSelectedRow();
		// // if(linhaDestino > -1){
		// // Conta cOrigem = agencia.buscaConta((int)
		// tabelaOrigem.getValueAt(linhaOrigem, 0));
		// // Conta cDestino = agencia.buscaConta((int)
		// tabelaDestino.getValueAt(linhaOrigem, 0));
		// //
		// // //System.out.println(tabelaOrigem.getValueAt(linhaOrigem, 0));
		// // //if(cOrigem instanceof ContaCorrente){
		// // try{
		// // //Double valor = Double.parseDouble(txtQuantia.getText());
		// // //conta.sacar(valor);
		// //
		// // // lblValorPosSaldo.setText(conta.getSaldo()+"");
		// // // lblValorSaldo.setText(conta.getSaldo()+"");
		// //
		// // Double valor = Double.parseDouble(txtQuantia.getText());
		// //
		// // if(cOrigem.sacar(valor)){
		// // //conseguiu sacar entao transfere
		// // System.out.println(cOrigem.obterSaldo());
		// // cDestino.setSaldo(cDestino.obterSaldo()+valor);
		// // lblSaldo.setText(""+cOrigem.obterSaldo());
		// // lblPosSaldo.setText(""+cOrigem.obterSaldo());
		// // }
		// //
		// //
		// // txtQuantia.setText("");
		// //
		// //
		// // }catch(Exception exc){
		// // System.out.println("Valor Invalido");
		// // }
		// // //}
		//
		// }
		// }
		// });

		btnOk.setBounds(279, 325, 117, 25);
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Double valor = Double.parseDouble(txtQuantia.getText());
				if (conta.obterSaldo() > valor
						&& tabelaDestino.getSelectedRow() > -1) {
					
					conta.sacar(valor);
					
					Integer cod = Integer.parseInt(tabelaDestino.getValueAt(
							tabelaDestino.getSelectedRow(), 0).toString());
					
					agencia.buscaConta(cod).depositar(valor);
					
				}

				PainelDepositar.atualizarTela();
			}
		});
		add(btnOk);

		// txtQuantia.addKeyListener();

		tabelaDestino = new JTable(agencia.getContas().size(), 2);
		scrollDestino.setBounds(279, 116, 208, 139);
		this.scrollDestino.setViewportView(tabelaDestino);
		add(scrollDestino);

		tabelaDestino.getColumnModel().getColumn(0).setHeaderValue("Numero");
		tabelaDestino.getColumnModel().getColumn(1).setHeaderValue("Cliente");

		JLabel lblOrigem = new JLabel("Origem");
		lblOrigem.setBounds(84, 89, 70, 15);
		add(lblOrigem);

		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setBounds(350, 89, 70, 15);
		add(lblDestino);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(38, 134, 70, 15);
		add(lblNumero);

		JLabel lblNumeroconta = new JLabel(conta.getNumero() + "");
		lblNumeroconta.setBounds(135, 134, 70, 15);
		add(lblNumeroconta);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(38, 190, 70, 15);
		add(lblCliente);

		JLabel lblNomecliente = new JLabel("nome");
		lblNomecliente.setBounds(138, 190, 70, 15);
		add(lblNomecliente);

		// preencher a tabela
		this.preenche(agencia);
	}

	public void preenche(Agencia agencia) {
		// preencher tabelas
		int linha = 0;
		for (Conta c : agencia.getContas().values()) {

			tabelaDestino.setValueAt(c.getNumero(), linha, 0);

			tabelaDestino.setValueAt(c.getCliente().getIdentificacao(), linha,
					1);

			linha++;
		}
	}

}
