package monday.BouncingBallsGame;

public class Direction {

	private Point p;

	Direction(){
	}

	Point left(){
		return new Point(p.getX() - 1, p.getY());
	}
	Point right(){
		return new Point(p.getX() + 1, p.getY());
	}
	Point down(){
		return new Point(p.getX(), p.getY() - 1);
	}
	Point up(){
		return new Point(p.getX(), p.getY() + 1);
	}
	Point leftUp(){
		return new Point(p.getX()-1 ,p.getY()+1);
	}
	Point leftDown(){
		return new Point(p.getX() - 1, p.getY() -1);
	}
	Point rightUp(){
		return new Point(p.getX()+1,p.getY()+1);
	}
	Point rightDown(){
		return new Point(p.getX()+1,p.getY()-1);
	}
	
}
