package conta.intgraph;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;

import Inicio.Teste;
import conta.ContaCorrente;
import conta.HistoricoConta;

public class PainelHistorico extends JPanel {
	private final JScrollPane scroll = new JScrollPane();
	private final JTable table = new JTable(1, 3);
	
	
	public PainelHistorico() {
		setLayout(null);
		
		JLabel lblhistorico = new JLabel("Histórico");
		lblhistorico.setFont(new Font("Dialog", Font.BOLD, 16));
		lblhistorico.setBounds(165, 12, 114, 39);
		add(lblhistorico);
		
		
		scroll.setBounds(83, 63, 311, 254);
		table.getColumnModel().getColumn(0).setHeaderValue("Tipo");
		table.getColumnModel().getColumn(1).setHeaderValue("Valor");  
		table.getColumnModel().getColumn(2).setHeaderValue("Data");
		
		scroll.setViewportView(table);
		
		add(scroll);
		
		
//		Preenche com essa conta (Conta atual)
		preenche(Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap()).getContas().get(Teste.getContaIntMap()).getHistorico() );
		
	}
	

	public void preenche(ArrayList<HistoricoConta> historicos){
		for (int i = 0; i < historicos.size(); i++) {
			table.setValueAt(historicos.get(i).getTransacao(), i, 0);
			table.setValueAt(historicos.get(i).getValor(), i, 1);
			
			if(historicos.get(i).getData()!=null){
				table.setValueAt(historicos.get(i), i, 2);
			}
		}
	}
	
	
//	public static void main(String[] args) {
//		JFrame janela = new JFrame();
//		janela.setSize(500, 600);
//		janela.setLocationRelativeTo(null); 
//		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		
//		ContaCorrente c = new ContaCorrente();
//		c.creditar(1000);		
//		PainelHistorico painel = new PainelHistorico();
//		painel.preenche(c.getHistorico());
//		
//		janela.getContentPane().add(painel);
//		
//		janela.setVisible(true);
//	}
}
