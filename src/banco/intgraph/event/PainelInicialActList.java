package banco.intgraph.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Inicio.Teste;

public abstract class PainelInicialActList {
	
	public static ActionListener botaoEntrar() {
		
		return(
				
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
//						Teste.getBancoGNB().aAA();
//						Teste.getBancoGNB().getAgencias().get(1).aAA();
						
//						Limpa janela e adiciona outra tela 
						Teste.janela.getContentPane().removeAll();
						Teste.janela.getContentPane().add(Teste.getBancoGNB().getPainelTabbed().getPainelCompleto());
						Teste.janela.pack();
						Teste.janela.getContentPane().revalidate();

					}
				}
				
		);
		
	}

}
