package banco.intgraph;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class CriarA2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public CriarA2() {
		setLayout(null);
		
		JLabel lblNumeroDaAgncia = new JLabel("Numero da Agência:");
		lblNumeroDaAgncia.setBounds(12, 36, 142, 15);
		add(lblNumeroDaAgncia);
		
		JLabel label = new JLabel("01");
		label.setBounds(166, 36, 70, 15);
		add(label);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setBounds(12, 63, 91, 15);
		add(lblDescrio);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(121, 63, 196, 113);
		add(textArea);
		
		JButton btnAdicionarAgncia = new JButton("Adicionar Agência");
		btnAdicionarAgncia.setBounds(121, 188, 196, 25);
		add(btnAdicionarAgncia);

	}
}
