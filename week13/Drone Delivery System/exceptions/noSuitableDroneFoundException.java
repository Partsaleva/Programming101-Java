package exceptions;

public class noSuitableDroneFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public noSuitableDroneFoundException(String msg){
		super(msg);
	}

}
