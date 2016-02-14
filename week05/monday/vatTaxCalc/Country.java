package monday.vatTaxCalc;

public class Country {

	public static void main(String[] args) {
		// test
		Country c=new Country("bgn", "Bulgaria", .2, true);
		System.out.println(c);

	}
	
	private String mCountryId;
	private String mName;
	private double mVATTax;
	private boolean mIsDefault;
	
	public Country(String countryId, String name,double VATTax,boolean IsDefault){
		mCountryId=countryId;
		mName=name;
		mVATTax=VATTax;
		mIsDefault=IsDefault;
	}
	public String getCountryId() {
		return mCountryId;
	}
	public String getName() {
		return mName;
	}
	public double getVATTax() {
		return mVATTax;
	}

	public boolean getIsDefault(){
		return mIsDefault;
	}
	
	public String toString(){
		return new String(getCountryId()+ ", "+getName()+ ", "+getIsDefault()+ ", "+getVATTax());
	}
}
