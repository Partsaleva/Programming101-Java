package theOne;

 public class Pixel {

	private double r, g, b;
	String pixel;
	
	public Pixel(double r, double g, double b){
		this.setR(r); this.setG(g); this.setB(b);
		pixel="("+r+","+g+","+b+")";
	}
	
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	public double getG() {
		return g;
	}
	public void setG(double g) {
		this.g = g;
	}
}
