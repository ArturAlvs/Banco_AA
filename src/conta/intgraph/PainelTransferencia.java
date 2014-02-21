package conta.intgraph;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

import agencia.Agencia;
import javax.swing.JTable;
import javax.swing.text.MaskFormatter;

import cliente.PessoaFisica;
import cliente.PessoaJuridica;

import conta.Conta;
import conta.ContaCorrente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



// ATENCAO O CU ESTA NO RODAPE (CRIEI UM METODO MAIN AKI DENTOR SO PRA TESTAR)

public class PainelTransferencia extends JPanel {
	
	private final JLabel lblSaldo = new JLabel();
	private final JLabel lblPosSaldo = new JLabel();
	
	private final JFormattedTextField txtQuantia = new JFormattedTextField();
	
	private final JTable tabelaOrigem;
	private final JTable tabelaDestino;
	
	
	private final JButton btnOk = new JButton("Ok");
	
	private final JScrollPane scrollOrigem = new JScrollPane();
	private final JScrollPane scrollDestino = new JScrollPane();


	
	//a agencia sera usada para preencher a lista de contas
	public PainelTransferencia(final Agencia agencia) {
		setLayout(null);
		
		JLabel label = new JLabel("Saldo:");
		label.setBounds(56, 48, 52, 15);
		add(label);
		
		
		lblSaldo.setBounds(120, 48, 70, 15);
		add(lblSaldo);
		
		JLabel lblTransferencia = new JLabel("Transferencia");
		lblTransferencia.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTransferencia.setBounds(138, 12, 113, 15);
		add(lblTransferencia);
		
		JLabel label_3 = new JLabel("PosSaldo");
		label_3.setBounds(279, 48, 70, 15);
		add(label_3);
		
		
		lblPosSaldo.setBounds(361, 48, 70, 15);
		add(lblPosSaldo);
		
		JLabel label_2 = new JLabel("Quantia:");
		label_2.setBounds(56, 331, 63, 17);
		add(label_2);
		
		
		
		txtQuantia.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		
		txtQuantia.setColumns(10);
		txtQuantia.setBounds(130, 330, 114, 19);
	
		txtQuantia.setHorizontalAlignment(javax.swing.JTextField.RIGHT); 
		add(txtQuantia);
		
		//adicionar evento de transferencia
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int linhaOrigem = tabelaOrigem.getSelectedRow();
				int linhaDestino = tabelaDestino.getSelectedRow();
				
				if(linhaDestino > -1 && linhaOrigem > -1){
					Conta cOrigem = agencia.buscaConta((int) tabelaOrigem.getValueAt(linhaOrigem, 0));
					Conta cDestino = agencia.buscaConta((int) tabelaDestino.getValueAt(linhaOrigem, 0));
					
					//System.out.println(tabelaOrigem.getValueAt(linhaOrigem, 0));
					//if(cOrigem instanceof ContaCorrente){
						try{
							//Double valor = Double.parseDouble(txtQuantia.getText());
							//conta.sacar(valor);
							
						//	lblValorPosSaldo.setText(conta.getSaldo()+"");
						//	lblValorSaldo.setText(conta.getSaldo()+"");
							
							Double valor = Double.parseDouble(txtQuantia.getText()); 
							
							if(cOrigem.sacar(valor)){
								//conseguiu sacar entao transfere
								System.out.println(cOrigem.obterSaldo());
								cDestino.setSaldo(cDestino.obterSaldo()+valor);
								lblSaldo.setText(""+cOrigem.obterSaldo());
								lblPosSaldo.setText(""+cOrigem.obterSaldo());
							}
														
							
							txtQuantia.setText("");
							
							
						}catch(Exception exc){
							System.out.println("Valor Invalido");
						}
					//}
					
				}
			}
		});
		
		
		btnOk.setBounds(279, 325, 117, 25);
		add(btnOk);
		
		
		
		//gerar uma tabela com a qtd linhas = qtd de contas e 2 colunas apresentar o numero da conta e o nome do cliente
		
		tabelaOrigem = new JTable(agencia.getContas().size(),2);
		tabelaOrigem.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tabelaOrigem.getSelectedRow();
				if(linha>-1){
					
					int idConta = Integer.parseInt(""+tabelaOrigem.getValueAt(linha, 0)); 
					
					lblSaldo.setText(agencia.buscaConta(idConta).obterSaldo()+"");
					lblPosSaldo.setText(agencia.buscaConta(idConta).obterSaldo()+"");					
					
				}
				
			}
		});

		
		txtQuantia.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
						
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				int linha = tabelaOrigem.getSelectedRow();
				if(linha>-1){
					
					int idConta = Integer.parseInt(""+tabelaOrigem.getValueAt(linha, 0)); 
					lblSaldo.setText(agencia.buscaConta(idConta).obterSaldo()+"");
					
					try{
						
						Double valor =	agencia.buscaConta(idConta).getSaldo() - Double.parseDouble(txtQuantia.getText()); 
						//idConta = Integer.parseInt(""+tabelaOrigem.getValueAt(linha, 0));
						lblPosSaldo.setText(""+valor);
						
					}catch(Exception exc){
						
					}
				}
				
				if(txtQuantia.getText() == ""){
//					int linha = tabelaOrigem.getSelectedRow();
					if(linha>-1){
						
						int idConta = Integer.parseInt(""+tabelaOrigem.getValueAt(linha, 0)); 
						lblPosSaldo.setText(agencia.buscaConta(idConta).getSaldo()+"");
					}	
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode()== KeyEvent.VK_BACK_SPACE){
					int linha = tabelaOrigem.getSelectedRow();
					int idConta = Integer.parseInt(""+tabelaOrigem.getValueAt(linha, 0));

					lblPosSaldo.setText(agencia.buscaConta(idConta).getSaldo()+"");
				}
			}
		});
		
		
		scrollOrigem.setBounds(56, 116, 195, 139);
		this.scrollOrigem.setViewportView(tabelaOrigem);
		add(scrollOrigem);
		
		tabelaDestino = new JTable(agencia.getContas().size(),2);
		scrollDestino.setBounds(279, 116, 208, 139);
		this.scrollDestino.setViewportView(tabelaDestino);
		add(scrollDestino);
		
		
		tabelaOrigem.getColumnModel().getColumn(0).setHeaderValue("Numero");
		tabelaOrigem.getColumnModel().getColumn(1).setHeaderValue("Cliente");
		
		tabelaDestino.getColumnModel().getColumn(0).setHeaderValue("Numero");
		tabelaDestino.getColumnModel().getColumn(1).setHeaderValue("Cliente");
		
		//preencher tabelas
		int linha = 0;
		for(Conta c : agencia.getContas().values()) {
			
			tabelaOrigem.setValueAt(c.getNumero(), linha, 0);
			tabelaDestino.setValueAt(c.getNumero(), linha, 0);
			
			tabelaOrigem.setValueAt(c.getCliente().getIdentificacao(), linha, 1);
			tabelaDestino.setValueAt(c.getCliente().getIdentificacao(), linha, 1);
			
			linha++;
		}
		
		
		
		JLabel lblOrigem = new JLabel("Origem");
		lblOrigem.setBounds(84, 89, 70, 15);
		add(lblOrigem);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setBounds(350, 89, 70, 15);
		add(lblDestino);

	}
	
