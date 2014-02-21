package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import Inicio.Teste;

public abstract class MenuActionListeners {

	public static ActionListener importarAgenciaGetAction(){
		return (	
			new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Importou agencia");
					
				}
			}		
		);
	}
	
	public static ActionListener exportarAgenciaGetAction(){
		return (	
			new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Exportou agencia");
				}
			}		
		);
	}
	
	public static ActionListener importarContaGetAction(){
		return (	
			new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Importou Conta");
				}
			}		
		);
	}
	
	public static ActionListener exportarContaGetAction(){
		return (	
			new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Exportou Conta");
				}
			}		
		);
	}
	
	public static ActionListener trocaAgenciaGetAction(){
		return (	
			new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {				
					
					
					Teste.janela.getContentPane().setVisible(false);
					Teste.janela.getContentPane().removeAll();
//					Teste.janela.remove(Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap()).getPainelTabbed().getPainelCompleto());
					
					Teste.setAgenciaIntMap(0);
					
					Teste.janela.getContentPane().add(Teste.getBancoGNB().getPainelTabbed().getPainelCompleto());
					Teste.janela.pack();
					Teste.janela.getContentPane().revalidate();
//					Teste.janela.repaint();
					
					Teste.janela.getContentPane().setVisible(true);
				}
			}		
		);
	}
	
	public static ActionListener relatorioClientesGetAction(){
		return (	
				new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("Chamou relatorio");
					}
				}		
		);
	}
	
	public static ActionListener relatorioAgenciasGetAction(){
		return (	
			new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Chamou relatorio");
				}
			}
		);
	}
	
	public static ActionListener exitGetAction(){
		return (	
			new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			}		
		);
	}
	
}
