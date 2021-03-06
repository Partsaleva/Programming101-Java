package fileDownloader;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DownloadFileWithJava {

	public static void main(String[] args) throws IOException {
		String dest=("/home/partsaleva/Projects/java101/week11/1.Monday/fileDownloader/");
		URL url=new URL("https://scontent.xx.fbcdn.net/hphotos-xfa1/v/t1.0-9/1917827_10205904952002682_475235360923825659_n.jpg?oh=ce2d1f6ff5143ee8f05aecce1db39255&oe=5774D4C1");
		downloadFile(url, dest);

	}

	public static Path downloadFile(URL url, String targetFolder) throws IOException{		
		String name=url.getFile();
		String[] parts=name.split("/");
		String nameOfFile=parts[parts.length-1];
		
		Path destFolder=new File(targetFolder+nameOfFile).toPath();
		
		Files.copy(url.openStream(), destFolder, StandardCopyOption.REPLACE_EXISTING);
		
		return destFolder;	
	}
}
