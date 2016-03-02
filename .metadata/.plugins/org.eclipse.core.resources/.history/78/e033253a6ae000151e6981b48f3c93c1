package week1;

/*28. Convert To Greyscale
Implement the following function/method:
convertToGreyscale(imgPath)
Given the path of a color image (.jpg, .png, .bmp)
 create a greyscale version of it and save it.*/
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ConvertToGreyscale {

	public static void main(String[] args) throws IOException {
		ConvertToGreyscale obj=new ConvertToGreyscale();
		File input = new File("Coco.jpg");
	    BufferedImage image = ImageIO.read(input);
	    obj.convertToGreyscale(image);
	    File output = new File("grayscale-" + input.getName());
	    ImageIO.write(image, "jpg", output);

	}
	
	public void convertToGreyscale(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		for(int i=0; i<height; i++){
			
			for(int j=0; j<width; j++){
			
				//get specific 
				int p=image.getRGB(j, i);
				
				int red =  (p>>16)&0xff;
				int green = (p>>8)&0xff;
				int blue = p&0xff;
				//get average
				int avg = (red + green + blue)/3;
				//set red=avg, g=avg, b=avg for grey nuance
				p = avg<<16 | (avg<<8) | avg;
				//replace
				image.setRGB(j,i,p);
			}
		}
		
	}

	

}