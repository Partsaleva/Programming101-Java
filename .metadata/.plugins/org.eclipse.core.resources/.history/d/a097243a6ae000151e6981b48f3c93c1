package week1;
/*16. Rescale an image using nearest neighbour interpolation
int[][] rescale(int[][] original, int newWidth, int newHeight)
You are given an image original. Rescale it to newWidth, newHeight,
using nearest neighbour interpolation. 
(See http://en.wikipedia.org/wiki/Nearest-neighbor_interpolation)*/

public class Rescale {

	public static void main(String[] args) {
		Rescale img=new Rescale();
		int[][] image={
				{1,2,2,3,3,3},
				{1,2,2,3,3,3},
				{1,2,2,3,3,3},
				{1,2,2,3,3,3},
				{1,2,2,3,3,3},
		};
		img.readArr(img.rescale(image, 10,10));
	}
	
	void readArr(int[][] img)
	{
		for (int i= 0; i<img.length; i++) 
        {            
            for (int j=0;j<img[0].length; j++) 
            {
            	System.out.print(img[i][j]);
            }
            System.out.println();
        }
	}
	
	public int[][] rescale(int[][] original, int newWidth, int newHeight)
	{
		int[][] result = new int[newWidth][newHeight];
		int oldWidth=original[0].length;
	    int oldHeight=original.length;
	    
		int x_ratio = (int)((oldWidth << 16) / newWidth) + 1;
		int y_ratio = (int)((oldHeight << 16) / newHeight) + 1;
	
		int x2, y2;
		for (int i = 0; i < newHeight; i++)
		{
			for (int j = 0; j < newWidth; j++)
			{
				x2 = ((j * x_ratio) >> 16);
				y2 = ((i * y_ratio) >> 16);
				result[i][j]= original[y2][x2];
			}
		}
		
		return result;
	}
}