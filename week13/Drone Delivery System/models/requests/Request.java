package models.requests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Request {

	 public void log(String str){
		try(BufferedWriter writer=new BufferedWriter(
				new FileWriter("requests", true))){		
			
			writer.write(str);
			writer.write(System.getProperty("line.separator"));	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(str);
	}
}
