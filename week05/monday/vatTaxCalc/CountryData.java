package monday.vatTaxCalc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryData {

	public static void main(String[] args) {
		//test
		CountryData d=new CountryData();
		d.print();
		System.out.println(d.createHashMap());

	}

	List<Country> db;
	Map<String, Double> map;
//	Country mCountry;
	public CountryData() {
		fill();
	}
	
	private void fill(){
		db=new ArrayList<>();
		db.add(new Country("bgn", "Bulgaria", .2, true));
		db.add(new Country("uk","United Kingdom", .21, false));
		db.add(new Country("aus", "Austria", .19, false));
		db.add(new Country("du", "Germany", .18, false));
	}
	

	public Map <String,Double> createHashMap(){
		map=new HashMap<>();
		for(Country t:db){
			map.put(t.getCountryId(), t.getVATTax());
		}
		return map;		
	}
	
	public Country getDefaultCountry(){
		CountryData db=new CountryData();
		for(Country c:db.db){
			if(c.getIsDefault()){
				return c;
			}
		}
		return null;
	}
	
	private void print(){
		for(Country c:db){
			System.out.println(c.toString());
		}
	}
	
	
	
}
