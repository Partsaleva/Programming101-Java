package wcCommand;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class WordCountResult {

	public static void main(String[] args) {
		WordCountResult res=new WordCountResult();

		File dir = new File(".");
		File f;
		try {
			f = new File(dir.getCanonicalPath() + File.separator + "test.properties");
			System.out.println(res.wordCount(f).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private int charachters=0;
	private int words=0;
	private int lines=0;
	
	public WordCountResult(){}
	
	
	WordCountResult wordCount(Path path) throws FileNotFoundException, IOException{
		return wordCount(path.toFile());
	}
	
	WordCountResult wordCount(File file) throws FileNotFoundException, IOException{	
		WordCountResult result=new WordCountResult();
		try(BufferedReader buff=new BufferedReader(new FileReader(file))){
			String line=null;
			while((line=buff.readLine())!=null){
				lines++;
				words+=countWords(line);				
			}
			
		}
		
		result.setLines(lines);
		result.setWords(words);
		result.setCharachters(charachters);
		return result;
	}
	
	int countWords(String line){
		String[] parts=line.split(" ");
		for(String s:parts){
			charachters+=countChars(s);
		}		
		return parts.length;
	}
	
	int countChars(String word){
		return word.length();
	}
	public int getCharachters() {
		return charachters;
	}
	public void setCharachters(int charachters) {
		this.charachters = charachters;
	}
	public int getWords() {
		return words;
	}
	public void setWords(int words) {
		this.words = words;
	}
	public int getLines() {
		return lines;
	}
	public void setLines(int lines) {
		this.lines = lines;
	}
	

	@Override
	public String toString() {
		return "WordCountResult [charachters=" + charachters + ", words=" + words + ", lines=" + lines + "]";
	}
}
