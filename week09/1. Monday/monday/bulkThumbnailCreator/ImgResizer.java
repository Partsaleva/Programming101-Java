package monday.bulkThumbnailCreator;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

public class ImgResizer {
	public static void main(String[] args) {
		//Path p=Paths.get("/home/partsaleva/Documents/img.jpg");
		try {
			resizeAndStore("-r","/home/partsaleva/Documents",150,150);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}
	// /home/partsaleva/Documents/img.jpg
	
	   public static void resizeAndStore(String command,String directoryName,int width,int height) throws IOException{
	        File directory = new File(directoryName);
	        //get all the files from a directory
	        File[] fList = directory.listFiles();
	        createThumbnailsDirectory(Paths.get(directoryName));
	       for (File file : fList){
	            if (file.isFile() ){
	                System.out.println(file.getName());
	            	//resize(Paths.get(file.getPath()),width,height);
					//						
	        			
	        		
	            }
	            else if(file.isDirectory() && command=="-r"){
	            	System.out.println(file.getName());
	        		createThumbnailsDirectory(Paths.get(directoryName+file.getName()));        		
	            	   // resizeAndStore(command,file.getAbsolutePath(),width,height);
	            }
	        }
	    }
	   
	static boolean isPicture(File file){
		String[] fileName=file.getName().split("\\.");
		return fileName[1]=="jpg" || fileName[1]=="png";
	}  
	private static void resize(Path path, int width,int height) throws IOException{
		BufferedImage original=ImageIO.read(new File(path.toString()));
		int type = original.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : original.getType();
		
		BufferedImage resized = new BufferedImage(width, height, type);
		Graphics2D g = resized.createGraphics();
		g.drawImage(original, 0, 0, width, height, null);
		g.dispose();
		File f=moveFile(path);
		ImageIO.write(resized, "jpg", f);	
		//return f;
	}
	
	private static String createThumbnailsDirectory(Path path){			
			
			String result = path+ "/thumbnails";
			
			new File(result).mkdirs();
			return result;
	}	
	
	//helper function to save resized file to thumbnail folder
	private static File moveFile(Path path){
		File file=path.toFile();
		String p=file.getParent();
		String[] fileName=file.getName().split("\\.");
		return new File(p+"/thumbnails/"+fileName[0]+"_resized."+fileName[1]);
	
	}
	
}
