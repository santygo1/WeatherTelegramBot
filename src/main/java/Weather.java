import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Weather {

    //Parsing the weather api url to JSON string
    private static String parseURL(URL url) throws IOException {
        Scanner in = new Scanner((InputStream) url.getContent());
        StringBuilder result = new StringBuilder();
        while (in.hasNext()) result.append(in.next());
        return result.toString();
    }

    /**
     * Parsing JSON object to printed result
     * @param json - weather json
     * @param model - weather model object
     * @return printed result string for answer
     */
    private static String parseJSON(JSONObject json, Model model){
        model.setName(json.getString("name"));//city

        JSONObject main = json.getJSONObject("main");
        model.setTemp(main.getDouble("temp"));//temperature
        model.setHumidity(main.getDouble("humidity"));//humidity

        JSONArray weatherArray = json.getJSONArray("weather");
        for(int i = 0; i < weatherArray.length(); i++){
            JSONObject obj = weatherArray.getJSONObject(i);
            model.setIcon((String)obj.get("icon"));
            model.setMain((String)obj.get("main"));
        }

        StringBuilder result = new StringBuilder();
        result.append("Город: ").append(model.getName()).append("\n");
        result.append("Описание: ").append(model.getMain()).append("\n");
        result.append("Температура: ").append(model.getTemp()).append("°C").append("\n");
        result.append("Влажность: ").append(model.getHumidity()).append("\n");
        result.append(" http://openweathermap.org/img/wn/").append(model.getIcon()).append(".png");

        return result.toString();
    }
    public static String getWeather(String message, Model model) throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + message + "&lang=ru&units=metric&exclude=daily&appid=90531c4609de768c32b8696946697243");
        JSONObject object = new JSONObject(parseURL(url));
        return parseJSON(object, model);
    }




}
