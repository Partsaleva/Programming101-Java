package managers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class DatabaseManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Map<String, Integer> db=loadProducts();

	public Map<String, Integer> loadProducts() {
		Map<String, Integer> prod=new HashMap<>();
		
		try(BufferedReader reader=new BufferedReader(new FileReader("products.txt"))){
			String line=null;
			int headerLine=-1;
			while((line=reader.readLine())!=null){
				String[] parts=line.split(",");
				headerLine++;
				if(headerLine>0){
					int quantity= Integer.parseInt(parts[3]);
					prod.put(parts[1],quantity);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
		return prod;
	}

	public Map<String, Integer> getDb() {
		return db;
	}
	
	
}