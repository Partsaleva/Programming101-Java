package monday.ShopInventory;

public class Inventory {

	public static void main(String[] args) {
		Storage storage=new Storage();
		Inventory inv=new Inventory(storage);
		System.out.println(inv.audit());
		try {
			System.out.println(inv.RequestOrder(new Order(1,10)));
			System.out.println(inv.RequestOrder(new Order(2,10)));
			//System.out.println(inv.RequestOrder(new Order(1,10)));
		} catch (NotAvailableInInventoryException e) {
			System.err.println("NotAvailableInInventoryException "+e.getMessage());
		}

	}

	Storage storage=new Storage();
	public Inventory(Storage storage){
		this.storage=storage;
	}
	
	public double audit(){
		double sum=0;
		for(Product p:storage.getProducts()){
			sum+=p.getPriceAfter();
		}
		return sum;
	}
	
	public double RequestOrder(Order order) throws NotAvailableInInventoryException{
		double sum=0;
		for(Product p:storage.getProducts()){
			if(p.getProductId()==order.getmProductId()){
				if(p.getQuantity()<order.getmQuantity()){
					throw new NotAvailableInInventoryException("Product not available");
				}
				sum=p.getPriceAfter()*order.getmQuantity();
				p.setQuantity(p.getQuantity()-order.getmQuantity());
			}
		}
		return sum;
	}
}
