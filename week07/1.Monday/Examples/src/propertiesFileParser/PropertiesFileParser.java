package propertiesFileParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesFileParser {

	public static void main(String[] args) {
		PropertiesFileParser p=new PropertiesFileParser();
		try {
			System.out.println(p.parseProperties("test.properties"));
			System.out.println(p.removeComment("abv #abv"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	Map<String, String> mParseProperties;
	
	public PropertiesFileParser(){}

	Map<String, String> parseProperties(String aFileName) throws IOException{
		Path path = Paths.get(aFileName);
		mParseProperties=new HashMap<>();
		try(BufferedReader buf=Files.newBufferedReader(path)){
			 Properties properties = new Properties();
				properties.load(buf);

				Enumeration<Object> enuKeys = properties.keys();
				while (enuKeys.hasMoreElements()) {
					String key = (String) enuKeys.nextElement();
					String value = properties.getProperty(key);
					value=removeComment(value);
					mParseProperties.put(key, value);
					//System.out.println(key + ": " + value);
				}
		}
		return mParseProperties;
	}
	
	String removeComment(String str){
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i)=='#'){
				return str.substring(0, i);
			}
		}
		return str;
	}
}
