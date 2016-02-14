package monday.ShopInventory;

public class NotAvailableInInventoryException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotAvailableInInventoryException(String msg){
		super(msg);
	}
}
