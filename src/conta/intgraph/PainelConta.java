package conta.intgraph;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import cliente.PessoaFisica;
import cliente.PessoaJuridica;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import conta.HistoricoConta;

public class PainelConta extends JPanel {

	private final int LARGURA_BOTAO = 100 , ALTURA_BOTAO = 30;
	//botoes 
	private final JButton botaoOk = new JButton("OK");
	private final JButton botaoCancelar = new JButton("Cancelar");
	
	//radio para escolher se eh pessoa fisica ou juridica
	private final JRadioButton radioPessoaFisica = new JRadioButton("Pessoa Fisica");
	private final JRadioButton radioPessoaJuridica = new JRadioButton("Pessoa Juridica");
	
	private final JRadioButton radioContaCorrente = new JRadioButton("Conta Corrente");
	private final JRadioButton radioContaPoupanca = new JRadioButton("Conta Poupanca");
	private final JRadioButton radioContaCartaoCredito = new JRadioButton("Conta Cartão de Crédito");
	
	// agrupar os radios acima
	private final ButtonGroup groupCliente = new ButtonGroup();
	private final ButtonGroup groupContas = new ButtonGroup();
	
	//labels para descricao dos campos a serem preenchidos
	private final JLabel labelIdentificacao = new JLabel("Identificacao");
	private final JLabel labelDocumento = new JLabel("CPF");
	private final JLabel labelNumeroConta = new JLabel("Número:");
	private final JLabel labelSaldo = new JLabel("Saldo:");
	private final JLabel labelDataAbertura = new JLabel("Data de Abertura:");	
	//se for conta corrente taxa de juros se for conta poupanca taxa de rendimento
	private final JLabel labelTaxa = new JLabel("Taxa de Juros:");
	private final JLabel labelLimiteSaque = new JLabel("Limite de Saque:");
	private final JLabel labelTaxaServiço = new JLabel("Taxa de Serviço:");
	private final JLabel labelAniversario = new JLabel("Aniversário:");
	private final JLabel labelNumeroCasa = new JLabel("Número:");
	private final JLabel labelRua = new JLabel("Rua");
	private final JLabel labelEnderecos = new JLabel("Enderecos");
	private final JLabel labelCep = new JLabel("Cep");
	
	//campos a serem preenchidos
	private final JFormattedTextField textDocumento = new JFormattedTextField();
	private final JFormattedTextField textDataAbertura = new JFormattedTextField();	
	private final JTextField textIdentificacao = new JTextField();
	private final JFormattedTextField textNumeroConta = new JFormattedTextField();
	private final JTextField textSaldo = new JTextField();
	private final JTextField textTaxa = new JTextField();
	private final JFormattedTextField textAniversario = new JFormattedTextField();
	private final JTextField textTaxaServico = new JTextField();
	private final JTextField textLimiteSaque = new JTextField();	
	private final JFormattedTextField textCep = new JFormattedTextField();	
	private final JTextField textNumeroCasa = new JTextField();	
	private final JTextField textRua = new JTextField();
	
	
	private final MaskFormatter mask = new MaskFormatter();
	private final MaskFormatter maskData = new MaskFormatter();
	private final MaskFormatter maskData2 = new MaskFormatter();
	private final MaskFormatter maskConta = new MaskFormatter();
	
	
	private final JScrollPane scroll = new JScrollPane();
	private final JTable table = new JTable(100, 3);
	
