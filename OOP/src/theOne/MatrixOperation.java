package theOne;

import theOne.Pixel;

public interface MatrixOperation {

	public Pixel withPixel(int x, int y, Pixel[][] matrix);
	public Pixel grayPixel(int x, int y, double p,Pixel[][] m);
	public Pixel BrightPixel(int x, int y, double increasingFactor,Pixel[][] m);
}
