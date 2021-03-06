package webCrawler;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WebCrawler {

	//for test
	  private static final int MAX_PAGES_TO_SEARCH = 100;
	  private Set<String> pagesVisited = new HashSet<String>();
	  private List<String> pagesToVisit = new LinkedList<String>();

	  public void search(String url, String needle){
	      while(this.pagesVisited.size() < MAX_PAGES_TO_SEARCH){
	          String currentUrl;
	          SpiderLeg leg = new SpiderLeg();
	          if(this.pagesToVisit.isEmpty()){
	              currentUrl = url;
	              this.pagesVisited.add(url);
	          }
	          else{
	              currentUrl = this.nextUrl();
	          }
	          leg.crawl(currentUrl); // Lots of stuff happening here. Look at the crawl method in
	                                 // SpiderLeg
	          if (leg.searchForWord(needle)) {
	  			// return
	        	  pagesVisited.add(currentUrl);
	  			  System.out.println("FOUND IN" + currentUrl.toUpperCase());
	  		}          
	          this.pagesToVisit.addAll(leg.getLinks());
	      }
	      System.out.println("\n**Done** Visited " + this.pagesVisited.size() + " web page(s)");
	  }


	  
	  // Returns the next URL to visit (in the order that they were found). We also do a check to make
	  // sure this method doesn't return a URL that has already been visited.
	   
	  private String nextUrl(){
	      String nextUrl;
	      do{
	          nextUrl = this.pagesToVisit.remove(0);
	      } while(this.pagesVisited.contains(nextUrl));
	      this.pagesVisited.add(nextUrl);
	      return nextUrl;
	  }
}