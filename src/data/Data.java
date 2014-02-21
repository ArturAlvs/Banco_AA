package data;

import java.io.Serializable;


public class Data implements Serializable{

	private int dia;
	private int mes;
	private int ano;

	public Data(int dia, int mes, int ano) throws DataInvalida {
		this.setAno(ano);
		this.setMes(mes);
		this.setDia(dia);
	}

	@Override
	public String toString(){
		String dia = "";
		String mes = "";
		String data = "";

		if (this.getDia() < 10) {
			dia = "0" + this.getDia();
		}
		if (this.getMes() < 10) {

			mes = "0" + this.getMes();		
		}

		data = dia + "/" + mes + "/" + this.getAno() ;

		return data;
	}



	public int getDia() {
		return dia;
	}

	public void setDia(int dia) throws DataInvalida{
		//se mes diferente de fevereiro

		int[] meses = new int[12];
		meses[0]=31;
		for (int j = 1; j < meses.length; j++) {
			if ( meses[j-1] == 30 || j==7) {
				meses[j]=31;
			}else{
				meses[j]=30;
			}			
		}	
		meses[1]=28;

		//caso nao seja fevereiro
		if(this.getMes() != 2 && this.getMes() > 0){
			if(dia<=meses[this.getMes()-1] && dia > 0)
				this.dia = dia;
			else
				throw new DataInvalida();
		}

		//caso seja fevereiro
		else{
			boolean bol = false;

			//anos multiplos de 4 q nao sao multiplos de 100 sao bissestos
			if(this.getAno() % 4 == 0 && this.getAno() % 100 != 0){
				bol = true;
			}
			//anos maiores q 2000 multiplos de 400 sao bissestos
			if(this.getAno() >= 2000 && this.getAno() % 400 == 0){
				bol = true;
			}

			//se for ano bissesto fevereiro pode ser setado com dia <= 29

				if(dia <= 28)
					this.dia=dia;
				if(dia ==29 && bol)
					this.dia=dia;
				//meses.get(1).setQuantDia(meses.get(1).getQuantDia() + 1);

		}

	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) throws DataInvalida{
		if(mes >= 1 && mes <= 12)
			this.mes = mes;
		else
			throw new DataInvalida();
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) throws DataInvalida {
		if(ano>0)
			this.ano = ano;
		else
			throw new DataInvalida();
	}



}