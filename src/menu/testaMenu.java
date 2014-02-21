package menu;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class testaMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JMenuBar m = MenuPrincipal.criaMenuPrincipal();
		
		JFrame janela = new JFrame();
		
		janela.setLocationRelativeTo(null);
		janela.setSize(500, 500);
		
		janela.setJMenuBar(m);
	
		janela.setVisible(true);
	}

}
