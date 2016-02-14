package monday.ShopInventory;

import monday.vatTaxCalc.NotSupportedCountryException;
import monday.vatTaxCalc.VatTaxCalculator;

public class Product {

	public static void main(String[] args) {
		//test
		try {
			Product p=new Product(1, "beer", 23. ,"uk",3);
			double a=p.getPriceAfter();
			System.out.println(a);
		} catch (NotSupportedCountryException e) {
			System.err.println(e.getMessage());
		}

	}
	private int mProductId;
	private String mName;
	private double mPriceBefore;
	private double mPriceAfter;
	private String mCountry;
	private int mQuantity;
	private VatTaxCalculator calc=new VatTaxCalculator();
	
	public Product(int productId, String name, double priceBefore, String country, int quantity) throws NotSupportedCountryException{
		mProductId=productId;
		mName=name;
		mPriceBefore=priceBefore;
		mPriceAfter=calc.CalculateTax(country, priceBefore);
		mCountry=country;
		setQuantity(quantity);
	}

	public int getProductId() {
		return mProductId;
	}

	public String getName() {
		return mName;
	}

	public double getPriceBefore() {
		return mPriceBefore;
	}

	public double getPriceAfter() {
		return mPriceAfter;
	}

	public String getCountry() {
		return mCountry;
	}

	public int getQuantity() {
		return mQuantity;
	}

	public void setQuantity(int quantity){
		this.mQuantity=quantity;
	}

}
