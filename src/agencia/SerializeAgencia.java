package agencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import banco.Banco;

import conta.Conta;
import conta.ContaCartaoCredito;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import conta.SerealizeConta;

public abstract class SerializeAgencia {

	//falta terminar precisa da funcao do artur
	public static boolean exportarAgenciaPara(String caminho,Agencia agencia){
		
		File file = new File(caminho);
		try {
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			//ainda falta exportar todas as contas da agencia
			bufferedWriter.write(agencia.toString());
			for (Conta c : agencia.getContas().values()) {
				bufferedWriter.write(c.toString());
			}
		
			bufferedWriter.close();
			fileWriter.close();
			
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	//falta terminar precisa da funcao do artur
	public static Agencia importarAgenciaDe(String caminho){
		
		Agencia agencia = new Agencia();
		
		File file = new File(caminho);
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader (fileReader);
			
			String str = bufferedReader.readLine();
			//falta so colocar a agencia para receber os dados lidos
			
			return agencia;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	//funcionando
	public static void toTable(Agencia a){
		
		File file = new File("Agencias.table");
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
			
			bwAux.write(a.toString());
			bwAux.newLine();						
			while(br.ready()){
				String str = br.readLine();
				//pegar o id escrito
				String strAux = "";
				for (int i = 0; str.charAt(i)!=','; i++) {
					strAux+=str.charAt(i);
				}
								
				String str2=""+a.getCodigo();
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
			
			for(Conta c : a.getContas().values()){
				if(c instanceof ContaCorrente)
					SerealizeConta.SerealizeContaCorrente((ContaCorrente) c);
				else if(c instanceof ContaPoupanca)
					SerealizeConta.SerealizeContaPoupanca((ContaPoupanca) c);
				else if(c instanceof ContaCartaoCredito)
					SerealizeConta.serealizeContaCartao(a.getCodigo() , (ContaCartaoCredito) c);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void testeEditaLinha(Agencia a){
		File file = new File("Agencias.table");
		if(!file.exists()){
			try {
				file.createNewFile();
								
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		FileWriter fw;
		try {
			fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String linha = "";
			while(br.ready()){
				
				linha=br.readLine();
				
				String id = "";
				for (int i = 0; linha.charAt(i)!=','; i++) {
					id+=linha.charAt(i);
				}
				
				if(id.equals(a.getCodigo())){
					bw.append(br.readLine(),br.readLine().length(),br.readLine().length());
					bw.append(a.toString());
				}
					
			}
			
			bw.close();
			fw.close();
			
			br.close();
			fr.close();

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void SerealizeAgencia(String arq, Agencia banco) {  
        FileOutputStream fos;  
        ObjectOutputStream oos;  
          
        try {  
            fos = new FileOutputStream(arq);  
            oos = new ObjectOutputStream(fos);  
            oos.writeObject((Agencia) banco);
            
            
            oos.close();
            //fos.close();
            
            
        } catch (IOException e) {  
              
            e.printStackTrace();  
        }  
	
	}
	
	 public static Agencia DesSerealizeAgencia(String arq) {  
         
	        InputStream is;  
	        ObjectInputStream ois;  
	        Agencia banco = null;  
	        try {  
	            is = new FileInputStream(arq);  
	            ois = new ObjectInputStream(is);  
	            banco =  (Agencia) ois.readObject();
	            
	            //ois.close();
	            is.close();
	            
	            
	            return banco;  
	              
	        } catch (IOException e) {  
	              
	            e.printStackTrace();  
	        }catch (ClassNotFoundException e) {  
	              
	            e.printStackTrace();  
	                  
	        }  
	        return null;  
	    }  
	
	
}
