package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class PrettyPrinter
 */
@WebServlet("/PrettyPrinter")
public class PrettyPrinter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//gets json string
	public String uglyJSONString() throws IOException{
		URL url=new URL("http://api.openweathermap.org/data/2.5/find?q=Sofia,"
						+ "bg&appid=5c557da33209735e6993f7f1a091851d");
		StringBuilder sb=new StringBuilder();
		URLConnection connection=url.openConnection();
		try(BufferedReader in=new BufferedReader(
				new InputStreamReader(connection.getInputStream()))){
			String line;
			while((line=in.readLine())!=null){
				sb.append(line);
			}
		}
		return sb.toString();		
	}
	
    public PrettyPrinter() {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		response.setContentType("text/json");

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(uglyJSONString());
		String prettyJsonString = gson.toJson(je);

		p.write(prettyJsonString);
		p.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
