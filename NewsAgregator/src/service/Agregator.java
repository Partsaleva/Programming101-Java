package service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class Agregator {

	public String getRss(String rss){
		URL url;
		StringBuilder sb=new StringBuilder();
		
		try {
			url = new URL(rss);
			HttpURLConnection httpcon = (HttpURLConnection)url.openConnection();
			// Reading the feed
			SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = input.build(new XmlReader(httpcon));
			@SuppressWarnings("unchecked")
			List<SyndEntry> entries = feed.getEntries();
			for (SyndEntry syndEntry : entries) {
				sb.append("<h1>" + syndEntry.getTitle() + "</h1>");
				sb.append("<br/>");
				String desc = syndEntry.getDescription().getValue();
				if (desc.endsWith("/>") && desc.length() > 100) {
					desc = desc.substring(0, desc.length()-10);
				}
				sb.append("<div>"+desc + "<a href=" + syndEntry.getLink() + ">" + "more</a></div><hr><br/>");	
			
			}
			
		} catch (IllegalArgumentException | FeedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sb.toString();

	}
}
