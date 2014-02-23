package conta.intgraph;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import Inicio.Teste;
import cliente.PessoaFisica;
import conta.Conta;
import conta.ContaCorrente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PainelDepositar extends JPanel {
	private JTextField textQuantia = new JTextField();

	/**
	 * Create the panel.
	 */
	public PainelDepositar(final Conta conta) {

		setLayout(null);

		JLabel lblsacar = new JLabel("Depositar");
		lblsacar.setFont(new Font("Dialog", Font.BOLD, 15));
		lblsacar.setBounds(163, 12, 101, 15);
		add(lblsacar);

		final JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setBounds(28, 48, 52, 15);
		add(lblSaldo);

		JLabel lblPossaldo = new JLabel("PosSaldo");
		lblPossaldo.setBounds(222, 48, 70, 15);
		add(lblPossaldo);

		final JLabel lblValorSaldo = new JLabel(conta.getSaldo() + "");
		lblValorSaldo.setBounds(92, 48, 70, 15);
		add(lblValorSaldo);

		final JLabel lblValorPosSaldo = new JLabel(conta.getSaldo() + "");
		lblValorPosSaldo.setBounds(304, 48, 70, 15);
		add(lblValorPosSaldo);

		JLabel lblQuantia = new JLabel("Quantia:");
		lblQuantia.setBounds(28, 146, 63, 17);
		add(lblQuantia);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Double valor = Double.parseDouble(textQuantia.getText());
					conta.depositar(valor);

					lblValorSaldo.setText("" + conta.getSaldo());
					lblValorPosSaldo.setText("" + conta.getSaldo());
					textQuantia.setText("");
					
					atualizarTela();

				} catch (Exception exc) {
					System.out.println("Valor informado Invalido");
				}

			}
		});
		btnOk.setBounds(251, 140, 117, 25);
		add(btnOk);

		textQuantia.setColumns(10);
		textQuantia.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				try {
					Double valor = conta.getSaldo()
							+ Double.parseDouble(textQuantia.getText());
					lblValorPosSaldo.setText(valor + "");
				} catch (Exception ex) {

				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					lblValorPosSaldo.setText(conta.getSaldo() + "");
				}
			}
		});

		textQuantia.setBounds(102, 145, 114, 19);
		add(textQuantia);

	}

	// "Atualizar"
	public static void atualizarTela() {
		Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap())
				.getContas().get(Teste.getContaIntMap()).instanciarPainel();

		// // Limpa janela e adiciona outra tela
		Teste.janela.getContentPane().removeAll();

		Teste.janela.getContentPane().add(
				Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap())
						.getContas().get(Teste.getContaIntMap()).getPainelDaConta()
						.getPainelCompleto());

		Teste.janela.getContentPane().revalidate();
	}

}
