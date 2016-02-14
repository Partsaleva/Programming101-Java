package monday.ShopInventory;

import java.util.Map;

public class Order {

	public static void main(String[] args) {
		
	}
	
	private int mProductId;
	private int mQuantity;
	//private Map<Integer,Integer>order;
	
	public Order(int productId, int quantity){
		mProductId=productId;
		mQuantity=quantity;
	}

	public int getmProductId() {
		return mProductId;
	}

	public int getmQuantity() {
		return mQuantity;
	}
	
}
