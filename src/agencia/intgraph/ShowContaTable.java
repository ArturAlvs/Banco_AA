package agencia.intgraph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import Inicio.Teste;
import conta.*;

public class ShowContaTable extends JPanel {
	private JTable tabelaContas;

	/**
	 * Create the panel.
	 */

	public ShowContaTable() {
		setLayout(null);

		JLabel lblContas = new JLabel("Contas");
		lblContas.setBounds(371, 12, 70, 15);
		add(lblContas);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(12, 52, 70, 15);
		add(lblNumero);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(12, 92, 70, 15);
		add(lblTipo);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(12, 138, 70, 15);
		add(lblCliente);

		final JLabel lblNumeroConta = new JLabel("");
		lblNumeroConta.setBounds(94, 52, 70, 15);
		add(lblNumeroConta);

		final JLabel lblTipoConta = new JLabel("");
		lblTipoConta.setBounds(94, 92, 70, 15);
		add(lblTipoConta);

		final JLabel lblNomeCliente = new JLabel("");
		lblNomeCliente.setBounds(94, 138, 70, 15);
		add(lblNomeCliente);

		JButton btnEscolher = new JButton("Escolher");
		btnEscolher.setBounds(12, 274, 117, 25);
		add(btnEscolher);

		// Evento do botao
		btnEscolher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Integer numeroConta = new Integer(lblNumeroConta.getText());
				Teste.setContaIntMap(numeroConta);
				
				Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap()).getContas().get(numeroConta).instanciarPainel();

				// // Limpa janela e adiciona outra tela
				Teste.janela.getContentPane().removeAll();
				
				Teste.janela.getContentPane().add(
						Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap()).getContas().get(numeroConta).getPainelDaConta().getPainelCompleto() );
				
				Teste.janela.getContentPane().revalidate();
				

			}
		});

		// CRIAR SCROLLL
		JScrollPane scroll = new JScrollPane();
		scroll.setToolTipText("");

		// CRIAR TABELA
		tabelaContas = new JTable(100, 3);
		scroll.setViewportView(tabelaContas);

		// ADD EVENTO NA TABELA
		tabelaContas.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int linha = tabelaContas.getSelectedRow();
				// se tem linha selecionada
				if (linha > -1 && (tabelaContas.getValueAt(linha, 0) != null)) {
					lblNumeroConta.setText(tabelaContas.getValueAt(linha, 0)
							.toString());
					lblTipoConta.setText(tabelaContas.getValueAt(linha, 1)
							.toString());
					lblNomeCliente.setText(tabelaContas.getValueAt(linha, 2)
							.toString());
				}
			}
		});

		// SETAR TITULOS
		tabelaContas.getColumnModel().getColumn(0).setHeaderValue("Numero");
		tabelaContas.getColumnModel().getColumn(1).setHeaderValue("Tipo");
		tabelaContas.getColumnModel().getColumn(2).setHeaderValue("Cliente");

		tabelaContas.getColumnModel().getColumn(1).setMaxWidth(40);
		tabelaContas.getColumnModel().getColumn(0).setMaxWidth(60);

		// ADD TABELA AO SCROLL
		scroll.setViewportView(tabelaContas);
		scroll.setBounds(260, 39, 269, 260);
		add(scroll);

		preenche(Teste.getBancoGNB().getAgencias()
				.get(Teste.getAgenciaIntMap()).getContas());

	}

	public void preenche(HashMap<Integer, Conta> c) {

		int i = 0;
		for (Conta conta : c.values()) {

			this.tabelaContas.setValueAt(conta.getNumero(), i, 0);

			if (conta instanceof ContaCorrente) {
				this.tabelaContas.setValueAt("Conta Corrente", i, 1);
			} else if (conta instanceof ContaPoupanca) {
				this.tabelaContas.setValueAt("Conta Poupanca", i, 1);
			} else if (conta instanceof ContaCartaoCredito)
				this.tabelaContas.setValueAt("Conta Cartão", i, 1);

			this.tabelaContas.setValueAt(conta.getCliente().getIdentificacao(),
					i, 2);

			i++;

		}

	}

	// public void preenche(ArrayList<Conta> c){
	// for (int i = 0; i < c.size(); i++) {
	// this.tabelaContas.setValueAt(c.get(i), i, 0);
	// this.tabelaContas.setValueAt(c.get(i).getCliente().getIdentificacao(), i,
	// 2);
	// if(c.get(i) instanceof ContaCorrente){
	// this.tabelaContas.setValueAt("Conta Corrente", i, 1);
	// }else if(c.get(i) instanceof ContaPoupanca){
	// this.tabelaContas.setValueAt("Conta Poupanca", i, 1);
	// }else if (c.get(i) instanceof ContaCartaoCredito)
	// this.tabelaContas.setValueAt("Conta Cartão", i, 1);
	// }
	//
	// }

	// public static void main(String[] args) {
	// JFrame janela = new JFrame();
	//
	// janela = new JFrame();
	// janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// janela.setSize(600, 400);
	//
	// ShowContaTable p = new ShowContaTable();
	// janela.getContentPane().add(p);
	//
	// janela.setVisible(true);
	//
	// }
}
