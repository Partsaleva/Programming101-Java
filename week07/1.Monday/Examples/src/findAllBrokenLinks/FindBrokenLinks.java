package findAllBrokenLinks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/*How to detect a bad link? Use Files.isSymbolicLink(path) in order to check if a file is a link,
 *and Files.readSymbolicLink(path) in order to follow it and receive its target's path.*/
public class FindBrokenLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	void findBadLink(Path path,BasicFileAttributes atr) throws IOException  {
		 if (atr.isSymbolicLink()) {       
	         Files.readSymbolicLink(path);
		 }
		 else{
	           System.err.println("Invalid symbolic link");
		 }    
	}
}
