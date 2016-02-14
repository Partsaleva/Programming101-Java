package monday.vatTaxCalc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class VatTaxCalculator {

	public static void main(String[] args) {
		VatTaxCalculator calc=new VatTaxCalculator();
		try{
		System.out.println(calc.CalculateTax("uk", 1));
		System.out.println(calc.CalculateTax(1));
		}catch(NotSupportedCountryException e){
			System.err.println("NotSupportedCountryException"+e.getMessage());
		}

	}

	private double price;
	private CountryData countries;
//	private HashMap<String, Double> map=countries.createHashMap();
	
	public VatTaxCalculator(){
		countries=new CountryData();
	}
	
	public double CalculateTax(String country, double price) throws NotSupportedCountryException{
		Map<String, Double> map=countries.createHashMap();
		Set<?> set=map.entrySet();
		Iterator iter=set.iterator();
		while(iter.hasNext()){
			Map.Entry m = (Map.Entry)iter.next();
			if(m.getKey().equals(country)){
				double tax=(double) m.getValue();
				return price + price* tax;
			}
		}
		throw new NotSupportedCountryException("Country is not supported");
	}
	
	public double CalculateTax(double price){
		double tax=countries.getDefaultCountry().getVATTax();	
		return price + price*tax;
	}
}