	public PainelConta() {

		
		this.setLayout(null);
		
		//SETAR EVENTOS
		this.radioPessoaFisica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				labelDocumento.setText("CPF");

				try {

					textDocumento.setText("");
					mask.setMask("###.###.###-##");
					mask.install(textDocumento);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}    				
			}
		});
		this.radioPessoaJuridica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				labelDocumento.setText("CNPJ");
				try {
					mask.setMask( "##.###.###/####-##" );
					textDocumento.setText("");
					mask.install(textDocumento);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
//		this.botaoOk.addActionListener(PainelNovoClienteActionListeners.botaoOkGetAction());
//		this.botaoCancelar.addActionListener(PainelNovoClienteActionListeners.botaoCancelarGetAction());
		
//		this.radioContaCorrente.addActionListener(PainelNovoClienteActionListeners.botaoContaCorrenteGetAction(textAniversario, textTaxaServico, textLimiteSaque, labelTaxa));
//		this.radioContaPoupanca.addActionListener(PainelNovoClienteActionListeners.botaoContaCorrenteGetAction(textAniversario, textTaxaServico, textLimiteSaque, labelTaxa));
		this.radioContaCorrente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textAniversario.setEnabled(false);
				textTaxaServico.setEnabled(true);
				textLimiteSaque.setEnabled(true);
				labelTaxa.setText("Taxa de Juros:");
				
			}
		});
		
		this.radioContaPoupanca.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textAniversario.setEnabled(true);
				textTaxaServico.setEnabled(false);
				textLimiteSaque.setEnabled(false);
				labelTaxa.setText("Taxa de Rendimento:");
				
			}
		});
		
		//ADICIONAR RADIOGROUPS
		this.groupCliente.add(radioPessoaFisica);
		this.groupCliente.add(radioPessoaJuridica);
		
		this.radioPessoaFisica.setSelected(true);
		
		this.radioPessoaFisica.setBounds(30, 30, 150, 50);
		this.radioPessoaJuridica.setBounds(180, 30, 150, 50);
		
		this.add(this.radioPessoaFisica);
		this.add(this.radioPessoaJuridica);
		
		this.groupContas.add(this.radioContaCorrente);
		this.groupContas.add(this.radioContaPoupanca);
		this.groupContas.add(this.radioContaCartaoCredito);
		
		this.radioContaCorrente.setBounds(30, 200, 150, 20);
		this.radioContaPoupanca.setBounds(180, 200, 150, 20);
		this.radioContaCartaoCredito.setBounds(180+150, 200, 250, 20);
		
		this.radioContaCorrente.setSelected(true);
		
		this.add(radioContaCorrente);
		this.add(radioContaPoupanca);
		this.add(radioContaCartaoCredito);
		
		
		
		//ADICIONAR BOTOES
		this.botaoOk.setBounds(30, 450, LARGURA_BOTAO, ALTURA_BOTAO);
		this.botaoCancelar.setBounds(30+LARGURA_BOTAO+10, 450, LARGURA_BOTAO, ALTURA_BOTAO);
		
		this.add(botaoCancelar);
		this.add(botaoOk);
		
		//ADICIONAR CAMPOS
		
		//CLIENTE
		
		this.labelIdentificacao.setBounds(30, 80, 100, 20);
		this.add(labelIdentificacao);
		
		this.textIdentificacao.setBounds(30, 100, 300, 20);
		this.add(textIdentificacao);
		
		this.labelDocumento.setBounds(30, 130, 150, 20);
		this.add(labelDocumento);
		
		this.textDocumento.setBounds(30, 150, 150, 20);
		this.add(textDocumento);
		
		//CONTA
		
		this.labelNumeroConta.setBounds(30,260,60,20);		
		this.textNumeroConta.setBounds(185, 260, 100, 20);
		this.textNumeroConta.setEnabled(false);
		
		this.add(labelNumeroConta);
		this.add(textNumeroConta);
		
		this.labelDataAbertura.setBounds(30,290,150,20);
		this.textDataAbertura.setBounds(205, 290, 80, 20);
		
		this.add(labelDataAbertura);
		this.add(textDataAbertura);
		
		
		this.labelSaldo.setBounds(30, 320, 60, 20);
		this.textSaldo.setBounds(185, 320, 100, 20);
		
		this.add(labelSaldo);
		this.add(textSaldo);
		
		//TAXA DE JUROS OU RENDIMENTO
		
		this.labelLimiteSaque.setBounds(30, 350, 120, 20);
		this.textLimiteSaque.setBounds(185, 350, 100, 20);
		
		this.add(labelLimiteSaque);
		this.add(textLimiteSaque);
		
		//COLUNA DA DIREITA
		
		this.labelAniversario.setBounds(350,260,100,20);
		this.textAniversario.setBounds(470,260,80,20);
		
		this.add(labelAniversario);
		this.add(textAniversario);
		
		this.labelTaxaServiço.setBounds(350, 290, 120, 20);
		this.textTaxaServico.setBounds(470+40, 290, 40, 20);
		
		this.add(labelTaxaServiço);
		this.add(textTaxaServico);
		
		this.labelTaxa.setBounds(350, 320, 100, 20);
		this.textTaxa.setBounds(470+40, 320, 40, 20);
		
		this.add(labelTaxa);
		this.add(textTaxa);
		
		
		labelEnderecos.setBounds(440, 30, 80, 15);
		this.add(labelEnderecos);
		
		labelCep.setBounds(440, 65, 30, 20);
		this.add(labelCep);
		
		textCep.setBounds(487, 66, 92, 20);		
		this.add(textCep);
		
		labelNumeroCasa.setBounds(582, 65, 70, 20);		
		this.add(labelNumeroCasa);
		
		textNumeroCasa.setBounds(651, 66, 70, 20);
		this.add(textNumeroCasa);
		
		labelRua.setBounds(440, 102, 40, 20);		
		this.add(labelRua);
		
		textRua.setBounds(487, 100, 231, 20);
		this.add(textRua);

		


		//o padrao da tela eh ser pessoa fisica / cpf
		try {
			mask.setMask("###.###.###-##");
			mask.install(textDocumento);
			
			maskData.setMask("##/##/####");
			maskData2.setMask("##/##/####");
			maskData2.install(textDataAbertura);
			maskData.install(textAniversario);
			
			maskConta.setMask("##.#####.#");
			maskConta.install(textNumeroConta);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.textNumeroConta.setText("01000011");
		
		
		//COLOCAR HISTORICO
		
		JLabel lblhistorico = new JLabel("Histórico");
		lblhistorico.setFont(new Font("Dialog", Font.BOLD, 16));
		lblhistorico.setBounds(700, 140, 114, 39);
		add(lblhistorico);
		
		
		scroll.setBounds(592, 200, 311, 254);
		table.getColumnModel().getColumn(0).setHeaderValue("Tipo");
		table.getColumnModel().getColumn(1).setHeaderValue("Valor");  
		table.getColumnModel().getColumn(2).setHeaderValue("Data");
		
		scroll.setViewportView(table);
		
		add(scroll);
		
		
	}
	
	
	
	
	
	public void preenchePainel(Conta c){
		
		this.textIdentificacao.setText(c.getCliente().getIdentificacao());
		this.textCep.setText(c.getCliente().getEndereco().get(0).getCep());
		this.textNumeroCasa.setText(c.getCliente().getEndereco().get(0).getNumeroEnd()+"");
		this.textRua.setText(c.getCliente().getEndereco().get(0).getRua());
		
		if(c.getCliente() instanceof PessoaFisica){
			this.radioPessoaFisica.setSelected(true);
			PessoaFisica p = (PessoaFisica) c.getCliente();
			this.textDocumento.setText(p.getCpf()+"");
		}
		else if(c.getCliente() instanceof PessoaJuridica){
			this.radioPessoaJuridica.setSelected(true);
			PessoaJuridica p = (PessoaJuridica) c.getCliente();
			this.textDocumento.setText(p.getCnpj()+"");
		}
		
		this.textSaldo.setText(c.obterSaldo()+"");
		this.textNumeroConta.setText(""+c.getNumero());
		this.textDataAbertura.setText(c.getDataAbertura().getDia()+""+c.getDataAbertura().getMes()+""+c.getDataAbertura().getAno());
		
		if(c instanceof ContaCorrente){
			this.radioContaCorrente.setSelected(true);
			
			this.textLimiteSaque.setText(((ContaCorrente) c).getLimiteSaque()+"");
			this.textTaxaServico.setText(((ContaCorrente) c).getTaxaServico()+"");
			this.textTaxa.setText(((ContaCorrente) c).getTaxaJuros()+"");
		}
		else if(c instanceof ContaPoupanca){
			this.radioContaPoupanca.setSelected(false);
			
			this.textTaxa.setText(((ContaPoupanca) c).getTaxaRendimento()+"");
			this.textAniversario.setText(((ContaPoupanca) c).getDataAniversario().getDia()+""+((ContaPoupanca) c).getDataAniversario().getMes()+""+((ContaPoupanca) c).getDataAniversario().getAno());
		}
		else
			this.radioContaCartaoCredito.setSelected(true);
			
		
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
//		janela.setSize(1024,600);
//		janela.setLocationRelativeTo(null); 
//		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		
//		ContaCorrente c = new ContaCorrente();
//		c.creditar(1000);		
//		PainelConta painel = new PainelConta();
//		painel.preenche(c.getHistorico());
//		
//		janela.getContentPane().add(painel);
//		
//		janela.setVisible(true);
//	}

}
