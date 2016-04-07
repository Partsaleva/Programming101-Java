package advancedFileSearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Search implements Runnable{
    Memory m;
	File file;
    String text;
    
    
    
	public Search(Memory m, File file, String text) {
		this.m=m;
		this.file = file;
		this.text = text;
	}



	@Override
	public void run() {
		try(BufferedReader r=new BufferedReader(new FileReader(file))){
			String line=null;
			int count=0;
			List<Integer>pages=new ArrayList<>();
			while((line=r.readLine())!=null){
				count++;
				if (line.contains(text)) {
					pages.add(count);
					m.put(file.getName(), pages);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
