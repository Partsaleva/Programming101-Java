package webcrawler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void search(URL url, String text){
		
	}
	
	private static List<String> getAllLinks(String content) {
        ArrayList<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }
        return resultList;
    }
	
	private static String removeTags(URL url) throws IOException{	
		 StringBuilder b=new StringBuilder();
	     try(BufferedReader br = new BufferedReader(new FileReader(url.getFile()))){
		     String line;
		     while ( (line=br.readLine()) != null) {
		       b.append(line.replaceAll("\\<.*?>",""));		       
		     }
	     }
	     return b.toString();
	   }
	
	private static boolean containText(String urlText, String text) throws IOException{
		String[] words = text.split(" ");
		try(BufferedReader br = new BufferedReader(new FileReader(urlText))){
		     String line;
		     while ( (line=br.readLine()) != null) {
		       if (line.contains(words[0])) {
		    	   String sub=line.substring(line.indexOf(words[0]));
		    	   //if line <= text and are equal return true
		    	   //else if are eq ang > move to next line
		       }		       
		     }
	     }
		return false;
		
	}
}
