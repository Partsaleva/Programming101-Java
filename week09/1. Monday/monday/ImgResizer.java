package monday;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImgResizer {
	// /home/partsaleva/Documents/img.jpg
	
	private static File resize(File src, int width,int height) throws IOException{
		BufferedImage original=ImageIO.read(new File(src.getAbsolutePath()));
		int type = original.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : original.getType();
		
		BufferedImage resized = new BufferedImage(width, height, type);
		Graphics2D g = resized.createGraphics();
		g.drawImage(original, 0, 0, width, height, null);
		g.dispose();
		File f=new File(resized + ".jpg");
		ImageIO.write(resized, "jpg", f);	
		return f;
	}
	
	private static String createThumbnailsDirectory(File file){			
			String parent = file.getParent();		
			String result = parent+ "/thumbnails";
			
			new File(result).mkdirs();
			return result;
	}	
	
	private static void moveFile(File file){
		//TODO
	}
	 public static void resizeAndStore(File src, int width,int height){
		Thread tr1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					resize(src, width,height);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		Thread tr2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				createThumbnailsDirectory(src);				
			}
		});
		
		
	}
}
