package weather_forecasting_tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class WeatherForcastingTool {

	public static void main(String[] args) throws IOException, JSONException {
		WeatherForcastingTool tool = new WeatherForcastingTool();
		URL url=new URL("http://api.openweathermap.org/data/2.5/find?q=Sofia,bg&appid=5c557da33209735e6993f7f1a091851d");
        JSONObject o =tool.getJson(url);
        System.out.println(o);

	}

	private JSONObject getJson(URL url) throws IOException, JSONException {
		URLConnection connection = url.openConnection();
		try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
			String inputLine;
			StringBuilder b = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				b.append(inputLine);
			}
			return new JSONObject(b.toString());
		}

	}

}
