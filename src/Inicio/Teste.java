package Inicio;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import serializa.Serializa;
import menu.MenuPrincipal;
import cliente.intgraph.ShowClienteTable;
import banco.intgraph.PainelInicial;
import banco.intgraph.ShowAgenciaTable2;

public class Teste {

	// @SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Teste gnb = new Teste();
		

		bancoGNB.instaciarPaineis();

		janela = new JFrame(NOME_JANELA);
		janela.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
//				System.out.println("closing");
				guardaBanco();
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(JANELA_WIDTH, JANELA_HEIGHT);

		JMenuBar menu = MenuPrincipal.criaMenuPrincipal();
		janela.setJMenuBar(menu);

		// System.out.println(getBancoGNB());

		janela.getContentPane().add(
				bancoGNB.getPainelInicial().getPainelCompleto());
		// janela.getContentPane().add(
		// bancoGNB.getPainelTabbed().getPainelCompleto());

		// System.out.println(janela.getContentPane().getComponentCount());

		janela.pack();
		// janela.show();
		janela.setVisible(true);

		// System.out.println("ASD");

	}

	// Variaveis-----------------------------
	// Janela
	public static JFrame janela;

	private final static String NOME_JANELA = "GNB";

	private final static int JANELA_WIDTH = 800;
	private final static int JANELA_HEIGHT = 800;
	private final static int DIFERENCA_TAMANHO = 300;

	// Instancias
	private static banco.Banco bancoGNB = new banco.Banco(NOME_JANELA);

	// Agencia, Conta, Cliente
	private static int agenciaIntMap = 1;
	private static int contaIntMap = 0;

	// Gets 'n' Sets
	public static banco.Banco getBancoGNB() {
		return bancoGNB;
	}

	public static void setBancoGNB(banco.Banco bancoGNB) {
		Teste.bancoGNB = bancoGNB;
	}

	public static int getJanelaWidth() {
		return JANELA_WIDTH;
	}

	public static int getDiferencaTamanho() {
		return DIFERENCA_TAMANHO;
	}

	public static int getJanelaHeight() {
		return JANELA_HEIGHT;
	}

	public static int getAgenciaIntMap() {
		return agenciaIntMap;
	}

	public static void setAgenciaIntMap(int agenciaIntMap) {
		Teste.agenciaIntMap = agenciaIntMap;
	}

	public static int getContaIntMap() {
		return contaIntMap;
	}

	public static void setContaIntMap(int contaIntMap) {
		Teste.contaIntMap = contaIntMap;
	}

	// Serializa O Banco
	public static void guardaBanco() {
		Serializa.SerBanco(bancoGNB);
	}

	public static void pegaBanco() {
		bancoGNB = Serializa.deSerealiza();
	}

}
