package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import banco.intgraph.BancoTabbedPanel;
import Inicio.Teste;

public abstract class MenuActionListeners {

	public static ActionListener importarAgenciaGetAction() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Importou agencia");

			}
		});
	}

	public static ActionListener exportarAgenciaGetAction() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Exportou agencia");
			}
		});
	}

	public static ActionListener importarContaGetAction() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Importou Conta");
			}
		});
	}

	public static ActionListener exportarContaGetAction() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Exportou Conta");
			}
		});
	}

	public static ActionListener trocaAgenciaGetAction() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Teste.janela.getContentPane().setVisible(false);
				Teste.janela.getContentPane().removeAll();
				// Teste.janela.remove(Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap()).getPainelTabbed().getPainelCompleto());

				Teste.setAgenciaIntMap(0);

				Teste.getBancoGNB().setPainelTabbed(new BancoTabbedPanel());
				Teste.janela.getContentPane().add(
						Teste.getBancoGNB().getPainelTabbed()
								.getPainelCompleto());

				Teste.janela.pack();
				Teste.janela.getContentPane().revalidate();
				// Teste.janela.repaint();

				Teste.janela.getContentPane().setVisible(true);

			}
		});
	}

	public static ActionListener trocarContaGetAction() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

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

	public static ActionListener relatorioClientesGetAction() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Chamou relatorio");
			}
		});
	}

	public static ActionListener relatorioAgenciasGetAction() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Chamou relatorio");
			}
		});
	}

	public static ActionListener exitGetAction() {
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}
