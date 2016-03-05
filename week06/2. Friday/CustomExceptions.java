
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

class ForbidenWithdrawException extends Exception{
	
	private static final long serialVersionUID = 1L;
	ForbidenWithdrawException(){}
	ForbidenWithdrawException(String msg){
		super(msg);
	}
}

class InsufficientFundsException extends Exception{
	private static final long serialVersionUID = 1L;
	InsufficientFundsException(){}
	InsufficientFundsException(String msg){
		super(msg);
	}
}
class NonExistingBankAccountException extends Exception{
	private static final long serialVersionUID = 1L;
	NonExistingBankAccountException(){}
	NonExistingBankAccountException(String msg){
		super(msg);
	}
}