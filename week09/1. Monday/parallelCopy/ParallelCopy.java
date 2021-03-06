package parallelCopy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class ParallelCopy {

	public static void main(String[] args) {
		ParallelCopy p=new ParallelCopy();
		try {
			p.copyFilesAndFolders("",new File("/home/partsaleva/Documents"),new File("/home/partsaleva/Documents_copy"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
//TODO fix dest folder 
	}

	private List<Path> smallFiles=new ArrayList<>();
	private List<Path> bigFiles=new ArrayList<>();
	
	public void copyFilesAndFolders(String command,File srcFolder, File destFolder) throws IOException, InterruptedException{
		copy(command,srcFolder,destFolder);
		if (command.equals("-s")) {
			createThreads(destFolder.toPath());
		}		
	}
	
	public void copy(String command,File srcFolder, File destFolder) throws IOException, InterruptedException{
		if(srcFolder.isDirectory()){
			if(!destFolder.exists()){
				destFolder.mkdir();
			}
		}
		File[] files=srcFolder.listFiles();
        
		for (File file: files){
			if (file.isFile()){
				if (command.equals("-s")) {
					splitFilesBySize(file);
				}
				else{
					copyFile(file.toPath(),destFolder.toPath());
				}
			}
			else if(file.isDirectory()){
				File p=new File(destFolder+"/"+file.getName().toString());
				copy(command,file, p);
			}
		}
		
	}
	
	private void copyFile(Path path, Path dest) throws IOException{		
		File f= new File(dest.toString()+"/"+path.getFileName());
		if (!f.exists()) {
			Files.copy(path, f.toPath());
		}		
	}
	
	private  boolean isSmall(final File file){
		return file.length() < 70000;		
	}
	
	private void splitFilesBySize(File file){
		if (isSmall(file)) {
			smallFiles.add(file.toPath());
		} else {
			bigFiles.add(file.toPath());
		}
	}

	private void createThreads(Path dest) throws InterruptedException{
		System.out.println(bigFiles.size());
		System.out.println(smallFiles.size());
		for (Path path : bigFiles) {
			Thread tr=new Thread(new Runnable() {				
				@Override
				public void run() {
					try {
						copyFile(path, dest);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			});
			tr.start();
			tr.join();
		}
		
		
		Thread tr2=new Thread(new Runnable() {				
			@Override
			public void run() {
				try {
					for (Path path : smallFiles) {
						copyFile(path, dest);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
			
			tr2.start();
			tr2.join();
			
		
		
	}
}
