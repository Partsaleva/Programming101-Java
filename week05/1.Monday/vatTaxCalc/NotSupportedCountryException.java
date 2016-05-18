package vatTaxCalc;

public class NotSupportedCountryException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotSupportedCountryException(String msg){
		super(msg);
	}
}
