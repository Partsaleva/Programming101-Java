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
		HttpURLConnection httpcon = (HttpURLConnection)url.openConnection();
		// Reading the feed
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(httpcon));
		
		@SuppressWarnings("unchecked")
		List<SyndEntry> entries = feed.getEntries();
		return null;}

}
