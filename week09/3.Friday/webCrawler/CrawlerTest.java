package webCrawler;

public class CrawlerTest {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		WebCrawler webCrawler = new WebCrawler();
		webCrawler.search("http://blog.hackbulgaria.com","Python");
		

		System.out.println("time: " + (System.currentTimeMillis() - start));
	}

}
