package advancedFileSearch;

import java.io.File;
import java.io.IOException;

public class AdvancedFileSearch {

	public static void main(String[] args) {
		Memory memory=new Memory(50);
		Searcher searcher=new Searcher(memory);	
		
		File file=new File("/home/partsaleva/Documents");
		String text="HashMap";
	
		try {
			searcher.search(file, text);
			System.out.println(memory.get());
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

}
