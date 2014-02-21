package agencia.intgraph.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

public abstract class PainelNovoClienteActionListeners {

	public static ActionListener botaoOkGetAction(){
		return (new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public static ActionListener botaoCancelarGetAction(){
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public static ActionListener botaoContaCorrenteGetAction(final JFormattedTextField aniversario, final JTextField taxaServico,final JTextField limiteSaque ,final JLabel taxaJuros){
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
	
	public static ActionListener botaoContaPoupancaGetAction(final JFormattedTextField aniversario, final JTextField taxaServico,final JTextField limiteSaque ,final JLabel taxaJuros){
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
	
	public static ActionListener botaoContaCartaoGetAction(){
		return (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
}