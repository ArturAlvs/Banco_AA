package agencia.intgraph.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import agencia.intgraph.PainelCliente;
import agencia.intgraph.PainelNovoCliente;

public abstract class PainelClientActionListeners {

	public static ActionListener botaoOkGetAction(){
		return (
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Ok!!");
				}
			}			
		);
	}
	
	public static ActionListener botaoCancelarGetAction(final PainelCliente p){
		return (
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int linha = p.getCrudCliente().getSelectedRow();
					if(linha >-1){
						//p.getCrudCliente().setValueAt("", linha, 0);
						//p.getCrudCliente().setValueAt("", linha, 1);
						p.getCrudCliente().clearSelection(); //putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
	
						p.getCrudCliente().getCellEditor().cancelCellEditing();
						p.getCrudCliente().setEnabled(false);
						
						System.out.println("cancela");
					}
				}
			}			
		);
	}
	
	public static ActionListener botaoNovoGetAction(){
		return (
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//chamar um outro painel que cria a conta para um dado cliente
					JFrame janelaInclusao = new JFrame("Incluir cliente");
					janelaInclusao.setSize(800, 640);
					janelaInclusao.setLocationRelativeTo(null); 
					//janelaInclusao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					PainelNovoCliente painel = new PainelNovoCliente();
					janelaInclusao.add(painel);
					janelaInclusao.setVisible(true);
//					painelNovoCliente.setVisible(true);
//					criaPainelNovoCliente();
					System.out.println("Novo!!");
				}
			}			
		);
	}
	
	public static ActionListener botaoAlterarGetAction(final PainelCliente p){
		return (
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					p.getCrudCliente().setEnabled(true);
					
				}
			}			
		);
	}
	
	public static ActionListener botaoExcluirGetAction(){
		return (
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Excluir!!");
				}
			}			
		);
	}
	
	
}
