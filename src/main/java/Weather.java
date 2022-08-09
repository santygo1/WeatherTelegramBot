import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Weather {

    public static String getWeather(String message, Model model) throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+message+"&lang=ru&units=metric&exclude=daily&appid=90531c4609de768c32b8696946697243");

        Scanner in = new Scanner((InputStream)url.getContent());
        String result = "";

        while (in.hasNext()){
            result += in.next();
        }

        return result;
    }

}
