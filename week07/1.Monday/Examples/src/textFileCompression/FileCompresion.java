package textFileCompression;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileCompresion {

	public static void main(String[] args) {
		FileCompresion fileComp= new FileCompresion();
		File f=new File("comprTest");
		File decF=new File("comprTest_compr");
		try {
			fileComp.compress(f);
			fileComp.decompress(decF);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private Map<String, Integer> map=new HashMap<>();
	private List<String> list=new ArrayList<>();
	
	
	void compress(File file) throws IOException{
		int counter=-1;
		try(
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getName()+"_compr")))){
			  String line;
	          while ((line = in.readLine()) != null){
	        	  String[] words=line.split(" ");
	        	  for(String word:words){	 
	        		  if (!map.containsKey(word)){
	        			  counter++;
	        			  map.put(word,counter);
	        			  list.add(word);
	        		  }
	        		  out.write("~"+map.get(word)+" ");
	        	  }
	          }
		}
	}
	
	void compress(Path path) throws IOException{
		compress(path.toFile());
	}

	
	void decompress(File file) throws IOException{
		try(
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getName()+"_decompr")))){
				  String line;
		          while ((line = in.readLine()) != null){
		        	  String[] words=line.split(" ");
		        	  for(String word:words){	 
		        		 String n=word.substring(1);
		        		 out.write(list.get(Integer.parseInt(n))+" ");
		        	  }
		          }
			}
}
	void decompress(Path path) throws IOException{
		decompress(path.toFile());
	}
}
