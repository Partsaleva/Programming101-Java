package webcrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

	public static void main(String[] args) throws IOException {
		URL url=new URL("http://www.kolonkata.info/search/label/%D0%91%D0%B5%D0%B7%D0%BF%D0%BB%D0%B0%D1%82%D0%BD%D0%BE");
		String text="16 април";
		String webText=getText(url);
		System.out.println(webText);
		search(url, text);
		System.out.println(pagesToVisit);
		

	}

	 private static Set<String> pagesVisited = new HashSet<String>();
	 private static List<String> pagesToVisit = new LinkedList<String>();
	  
	public static void search(URL url, String text) throws IOException{
		URL currentUrl;
	
			if(pagesToVisit.isEmpty()){
	              currentUrl = url;
	              System.out.println(currentUrl.toString());
	              pagesToVisit.addAll(getAllLinks(currentUrl,getText(currentUrl)));
	        }
			else{
	              currentUrl = new URL(nextUrl());
	        }
			if(containText(getText(currentUrl),text)){
				pagesVisited.add(currentUrl.toString());
	 			System.out.println("FOUND IN " + currentUrl.toString().toUpperCase());
			}
		
		
	}
	
	private static String nextUrl() {
		String nextUrl;	
		nextUrl=pagesToVisit.remove(0);
		pagesVisited.add(nextUrl);
		return nextUrl;
	}

	private static List<String> getAllLinks(URL url, String content) {
		    String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
	        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
	        Matcher matcher = pattern.matcher(content);
	        while (matcher.find()) {
	        	String w = matcher.group(1);
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
		 System.out.println("Searching for " + "'"+text + "'"+"...");	       
	     return urlText.toLowerCase().contains(text.toLowerCase());
	}
	
	
}
