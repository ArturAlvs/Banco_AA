package agencia.intgraph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;


import cliente.Cliente;
import cliente.Endereco;
import cliente.PessoaFisica;
import cliente.PessoaJuridica;
import conta.ContaCartaoCredito;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import data.Data;
import data.DataInvalida;
import enums.TipoContas;
import Inicio.Teste;
import agencia.intgraph.event.PainelNovoClienteActionListeners;

public class PainelNovoCliente extends JPanel {

	private final int LARGURA_BOTAO = 100, ALTURA_BOTAO = 30;
	// botoes
	private final JButton botaoOk = new JButton("OK");
	private final JButton botaoCancelar = new JButton("Cancelar");

	// radio para escolher se eh pessoa fisica ou juridica
	private final JRadioButton radioPessoaFisica = new JRadioButton(
			"Pessoa Fisica");
	private final JRadioButton radioPessoaJuridica = new JRadioButton(
			"Pessoa Juridica");

	private final JRadioButton radioContaCorrente = new JRadioButton(
			"Conta Corrente");
	private final JRadioButton radioContaPoupanca = new JRadioButton(
			"Conta Poupanca");
	private final JRadioButton radioContaCartaoCredito = new JRadioButton(
			"Conta Cartão de Crédito");

	// agrupar os radios acima
	private final ButtonGroup groupCliente = new ButtonGroup();
	private final ButtonGroup groupContas = new ButtonGroup();

	// labels para descricao dos campos a serem preenchidos
	private final JLabel labelIdentificacao = new JLabel("Identificacao");
	private final JLabel labelDocumento = new JLabel("CPF");
	private final JLabel labelNumeroConta = new JLabel("Número:");
	private final JLabel labelSaldo = new JLabel("Saldo:");
	private final JLabel labelDataAbertura = new JLabel("Data de Abertura:");
	// se for conta corrente taxa de juros se for conta poupanca taxa de
	// rendimento
	private final JLabel labelTaxa = new JLabel("Taxa de Juros:");
	private final JLabel labelLimiteSaque = new JLabel("Limite de Saque:");
	private final JLabel labelTaxaServico = new JLabel("Taxa de Serviço:");
	private final JLabel labelAniversario = new JLabel("Aniversário:");
	private final JLabel labelNumeroCasa = new JLabel("Número:");
	private final JLabel labelRua = new JLabel("Rua");
	private final JLabel labelEnderecos = new JLabel("Enderecos");
	private final JLabel labelCep = new JLabel("Cep");

	// campos a serem preenchidos
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

	// Aviso------------
	private final JLabel labelAviso = new JLabel("Digite todos os campos!");