/*
	public static void main(String[] args) {
		
		JFrame janela = new JFrame();
		janela.setSize(800, 600);
		janela.setLocationRelativeTo(null); 
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Agencia agencia = new Agencia("Nome da Agencia");
		
		PessoaFisica c1 = new PessoaFisica("Douglas");
		c1.setCpf("14934393757");
		
		PessoaFisica c2 = new PessoaFisica("Artur S2 ");
		c2.setCpf("14934393757");
		
		PessoaFisica c3 = new PessoaFisica("Artur");
		c3.setCpf("14934393757");
		
		PessoaJuridica c4 = new PessoaJuridica("Sou uma Empresa");
		c4.setCnpj("12332132133123");
		
		
		PessoaFisica c5 = new PessoaFisica("fulano");
		c5.setCpf("14934393757");
		
		PessoaFisica c6 = new PessoaFisica("ciclano");
		c6.setCpf("14934393757");
		
		PessoaFisica c7 = new PessoaFisica("beltrano");
		c7.setCpf("14934393757");
		
		PessoaJuridica c8 = new PessoaJuridica("Jupiacira");
		c8.setCnpj("12332132133123");
		
		PessoaFisica c9 = new PessoaFisica("Artur S");
		c7.setCpf("14934393757");
		
		
		agencia.criarContaCorrente(c1);
		agencia.criarContaCorrente(c2);
		agencia.criarContaCorrente(c3);
		agencia.criarContaCorrente(c4);
		agencia.criarContaCorrente(c5);
		agencia.criarContaCorrente(c6);
		agencia.criarContaCorrente(c7);
		agencia.criarContaCorrente(c8);
		agencia.criarContaCorrente(c9);
		
		for (Conta c : agencia.getContas().values()) {
			c.setSaldo(1000);
		}
		
		
		
		PainelTransferencia painel = new PainelTransferencia(agencia);
		
		janela.getContentPane().add(painel);
		
		janela.setVisible(true);

	}
*/
}
