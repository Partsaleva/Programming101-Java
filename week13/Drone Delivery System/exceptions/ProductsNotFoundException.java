package exceptions;

public class ProductsNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductsNotFoundException(String msg){
		super(msg);
	}
}
