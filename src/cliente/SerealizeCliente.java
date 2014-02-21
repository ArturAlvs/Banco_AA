package cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class SerealizeCliente {
	
	public static void toTable(PessoaFisica pf){
		File file = new File("PessoasFisicas.table");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		//arquivo auxiliar
		File fileAux = new File("aux");
		try {
			
			//lendo dados da tabela e salvando em arquivo auxiliar
			FileWriter fwAux = new FileWriter(fileAux);
			BufferedWriter bwAux = new BufferedWriter(fwAux);
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			bwAux.write(pf.toString());
			bwAux.newLine();						
			while(br.ready()){
				String str = br.readLine();
				//pegar o cpf escrito
				String strAux = "";
				for (int i = 0; str.charAt(i)!=','; i++) {
					strAux+=str.charAt(i);
				}
								
				String str2=""+pf.getCpf();
				if(!strAux.equals(str2)){
					bwAux.write(str);
					bwAux.newLine();
				}
			}
			bwAux.close();
			fwAux.close();
			
			fr.close();
			br.close();
			
			//lendo dados do arquivo auxiliar e salvando na tabela
			FileReader frAux = new FileReader(fileAux);
			BufferedReader brAux = new BufferedReader(frAux);
			
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			while(brAux.ready()){
				String str = brAux.readLine();				
				bw.write(str);
				bw.newLine();
			}
			bw.close();
			fw.close();
			
			brAux.close();
			frAux.close();			
			
			fileAux.delete();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void toTable(PessoaJuridica pj){
		File file = new File("PessoasJuridicas.table");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		//arquivo auxiliar
		File fileAux = new File("aux");
		try {
			
			//lendo dados da tabela e salvando em arquivo auxiliar
			FileWriter fwAux = new FileWriter(fileAux);
			BufferedWriter bwAux = new BufferedWriter(fwAux);
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			bwAux.write(pj.toString());
			bwAux.newLine();						
			while(br.ready()){
				String str = br.readLine();
				//pegar o cnpj escrito
				String strAux = "";
				for (int i = 0; str.charAt(i)!=','; i++) {
					strAux+=str.charAt(i);
				}
								
				String str2=""+pj.getCnpj();
				if(!strAux.equals(str2)){
					bwAux.write(str);
					bwAux.newLine();
				}
			}
			bwAux.close();
			fwAux.close();
			
			fr.close();
			br.close();
			
			//lendo dados do arquivo auxiliar e salvando na tabela
			FileReader frAux = new FileReader(fileAux);
			BufferedReader brAux = new BufferedReader(frAux);
			
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			while(brAux.ready()){
				String str = brAux.readLine();				
				bw.write(str);
				bw.newLine();
			}
			bw.close();
			fw.close();
			
			brAux.close();
			frAux.close();			
			
			fileAux.delete();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