	public PainelNovoCliente() {

		this.setLayout(null);

		// SETAR EVENTOS
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
					mask.setMask("##.###.###/####-##");
					textDocumento.setText("");
					mask.install(textDocumento);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		this.botaoOk.addActionListener(botaoOkGetAction());
		this.botaoCancelar.addActionListener(PainelNovoClienteActionListeners
				.botaoCancelarGetAction());

		// this.radioContaCorrente.addActionListener(PainelNovoClienteActionListeners.botaoContaCorrenteGetAction(textAniversario,
		// textTaxaServico, textLimiteSaque, labelTaxa));
		// this.radioContaPoupanca.addActionListener(PainelNovoClienteActionListeners.botaoContaCorrenteGetAction(textAniversario,
		// textTaxaServico, textLimiteSaque, labelTaxa));
		this.radioContaCorrente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textAniversario.setEnabled(false);
				textTaxaServico.setEnabled(true);
				textLimiteSaque.setEnabled(true);
				labelTaxa.setText("Taxa de Juros:");
				
				textNumeroConta.setText("" + criarNumeroDaConta(TipoContas.CONTA_CORRENTE));

			}
		});

		this.radioContaPoupanca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textAniversario.setEnabled(true);
				textTaxaServico.setEnabled(false);
				textLimiteSaque.setEnabled(false);
				labelTaxa.setText("Taxa de Rendimento:");
				
				textNumeroConta.setText("" + criarNumeroDaConta(TipoContas.CONTA_POUPANCA));

			}
		});
		
		this.radioContaCartaoCredito.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				textNumeroConta.setText("" + criarNumeroDaConta(TipoContas.CONTA_CARTAO));

			}
		});

		// ADICIONAR RADIOGROUPS
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
		this.radioContaCartaoCredito.setBounds(180 + 150, 200, 250, 20);

		this.radioContaCorrente.setSelected(true);

		this.add(radioContaCorrente);
		this.add(radioContaPoupanca);
		this.add(radioContaCartaoCredito);

		// ADICIONAR BOTOES
		this.botaoOk.setBounds(30, 450, LARGURA_BOTAO, ALTURA_BOTAO);
		this.botaoCancelar.setBounds(30 + LARGURA_BOTAO + 10, 450,
				LARGURA_BOTAO, ALTURA_BOTAO);

		this.add(botaoCancelar);
		this.add(botaoOk);

		// ADICIONAR CAMPOS

		// CLIENTE

		this.labelIdentificacao.setBounds(30, 80, 100, 20);
		this.add(labelIdentificacao);

		this.textIdentificacao.setBounds(30, 100, 300, 20);
		this.add(textIdentificacao);

		this.labelDocumento.setBounds(30, 130, 150, 20);
		this.add(labelDocumento);

		this.textDocumento.setBounds(30, 150, 150, 20);
		this.add(textDocumento);

		// CONTA

		this.labelNumeroConta.setBounds(30, 260, 60, 20);
		this.textNumeroConta.setBounds(185, 260, 100, 20);
		this.textNumeroConta.setEnabled(false);

		this.add(labelNumeroConta);
		this.add(textNumeroConta);

		this.labelDataAbertura.setBounds(30, 290, 150, 20);
		this.textDataAbertura.setBounds(205, 290, 80, 20);

		this.add(labelDataAbertura);
		this.add(textDataAbertura);

		this.labelSaldo.setBounds(30, 320, 60, 20);
		this.textSaldo.setBounds(185, 320, 100, 20);

		this.add(labelSaldo);
		this.add(textSaldo);

		// TAXA DE JUROS OU RENDIMENTO

		this.labelLimiteSaque.setBounds(30, 350, 120, 20);
		this.textLimiteSaque.setBounds(185, 350, 100, 20);

		this.add(labelLimiteSaque);
		this.add(textLimiteSaque);

		// COLUNA DA DIREITA

		this.labelAniversario.setBounds(350, 260, 100, 20);
		this.textAniversario.setBounds(470, 260, 80, 20);

		this.add(labelAniversario);
		this.add(textAniversario);

		this.labelTaxaServico.setBounds(350, 290, 120, 20);
		this.textTaxaServico.setBounds(470 + 40, 290, 40, 20);

		this.add(labelTaxaServico);
		this.add(textTaxaServico);

		this.labelTaxa.setBounds(350, 320, 100, 20);
		this.textTaxa.setBounds(470 + 40, 320, 40, 20);

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

		labelAviso.setBounds(30, 550, 231, 200);
		this.add(labelAviso);
		labelAviso.setVisible(false);

		// o padrao da tela eh ser pessoa fisica / cpf
		try {
			mask.setMask("###.###.###-##");
			mask.install(textDocumento);

			maskData.setMask("##/##/####");
			maskData2.setMask("##/##/####");
			maskData2.install(textDataAbertura);
			maskData.install(textAniversario);

			// maskConta.setMask("##.#####.#");
			// maskConta.install(textNumeroConta);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.textNumeroConta.setText("" + criarNumeroDaConta(TipoContas.CONTA_CORRENTE));

	}

	// Actions------------------------

	public ActionListener botaoOkGetAction() {
		return (new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (radioContaCartaoCredito.isSelected()) {
					cartaoCreditoSelect();
				}
				if (radioContaPoupanca.isSelected()) {
					poupancaSelect();
				}
				if (radioContaCorrente.isSelected()) {
					correnteSelect();
				}

			}
		});
	}

	// Açoes dos Botoes
	private void cartaoCreditoSelect() {

		if ((verificacoesConta() == true)) {
			// Tudo certo
			labelAviso.setVisible(false);

			Cliente cliente = null;

			if (radioPessoaFisica.isSelected()) {
				PessoaFisica cliente1 = new PessoaFisica(
						textIdentificacao.getText());

				cliente1.setCpf(textDocumento.getText());
				cliente1.addEndereco(new Endereco(textCep.getText(),
						new Integer(textNumeroCasa.getText()), textRua
								.getText()));

				cliente = cliente1;

			} else {
				PessoaJuridica cliente1 = new PessoaJuridica(
						textIdentificacao.getText());

				cliente1.setCnpj(textDocumento.getText());
				cliente1.addEndereco(new Endereco(textCep.getText(),
						new Integer(textNumeroCasa.getText()), textRua
								.getText()));

				cliente = cliente1;

			}

			ContaCartaoCredito contaCartao = new ContaCartaoCredito(cliente);

			try {
				passaDadosContaCartao(contaCartao);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Integer key = new Integer( textNumeroConta.getText() );

			Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap())
					.getContas().put(key, contaCartao);

			chamarPainelDeContas();

		} else {
			labelAviso.setVisible(true);

		}

	}

	private void poupancaSelect() {

		if ((verificacoesConta() == true)
				&& (!textAniversario.getText().isEmpty())) {

			// Tudo certo
			labelAviso.setVisible(false);

			Cliente cliente = null;

			if (radioPessoaFisica.isSelected()) {
				PessoaFisica cliente1 = new PessoaFisica(
						textIdentificacao.getText());

				cliente1.setCpf(textDocumento.getText());
				cliente1.addEndereco(new Endereco(textCep.getText(),
						new Integer(textNumeroCasa.getText()), textRua
								.getText()));

				cliente = cliente1;

			} else {
				PessoaJuridica cliente1 = new PessoaJuridica(
						textIdentificacao.getText());

				cliente1.setCnpj(textDocumento.getText());
				cliente1.addEndereco(new Endereco(textCep.getText(),
						new Integer(textNumeroCasa.getText()), textRua
								.getText()));

				cliente = cliente1;

			}

			ContaPoupanca contaPoupanca = new ContaPoupanca(cliente);

			try {
				passaDadosContaPoupanca(contaPoupanca);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Integer key = new Integer( textNumeroConta.getText() );

			Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap())
					.getContas().put(key, contaPoupanca);

			chamarPainelDeContas();

		} else {
			labelAviso.setVisible(true);

		}

	}

	private void correnteSelect() {

		if ((verificacoesConta() == true) && (!textTaxa.getText().isEmpty())
				&& (!textTaxaServico.getText().isEmpty())
				&& (!textLimiteSaque.getText().isEmpty())) {

			// Tudo certo
			labelAviso.setVisible(false);

			Cliente cliente = null;

			if (radioPessoaFisica.isSelected()) {
				PessoaFisica cliente1 = new PessoaFisica(
						textIdentificacao.getText());

				cliente1.setCpf(textDocumento.getText());
				cliente1.addEndereco(new Endereco(textCep.getText(),
						new Integer(textNumeroCasa.getText()), textRua
								.getText()));

				cliente = cliente1;

			} else {
				PessoaJuridica cliente1 = new PessoaJuridica(
						textIdentificacao.getText());

				cliente1.setCnpj(textDocumento.getText());
				cliente1.addEndereco(new Endereco(textCep.getText(),
						new Integer(textNumeroCasa.getText()), textRua
								.getText()));

				cliente = cliente1;

			}

			ContaCorrente contaCorrente = new ContaCorrente(cliente);

			try {
				passaDadosContaCorrente(contaCorrente);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Integer key = new Integer( textNumeroConta.getText() );

			Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap())
					.getContas().put(key, contaCorrente);

			chamarPainelDeContas();

		} else {
			labelAviso.setVisible(true);

		}

	}

	private boolean verificacoesConta() {

		if ((textSaldo.getText().isEmpty())
				|| (textDataAbertura.getText().isEmpty())
				|| (verificacoesDados() == false)
				|| (verificacoesEndereco() == false)) {

			return false;

		}

		return true;

	}

	private boolean verificacoesDados() {

		if ((textIdentificacao.getText().isEmpty())
				|| (textDocumento.getText().isEmpty())) {
			return false;
		}

		return true;
	}

	private boolean verificacoesEndereco() {

		if ((textCep.getText().isEmpty())
				|| (textNumeroCasa.getText().isEmpty())
				|| (textRua.getText().isEmpty())) {
			return false;
		}

		return true;
	}

	// Criando os dados das contas------------------------

	private void passaDadosContaCorrente(ContaCorrente cc)
			throws NumberFormatException, BadLocationException {

		// Data abertura -----------------------------------
		Integer dia, mes = null, ano = null;

		dia = new Integer(textDataAbertura.getText(0, 2));
		mes = new Integer(textDataAbertura.getText(3, 2));
		ano = new Integer(textDataAbertura.getText(6, 4));

		// System.out.println(dia + "/" + mes + "/" + ano);
		// System.out.println(textDataAbertura.getText(0, 7));

		try {
			cc.setDataAbertura(new Data(dia, mes, ano));
		} catch (DataInvalida e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Limite Saque---------------------------------------------------------
		double limS;
		Integer lims = new Integer(textLimiteSaque.getText());
		limS = (double) lims;
		cc.setLimiteSaque(limS);

		// Numero conta------------------------------------------------
		cc.setNumero(new Integer(textNumeroConta.getText()));

		// Saldo--------------------------------------
		double saldo;
		Integer sald = new Integer(textSaldo.getText());
		saldo = (double) sald;
		cc.setSaldo(saldo);

		// Taxa de Juros----------------------
		double taxaJuros;
		Integer taxaJ = new Integer(textTaxa.getText());
		taxaJuros = (double) taxaJ;
		cc.setTaxaJuros(taxaJuros);

		// Taxa de Serviço-----------------------
		double taxaServico;
		Integer taxaS = new Integer(textTaxaServico.getText());
		taxaServico = (double) taxaS;
		cc.setTaxaServico(taxaServico);

		cc.setTipo(TipoContas.CONTA_CORRENTE);

	}

	private void passaDadosContaPoupanca(ContaPoupanca cc)
			throws NumberFormatException, BadLocationException {

		// Data abertura -----------------------------------
		Integer dia, mes = null, ano = null;

		dia = new Integer(textDataAbertura.getText(0, 2));
		mes = new Integer(textDataAbertura.getText(3, 2));
		ano = new Integer(textDataAbertura.getText(6, 4));

		// System.out.println(dia + "/" + mes + "/" + ano);
		// System.out.println(textDataAbertura.getText(0, 7));

		try {
			cc.setDataAbertura(new Data(dia, mes, ano));
		} catch (DataInvalida e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Data Aniversario -----------------------------------

		dia = new Integer(textAniversario.getText(0, 2));
		mes = new Integer(textAniversario.getText(3, 2));
		ano = new Integer(textAniversario.getText(6, 4));

		// System.out.println(dia + "/" + mes + "/" + ano);
		// System.out.println(textDataAbertura.getText(0, 7));

		try {
			cc.setDataAniversario(new Data(dia, mes, ano));
		} catch (DataInvalida e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Numero conta------------------------------------------------
		cc.setNumero(new Integer(textNumeroConta.getText()));

		// Saldo--------------------------------------
		double saldo;
		Integer sald = new Integer(textSaldo.getText());
		saldo = (double) sald;
		cc.setSaldo(saldo);

		cc.setTipo(TipoContas.CONTA_POUPANCA);

	}

	private void passaDadosContaCartao(ContaCartaoCredito cc)
			throws NumberFormatException, BadLocationException {

		// Data abertura -----------------------------------
		Integer dia, mes = null, ano = null;

		dia = new Integer(textDataAbertura.getText(0, 2));
		mes = new Integer(textDataAbertura.getText(3, 2));
		ano = new Integer(textDataAbertura.getText(6, 4));

		// System.out.println(dia + "/" + mes + "/" + ano);
		// System.out.println(textDataAbertura.getText(0, 7));

		try {
			cc.setDataAbertura(new Data(dia, mes, ano));
		} catch (DataInvalida e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Numero conta------------------------------------------------
		cc.setNumero(new Integer(textNumeroConta.getText()));

		// Saldo--------------------------------------
		double saldo;
		Integer sald = new Integer(textSaldo.getText());
		saldo = (double) sald;
		cc.setSaldo(saldo);

		cc.setTipo(TipoContas.CONTA_CARTAO);

	}

	// Criar Numero da conta----------------

	private int criarNumeroDaConta(TipoContas c) {

		int num = 0;
		int nAgencia, nConta, nTipo = 1;

		nAgencia = Teste.getAgenciaIntMap() * 100000;
		nConta = Teste.getBancoGNB().getAgencias()
				.get(Teste.getAgenciaIntMap()).getContas().size() * 10;

		switch (c) {
		case CONTA_CORRENTE:
			nTipo = 1;
			break;

		case CONTA_POUPANCA:
			nTipo = 2;
			break;

		case CONTA_CARTAO:
			nTipo = 3;
			break;

		}

		num = nAgencia + nConta + nTipo;

		// System.out.println(num);

		return num;
	}

	// Chama novamente o painel da Agencia com as
	// Contas-----------------------------------

	private void chamarPainelDeContas() {
		// TODO Auto-generated method stub

		Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap())
				.instaciarPaineis();
		// // Limpa janela e adiciona outra tela
		Teste.janela.getContentPane().removeAll();
		Teste.janela.getContentPane().add(
				Teste.getBancoGNB().getAgencias().get(Teste.getAgenciaIntMap())
						.getPainelTabbed().getPainelCompleto());
		Teste.janela.getContentPane().revalidate();

	}
}