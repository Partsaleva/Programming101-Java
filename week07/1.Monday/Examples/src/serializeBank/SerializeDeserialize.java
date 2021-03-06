package serializeBank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class SerializeDeserialize {

	public void serialize(BankAccount account) throws IOException{
		 		
		 FileOutputStream fileOut =new FileOutputStream("accounts.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(account);
         out.close();
         fileOut.close();
	}
	
	public ArrayList<BankAccount> deserialize() throws IOException, ClassNotFoundException{
		
		FileInputStream fileIn = new FileInputStream("accounts.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        @SuppressWarnings("unchecked")
		ArrayList<BankAccount> acc= (ArrayList<BankAccount>)in.readObject();
        in.close();
        fileIn.close();
		return acc;
	}
}
