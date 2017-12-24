import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WeatherStation {
    private JSONObject data;
    private WeatherApi weatherApiWorker;

    public boolean update() {
        JSONParser parser = new JSONParser();
        String updatedInfo = weatherApiWorker.update();
        if (!updatedInfo.equals("")) {
            try {
                data = (JSONObject) parser.parse(updatedInfo);
                return true;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public WeatherApi getWeatherApiWorker() {
        return weatherApiWorker;
    }

    public void setWeatherApiWorker(WeatherApi weatherApiWorker) {
        this.weatherApiWorker = weatherApiWorker;
    }

    public WeatherStation() {
        weatherApiWorker = new WeatherApiUcu();
    }


    public String getDescription() {
        if (data == null) {
            update();
        }
        return ((JSONObject) ((JSONArray) data.get("weather")).get(0)).get("description").toString();
    }

    public String getTemperatureInKelvin() {
        if (data == null) {
            update();
        }
        return ((JSONObject) data.get("main")).get("temp").toString();
    }

    public String getTemperatureInCelsius() {
        if (data == null) {
            update();
        }
        return Double.toString(Double.parseDouble(getTemperatureInKelvin()) - 273.15);
    }
}
