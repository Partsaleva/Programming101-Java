package theOne;
import theOne.Pixel;

public class Matrix implements MatrixOperation{

	//matrix of Pixels
	private Pixel[][] matrix;
	private int M,N;
	
	//constructor
	public Matrix(int M, int N){
		this.M=M; this.N=N;
		matrix=new Pixel[M][N];
	}
	
	//create pixel with random value and return
	public Pixel withPixel(int x, int y, Pixel[][] matrix){
		Pixel px=new Pixel(rand(),rand(),rand());
		matrix[x][y]=px;
		return matrix[x][y];
	}
	
	//fill matrix with pixels
	public Matrix operate(MatrixOperation op){
		Matrix matr=new Matrix(M,N);
		for(int i=0; i< M;i++){
			for(int j=0; j<N; j++){
				matrix[i][j]=op.withPixel(i, j, matrix);
			}
		}
		return matr;
	}
	
	
	public String toString(){
		String str="";
		 for (int i = 0; i < M; i++) {
	            for (int j = 0; j < N; j++) {
	                str+=""+matrix[i][j].pixel;
	            }
	            str+="\n";
		 }
		 return str;
	}
	
	//random value 
	public double rand() {
		double rand=Math.round(Math.random()*1000)/1000.0d;
	    return rand;
	}
	
	public Pixel BrightPixel(int x, int y, double increasingFactor,Pixel[][] m){
		double red =m[x][y].getR()+increasingFactor;
		double green =m[x][y].getG()+increasingFactor;
		double blue = m[x][y].getB()+increasingFactor;
		if (red >= 1) { red = 1; } else if (red < 0) { red = 0; }
        if (green >= 1) {green = 1;} else if (green < 0) {green = 0; }
        if (blue >= 1) {blue = 1;} else if (blue < 0) {blue = 0;}
        red=Math.round(red*1000)/1000.0d;
        green=Math.round(green*1000)/1000.0d;
        blue=Math.round(blue*1000)/1000.0d;
		Pixel px=new Pixel(red,green,blue);
		m[x][y]=px;
		return m[x][y];
	}
	
	//brightness reduce
	public Matrix brightnesReduce(Matrix m,double increasingFactor){
		for(int i=0; i< m.M;i++){
			for(int j=0; j<m.N; j++){	
				
				matrix[i][j]=m.BrightPixel(i, j,increasingFactor,matrix);
			}
		}
		return m;
	}
	
	public Pixel grayPixel(int x, int y, double p,Pixel[][] m){
		p=Math.round(p*1000)/1000.0d;
		Pixel px=new Pixel(p,p,p);
		m[x][y]=px;
		return m[x][y];
	}
	//grayscale
	public Matrix grayscale(Matrix m){
		for(int i=0; i< m.M;i++){
			for(int j=0; j<m.N; j++){	
				Pixel p=matrix[i][j];
				
				double red =p.getR();
				double green = p.getG();
				double blue = p.getB();
				double avg = (red + green + blue)/3;
				
				matrix[i][j]=m.grayPixel(i, j,avg,matrix);
			}
		}
		return m;
	}
	
	public Matrix gaussianBlur(Matrix m){
		Matrix matr=m.operate(m);
		return matr;
	}
}

	
