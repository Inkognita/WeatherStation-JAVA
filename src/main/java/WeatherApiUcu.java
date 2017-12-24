import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class WeatherApiUcu implements WeatherApi {
    private String url = "http://api.openweathermap.org/data/2.5/weather";
    private UrlParameters urlParameters;

    public String update(){
        URL oracle = null;
        try {
            oracle = new URL(url + "?" + urlParameters.encode());
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream())
            );
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public void removeParameter(String key){
        urlParameters.removeParameter(key);
    }
    public WeatherApiUcu(){
        urlParameters = new UrlParameters();
    }

    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url = url;
    }

    public void setParameter(String key, String value) {
        urlParameters.setParameter(key, value);
    }

    public Boolean contains(String key) {
        return urlParameters.contains(key);
    }

    public String getValue(String key) {
        return urlParameters.getValue(key);
    }
}
