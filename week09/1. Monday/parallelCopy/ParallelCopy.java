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
		if(srcFolder.isDirectory()){
			if(!destFolder.exists()){
				destFolder.mkdir();
			}
		}
		File[] files=srcFolder.listFiles();
        if (command.equals("-s")) {
			for (int i = 0; i < files.length; i++) {
				Thread tr1=new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
					}
				});
			}
		}
		else{
			for (File file: files){
				if (file.isFile()){
					copyFile(file.toPath(),destFolder.toPath());
				}
				else if(file.isDirectory()){
					File p=new File(destFolder+"/"+file.getName().toString());
					copyFolder(command,file, p);
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
	
	private static boolean isSmall(final File file){
		return file.length() < 7000000;		
	}
	

}
