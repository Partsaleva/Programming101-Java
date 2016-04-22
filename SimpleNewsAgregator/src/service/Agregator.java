package service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class Agregator {

	String getRss(String rss){
		URL url = new URL(rss);
		StringBuilder sb=new StringBuilder();
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
			
		return sb.toString();
		}

	}
}
