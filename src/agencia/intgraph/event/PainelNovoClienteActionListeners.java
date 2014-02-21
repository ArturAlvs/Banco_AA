package agencia.intgraph.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Inicio.Teste;
import agencia.intgraph.AgenciaTabbedPanel;
import banco.intgraph.BancoTabbedPanel;

public abstract class PainelNovoClienteActionListeners {

	// BOTAO OK--------------------------------------------------------
	

	public static ActionListener botaoCancelarGetAction() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap())
						.instaciarPaineis();

				// // Limpa janela e adiciona outra tela
				Teste.janela.getContentPane().removeAll();
				Teste.janela.getContentPane().add(
						Teste.getBancoGNB().getAgencias()
								.get(Teste.getAgenciaIntMap())
								.getPainelTabbed().getPainelCompleto());
				Teste.janela.getContentPane().revalidate();

			}
		});
	}

	public static ActionListener botaoContaCorrenteGetAction(
			final JFormattedTextField aniversario,
			final JTextField taxaServico, final JTextField limiteSaque,
			final JLabel taxaJuros) {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				aniversario.setEnabled(false);
				taxaServico.setEnabled(true);
				limiteSaque.setEnabled(true);
				taxaJuros.setText("Taxa de Juros:");
			}
		});
	}

	public static ActionListener botaoContaPoupancaGetAction(
			final JFormattedTextField aniversario,
			final JTextField taxaServico, final JTextField limiteSaque,
			final JLabel taxaJuros) {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				aniversario.setEnabled(true);
				taxaServico.setEnabled(false);
				limiteSaque.setEnabled(false);
				taxaJuros.setText("Taxa de Rendimento:");
			}
		});
	}

	public static ActionListener botaoContaCartaoGetAction() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

}