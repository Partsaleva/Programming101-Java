package parallelCopy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class ParallelCopy {

	public static void main(String[] args) {
		try {
			copyFolder("",new File("/home/partsaleva/Documents"),new File("/home/partsaleva/Documents_copy"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void copyFolder(String command, File srcFolder, File destFolder) throws IOException{
		createFolder(srcFolder, destFolder);
		File[] files=srcFolder.listFiles();
        if (command.equals("-s")) {
			
		}
		else{
			for (File file: files) {
				if (file.isFile()) {
					copyFile(file.toPath(),destFolder.toPath());
				}
				else if(file.isDirectory() && !file.getName().equals(destFolder.getName()) ){
					System.out.println(file.toPath().toString());
					System.out.println(destFolder.toPath().toString());
					createFolder(file, destFolder);
					copyFolder(command, file, destFolder);
					
				}
			}
		}
	}
	
	private static void copyFile(Path path, Path dest) throws IOException{		
		File f= new File(dest.toString()+"/"+path.getFileName());
		if (!f.exists()) {
			Files.copy(path, f.toPath());
		}		
	}
	
	private static void createFolder(File srcFolder, File destFolder){
			if(!destFolder.exists()){
				destFolder.mkdir();
				System.out.println("Maded destination folder: "+destFolder.getName());
			}
		
	}
	private boolean isSmall(final File file){
		return file.length() < 7000000;		
	}
	

}
