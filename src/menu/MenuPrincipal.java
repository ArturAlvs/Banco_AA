package menu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MenuPrincipal extends JMenuBar implements KeyListener, ActionListener{
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public static JMenuBar criaMenuPrincipal(){

		JMenuBar menuBar;
		//     menu         submenu     submenu      menu
		JMenu menuArquivo,menuImportar,menuExportar,menuUtilitaros,menuRelatorios;
		//Itens de menu
		JMenuItem importarAgencia,importarConta,exportarAgencia,exportarConta,trocaAgencia, trocarConta,relatorioClientes,relatorioAgencias,exit;
		//criando o menu		
		menuBar = new JMenuBar();
		
		
		// definindo menus		
		menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);

		menuUtilitaros = new JMenu("Utilitarios");
		menuBar.add(menuUtilitaros);

		exit = new JMenuItem("Sair");
		exit.setMnemonic(KeyEvent.VK_X);
		exit.addActionListener(MenuActionListeners.exitGetAction());
		menuBar.add(exit);
		
		
		//definir submenus
		menuImportar = new JMenu("Importar");
		menuExportar = new JMenu("Exportar");
		//seeItRun.addMenuListener(new thisMenuListener());
		menuArquivo.add(menuImportar);
		menuArquivo.add(menuExportar);		
		
		trocaAgencia = new JMenuItem("Trocar Agencia");
		trocaAgencia.addActionListener(MenuActionListeners.trocaAgenciaGetAction());
		trocarConta = new JMenuItem("Trocar Conta");
		trocarConta.addActionListener(MenuActionListeners.trocarContaGetAction());
		menuRelatorios =  new JMenu("Relatorios");
		
		menuUtilitaros.add(trocaAgencia);
		menuUtilitaros.add(trocarConta);
		menuUtilitaros.add(menuRelatorios);
		
		
		//definir itens
		importarAgencia = new JMenuItem("Agencias",new ImageIcon("images/open_document_16.gif"));
		importarAgencia.addActionListener(MenuActionListeners.importarAgenciaGetAction());
		
		importarConta = new JMenuItem("Contas",new ImageIcon("images/open_document_16.gif"));
		importarConta.addActionListener(MenuActionListeners.importarContaGetAction());
		
		
		menuImportar.add(importarAgencia);
		menuImportar.add(importarConta);
		
		exportarAgencia = new JMenuItem("Agencias",new ImageIcon("images/open_document_16.gif"));
		exportarAgencia.addActionListener(MenuActionListeners.exportarAgenciaGetAction());
		
		exportarConta = new JMenuItem("Contas",new ImageIcon("images/open_document_16.gif"));
		exportarConta.addActionListener(MenuActionListeners.exportarContaGetAction());
		
		menuExportar.add(exportarAgencia);
		menuExportar.add(exportarConta);
		
		relatorioClientes = new JMenuItem("Relatorio de Clientes",new ImageIcon("images/open_document_16.gif"));
		relatorioClientes.addActionListener(MenuActionListeners.relatorioClientesGetAction());
		
		relatorioAgencias= new JMenuItem("Relatorio de Agencias",new ImageIcon("images/open_document_16.gif"));
		relatorioAgencias.addActionListener(MenuActionListeners.relatorioAgenciasGetAction());
		
		menuRelatorios.add(relatorioAgencias);
		menuRelatorios.add(relatorioClientes);

		return menuBar;
	}
	
}
