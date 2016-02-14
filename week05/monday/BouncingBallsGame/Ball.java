package monday.BouncingBallsGame;



public class Ball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Circle ball;
	private double mDiameter;
	private Point mPositionOfCenter;
	private Color color; 
	private String mDirection;
	private int mSpeed;
	
	Ball(double diam,Color col,String direction, int speed){
		setBall(ball);
		setDiameter(diam);		
		setColor(col);
		setDirection(direction);
		mPositionOfCenter=ball.getCenter();
		setSpeed(speed);
	}


	public void setBall(Circle ball) {
		this.ball = ball;
	}

	public double getDiameter() {
		return mDiameter;
	}

	public void setDiameter(double diameter) {
		this.mDiameter = ball.getRadius() * 2;
	}

	public Point getPositionOfCenter() {
		return ball.getCenter();
	}


	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getDirection() {
		return mDirection;
	}
    //TODO
	public void setDirection(String direction) {
		this.mDirection=direction;
	}

	public int getSpeed() {
		return mSpeed;
	}

	public void setSpeed(int speed) {
		this.mSpeed = speed;
	}
	
	
	public void move(){
		
	}
}
