package utilityReadWriteInFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FileUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static FileUtils mInstance;
	private FileUtils(){}

	public static FileUtils getInstance() {
		if (mInstance == null) {
			mInstance = new FileUtils();
		}
		
		return mInstance;
	}
	
	String readFrom(File file) throws IOException  {
		StringBuilder sb=new StringBuilder();
		
		try (BufferedReader buffer=new BufferedReader(new FileReader(file))){					
			String line;			
			while((line = buffer.readLine())!=null){
				sb.append(line);
				sb.append(System.lineSeparator());
			}
		}		
		return sb.toString();
	}
	
	
	String readFrom(Path path) throws IOException{
		return readFrom(path.toFile());
	}
	
	public void writeTo(String contents, File file) throws IOException{
		try(BufferedWriter buf = new BufferedWriter(new FileWriter(file))){
			buf.write(contents);
		}
	}
	
	public void writeTo(String contents, Path path) throws IOException{
		writeTo(contents,path.toFile());
	}
	
}
