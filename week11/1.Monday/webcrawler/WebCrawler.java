package webcrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

	public static void main(String[] args) throws IOException {
		URL url=new URL("http://www.peter.and.bilyana.net/");
		String text="почивка";	
		search(url, text);
		System.out.println(pagesToVisit);
		System.out.println(pagesVisited);
		

	}

	 private static Set<String> pagesVisited = new HashSet<String>();
	 private static List<String> pagesToVisit = new LinkedList<String>();
	  
	public static void search(URL url, String text) throws IOException{    
		URL currentUrl;	
		while(true){
			if(pagesToVisit.isEmpty()){
	              currentUrl = url;
	              pagesToVisit.addAll(getAllLinks(currentUrl,getText(currentUrl)));
	        }
			else{
	              currentUrl = new URL(nextUrl());
	        }
			if(containText(getText(currentUrl),text)){
	 			System.out.println("FOUND IN " + currentUrl.toString());
			}
			System.out.println(pagesToVisit.size());
			System.out.println(pagesVisited.size());
		}
	}
	
	private static String nextUrl() {
		String nextUrl;	
		nextUrl=pagesToVisit.remove(0);
		pagesVisited.add(nextUrl);
		return nextUrl;
	}

	private static List<String> getAllLinks(URL url, String content) {
		    String regex = "<a.*?href=\"((?!javascript).*?)/\".*?>";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(content);
	        while (matcher.find()) {
	        	String w = matcher.group(1).replace("../", "");
	            if (!pagesToVisit.contains(w)) {            
	            		pagesToVisit.add(w);				
	            }
	        }
	        return pagesToVisit;
    }
	
	private static String getText(URL url) throws IOException{	
		StringBuilder b=new StringBuilder();
        try(BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))){
	        String line;
	        while ((line = in.readLine()) != null){
	        	b.append(line);
	        	b.append(System.getProperty("line.separator"));
	        }        
        }
		return b.toString();
	   }
	
	private static boolean containText(String urlText, String text){		
		// System.out.println("Searching for " + "'"+text + "'"+"...");	       
	     return urlText.toLowerCase().contains(text.toLowerCase());
	}
	
	
}
