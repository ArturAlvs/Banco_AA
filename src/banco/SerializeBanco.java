package banco;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class SerializeBanco {

	
	public static void SerealizeBanco (String arq, Banco banco) {  
        FileOutputStream fos;  
        ObjectOutputStream oos;  
          
        try {  
            fos = new FileOutputStream(arq);  
            oos = new ObjectOutputStream(fos);  
            oos.writeObject((Banco) banco);  
        } catch (IOException e) {  
              
            e.printStackTrace();  
        }  
          
    }  
      
    public static Banco DesSerealizeBanco(String arq) {  
          
        InputStream is;  
        ObjectInputStream ois;  
        Banco banco = null;  
        try {  
            is = new FileInputStream(arq);  
            ois = new ObjectInputStream(is);  
            banco =  (Banco) ois.readObject();  
            return banco;  
              
        } catch (IOException e) {  
              
            e.printStackTrace();  
        }catch (ClassNotFoundException e) {  
              
            e.printStackTrace();  
                  
        }  
        return null;  
    }  
	
}
