package serializa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import banco.Banco;

public abstract class Serializa {

	public static void SerBanco(Banco banco){
		
		try {
			FileOutputStream fos = new FileOutputStream("BANCO.SER");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(banco);
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("resource")
	public static Banco deSerealiza(){
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("BANCO.SER");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Banco banco = (Banco)ois.readObject();
			
			return banco;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			
			File ui = new File("BANCO.SER");
			try {
				ui.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//caso nao encontrar o arquivo retorna um banco vazio
		return new Banco("");
		
		
		
	}
	
}
