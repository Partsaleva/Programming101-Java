package advancedFileSearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class Searcher {
	File folder;
	Memory m;
	
	public Searcher(Memory m) {
		this.m=m;
	}
	
	private void search(File srcFolder, String text) throws FileNotFoundException, IOException, InterruptedException{
		File[] files=srcFolder.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				try(BufferedReader r=new BufferedReader(new FileReader(file))){
					String line=null;
					int count=0;
					while((line=r.readLine())!=null){
						count++;
						if (line.contains(text)) {
							m.put(file.getName(), count);
						}
					}
				}
				
				
			} else if(file.isDirectory()){

			}
		}
	}
}
