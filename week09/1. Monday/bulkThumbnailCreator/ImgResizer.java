package bulkThumbnailCreator;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

public class ImgResizer extends Thread{
	public static void main(String[] args) {		
		ImgResizer tr1=new ImgResizer();
		tr1.setDaemon(true);
		tr1.run();
		
	}
	
	   private void resizeAndStore(String command,String directoryN,int width,int height) throws IOException, InterruptedException{
	        File directory = new File(directoryN);
	        //get all the files from a directory
	        File[] fList = directory.listFiles();
	        //create thumbnails directory
	        createThumbnailsDirectory(Paths.get(directoryN));
	        
	       for (File file : fList){
	            if (file.isFile() ){
	                 System.out.println(file.getName());
	            	//if file is picture resize and make copy
	                if (isPicture(file)) {
	                	Thread tr1=new Thread(new Runnable() {		
							@Override
							public void run() {
								try {
									resize(Paths.get(file.getPath()),width,height);
								} catch (IOException e) {
									e.printStackTrace();
								}								
							}
						});
	                	tr1.start();
		            	tr1.join();
					}
	        		
	            }
	            //if is directory and we want to do the same for subfolders 
	            else if(file.isDirectory() && command=="-r" && !file.getName().equals("thumbnails") ){
	            	System.out.println(file.getName());
	            	Thread tr2=new Thread(new Runnable() {			
						@Override
						public void run() {
							try {
								createThumbnailsDirectory(Paths.get(file.getAbsolutePath()));
							} catch (IOException e) {
								e.printStackTrace();
							}
							
						}
					});
	            	tr2.start();
	            	tr2.join();
	            	resizeAndStore(command,file.getAbsolutePath(),width,height);
	            }
	        }
	    }
	 //check if file name ends with jpg or png (we can add more)  
	private boolean isPicture(File file){
		return file.toString().toLowerCase().endsWith("jpg") || 
				file.toString().toLowerCase().endsWith("png") ;
	} 
	
	//resize and write resized file
	private void resize(Path path, int width,int height) throws IOException{
		BufferedImage original=ImageIO.read(new File(path.toString()));
		int type = original.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : original.getType();
		
		BufferedImage resized = new BufferedImage(width, height, type);
		Graphics2D g = resized.createGraphics();
		g.drawImage(original, 0, 0, width, height, null);
		g.dispose();
		File f=moveFile(path);
		ImageIO.write(resized, "jpg", f);	
	}
	
	//add subfolder for the smaller picture copies
	private void createThumbnailsDirectory(Path path) throws IOException{				
			Path thumbnailsDir = Paths.get(path.toString(), "thumbnails");
			Files.createDirectories(thumbnailsDir);
	}	
	
	//helper function to save resized file to thumbnail folder
	private File moveFile(Path path){
		File file=path.toFile();
		String p=file.getParent();
		String[] fileName=file.getName().split("\\.");
		return new File(p+"/thumbnails/"+fileName[0]+"_resized."+fileName[1]);
	
	}

	@Override
	public void run() {
		try {
			resizeAndStore("-r","/home/partsaleva/Documents",150,150);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
