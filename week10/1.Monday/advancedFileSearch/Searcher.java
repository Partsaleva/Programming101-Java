package advancedFileSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Searcher{
	Memory m;

	public Searcher(Memory m) {
		this.m=m;
	}
	
	
	public void search(File srcFolder, String text) throws FileNotFoundException, IOException, InterruptedException{
		File[] files=srcFolder.listFiles();	
		for (File file : files) {
			if (file.isFile()) {	
				Search s=new Search(m, file, text);
				Thread tr=new Thread(s);
				tr.start();
				tr.join();
			} else if(file.isDirectory()){
				search(file, text);
			}
		}
	}

			

}
