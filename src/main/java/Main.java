public class Main {
    public static void main(String[] args) throws Exception {
        WeatherStation weatherStation = new WeatherStation();
        ((WeatherApiUcu) weatherStation.getWeatherApiWorker())
                .setParameter("q", "Lviv");
        ((WeatherApiUcu) weatherStation.getWeatherApiWorker())
                .setParameter("APPID", "5496614f4ca95e6dcc0445c1e7f3916d");
        System.out.println(weatherStation.getDescription());
        System.out.println(weatherStation.getTemperatureInCelsius());
        System.out.println(weatherStation.getTemperatureInKelvin());
    }
}
