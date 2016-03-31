package webCrawler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WebCrawler {

	//using Set for visited sites
	private Set<String> visitedPages=new HashSet<>();
	private List<String> pagesToVisit=new ArrayList<>();
	
	private String nextUrl(){
		String nextUrl;
		do{
            nextUrl = this.pagesToVisit.remove(0);
            
        } while(this.visitedPages.contains(nextUrl));
		
        this.visitedPages.add(nextUrl);
        return nextUrl;
		
	}
	
	public void crawl(String nextURL){} // Give it a URL and it makes an HTTP request for a web page
	public boolean searchForWord(String word){
		return false;} // Tries to find a word on the page ? option
	public List<String> getLinks() {
		return pagesToVisit;}// Returns a list of all the URLs on the page
}
