package data;

public class Data {
	
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia, int mes, int ano) {
		this.setAno(ano);
		this.setMes(mes);
		this.setDia(dia);
	}
	
	@Override
	public String toString(){
		String dia = null;
		String mes = null;
		String data = null;
		
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

	public void setDia(int dia) {
		//se mes diferente de fevereiro
		
		int meses[] = new int[12];			
		meses[0]=31;
		for (int j = 0; j < meses.length; j++) {
		
			if ( meses[j-1] == 30 || j==7) {
				meses[j]=31;
			}else{
				meses[j]=30;
			}			
		}	
		meses[1]=28;

		if(this.getMes() != 2){
			
			if(dia<=meses[this.getMes()-1])
				this.dia = dia;
		}
		
		//caso seja fevereiro
		else{
			boolean bol = false;
			if(this.getAno() % 4 == 0){
				bol = true;
			}
			if(this.getAno() % 100 == 0){
				bol = false;
			}
			
			if(this.getAno() >= 2000 && this.getAno() % 400 == 0){
				bol = false;
			}
			
			if (bol) {
				if(dia <= 29)
					this.setDia(dia);
				//meses.get(1).setQuantDia(meses.get(1).getQuantDia() + 1);
			}
		}
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		if(mes >= 1 && mes <= 12)
			this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		if(ano>0)
			this.ano = ano;
	}
	
	
	
}
