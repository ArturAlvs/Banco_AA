package conta.intgraph;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import cliente.PessoaFisica;

import conta.Conta;
import conta.ContaCorrente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;





public class PainelSacar extends JPanel {
	private JTextField txtQuantia = new JTextField();

	/**
	 * Create the panel.
	 */
	public PainelSacar(final Conta conta) {
		setLayout(null);
		
		JLabel lblsacar = new JLabel("Saque");
		lblsacar.setFont(new Font("Dialog", Font.BOLD, 15));
		lblsacar.setBounds(163, 12, 70, 15);
		add(lblsacar);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setBounds(28, 48, 52, 15);
		add(lblSaldo);
		
		JLabel lblPossaldo = new JLabel("PosSaldo");
		lblPossaldo.setBounds(222, 48, 70, 15);
		add(lblPossaldo);
		
		final JLabel lblValorSaldo = new JLabel(""+conta.obterSaldo());
		lblValorSaldo.setBounds(92, 48, 70, 15);
		add(lblValorSaldo);
		
		final JLabel lblValorPosSaldo = new JLabel(conta.obterSaldo()+"");
		lblValorPosSaldo.setBounds(304, 48, 70, 15);
		add(lblValorPosSaldo);
		
		
		
		txtQuantia.setBounds(92, 146, 114, 19);
		txtQuantia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		
		txtQuantia.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				try{
					Double valor =	conta.getSaldo() - Double.parseDouble(txtQuantia.getText()); 
					lblValorPosSaldo.setText(valor+"");
				}catch(Exception ex){
					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()== KeyEvent.VK_BACK_SPACE){
					
					lblValorPosSaldo.setText(conta.getSaldo()+"");
				}
				
			}
		});
		
		add(txtQuantia);
		txtQuantia.setColumns(10);
		
		JLabel lblQuantia = new JLabel("Quantia:");
		lblQuantia.setBounds(28, 146, 63, 17);
		add(lblQuantia);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Double valor = Double.parseDouble(txtQuantia.getText());
					conta.sacar(valor);
					
					lblValorPosSaldo.setText(conta.getSaldo()+"");
					lblValorSaldo.setText(conta.getSaldo()+"");
					
					txtQuantia.setText("");
					
					PainelDepositar.atualizarTela();
					
				}catch(Exception exc){
					System.out.println("Valor informado Invalido");
				}
			}
		});
		btnOk.setBounds(251, 140, 117, 25);
		add(btnOk);

	}
	

}
