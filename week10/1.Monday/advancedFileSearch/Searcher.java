package advancedFileSearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Searcher implements Runnable{
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
				search(file, text);
			}
		}
	}

			
	@Override
	public void run() {
		File file=new File("/home/partsaleva/Documents");
		String text="HashMap";
		try {
			search(file, text);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
