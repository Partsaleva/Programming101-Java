package fixSubtitles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FixSubtitles {

	public static void main(String[] args) {
		try {
			FixSubtitles fs=new FixSubtitles();
			Path p=Paths.get("lost.s04e11.hdtv.xvid-2hd.srt");
			fs.fixEncoding(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fixEncoding(Path path) throws IOException{
		try (
		      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile()), "windows-1251"));
		      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("str-result"), "UTF-8")); ) {
		          char[] buffer = new char[16384];
		          int read;
		          while ((read = br.read(buffer)) != -1)
		              bw.write(buffer, 0, read);
			    } 
	}
	
}
