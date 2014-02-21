package agencia.intgraph;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;

import cliente.Cliente;
import cliente.PessoaFisica;
import cliente.PessoaJuridica;

public class CrudCliente extends JTable{
	

	public CrudCliente(){}

	
	public CrudCliente(int linhas,int colunas){
		super(linhas,colunas);
	}
	
	public void setClienteAt(Cliente cliente,int linha){
		//this.setValueAt(aValue, row, column)
	
		
		this.setValueAt(cliente.getIdentificacao(), linha, 1);
		
		if(cliente instanceof PessoaFisica){
			this.setValueAt(((PessoaFisica) cliente).getCpf(), linha, 2);
			this.setValueAt("PF", linha, 0);
		}
		else if(cliente instanceof PessoaJuridica)
		{
			this.setValueAt(((PessoaJuridica) cliente).getCnpj(), linha, 2);
			this.setValueAt("PJ", linha, 0);
		}
		
		if(cliente.getEndereco().size() > 0)
			this.setValueAt(cliente.getEndereco().get(0), linha, 3);
		
	}
	
}
