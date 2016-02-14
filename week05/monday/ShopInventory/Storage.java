package monday.ShopInventory;

import java.util.ArrayList;
import java.util.List;

import monday.vatTaxCalc.NotSupportedCountryException;

public class Storage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private List<Product> products;
	
	public Storage(){
		try {
			fill();
		} catch (NotSupportedCountryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void fill() throws NotSupportedCountryException {
		products=new ArrayList<>();
		products.add(new Product(1, "beer", 3.3, "uk", 13));
		products.add(new Product(2, "vodka", 23., "bgn", 99));
		products.add(new Product(3, "whiskey", 43.5, "aus", 107));
		products.add(new Product(4, "tequila", 13.3, "du", 43));
		products.add(new Product(5, "wine", 34., "uk", 23));
		products.add(new Product(6, "gin", 17.3, "bgn", 37));
		
	}
	
	public List<Product> getProducts(){
		return products;
	}
}
