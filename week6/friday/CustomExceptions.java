package friday;


class InvalidNameException extends Exception{
	private static final long serialVersionUID = 1L;
	
	InvalidNameException(){}
	InvalidNameException(String msg){
		super(msg);
	}
}

class InvalidInputException extends Exception{
	private static final long serialVersionUID = 1L;
	
	InvalidInputException(){}
	InvalidInputException(String msg){
		super(msg);
	}
}
